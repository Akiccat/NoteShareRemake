package com.akicat.noteshareremake.controller;

import com.akicat.noteshareremake.model.Note;
import com.akicat.noteshareremake.service.impl.NoteServiceImpl;
import com.akicat.noteshareremake.service.impl.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class UploadController {
    @Autowired
    SubjectServiceImpl subjectService;
    @Autowired
    NoteServiceImpl noteService;

    @RequestMapping("/fileUpload")
    @ResponseBody
    public boolean fileUpload(int user_id, int subjectId, String title, List<MultipartFile> uploadfile,
                              HttpServletRequest request, Model model) {
        System.out.println("笔记名  " + title);
        System.out.println("科目ID  " + subjectId);
        // 判断所上传文件是否存在
        if (!uploadfile.isEmpty() && uploadfile.size() > 0) {
            //循环输出上传的文件
            for (MultipartFile file : uploadfile) {
                // 获取上传文件的原始名称
                String originalFilename = file.getOriginalFilename();
                // 设置上传文件的保存地址目录
                String subjectName = subjectService.getSubjectFromId(subjectId).getName();
                String dirPath = subjectName + "/";
                String Path = request.getServletContext().getRealPath("/");
                System.out.println(Path);
                //String dirPath ="D:/devEnvIDEA/IdeaProjects/fileUploadDown/src/main/resources/files/";
                File filePath = new File(dirPath);
                System.out.println("=========dirPath=" + dirPath);
                // 如果保存文件的地址不存在，就先创建目录
                if (!filePath.exists()) {
                    filePath.mkdirs();
                }
                /* 使用UUID（通用唯一标识）重新命名上传的文件名称(上传人_uuid_原始文件名称)
                String newFilename = UUID.randomUUID()+"_"+originalFilename;*/

                //使用时间戳生成NoteCode
                Date d = new Date();
                SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.CHINA);
                java.sql.Date d1 = new java.sql.Date(d.getTime());
                String str = sf.format(d);
                Random r = new Random();
                int i = r.nextInt(100);
                String s = "";
                if (i < 10) {
                    s = "00" + i;
                } else if (i >= 10 && i <= 99) {
                    s = "0" + i;
                }
                String noteCode = str + s;

                try {
                    // 使用MultipartFile接口的方法完成文件上传到指定位置
                    file.transferTo(new File(dirPath + originalFilename));
                   /* request.setAttribute("fileurl","/public/"+ originalFilename);
                    model.addAttribute("fileurl","/public/"+ originalFilename);*/
                    Note note = new Note();
                    note.setUpload_code(noteCode);
                    note.setNote_name(title);
                    note.setIs_free(1);
                    note.setSubject_id(subjectId);
                    note.setUser_id(user_id);
                    note.setPic_path("\\images\\"+subjectName+"\\"+originalFilename);
                    note.setUpload_date(d1);
                    noteService.uploadNote(note);


                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

}
