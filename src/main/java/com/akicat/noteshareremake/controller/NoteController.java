package com.akicat.noteshareremake.controller;

import com.akicat.noteshareremake.model.Note;
import com.akicat.noteshareremake.model.NoteDetail;
import com.akicat.noteshareremake.model.PayDetail;
import com.akicat.noteshareremake.service.impl.NoteServiceImpl;
import com.akicat.noteshareremake.service.impl.PayServiceImpl;
import com.akicat.noteshareremake.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class NoteController {
    @Autowired
    NoteServiceImpl noteService;
    @Autowired
    UserServiceImpl userService;

    @Autowired
    PayServiceImpl payService;

    @RequestMapping("noteDetail.action")
    public String noteDetail(String note_id, Model model) {
        NoteDetail noteDetail = noteService.noteDetailFromId(Integer.parseInt(note_id));
        noteDetail.setUpload_user(userService.getUserFromUserId(noteDetail.getUser_id()).getUser_name());
        noteDetail.setUser_email(userService.getUserFromUserId(noteDetail.getUser_id()).getUser_email());
        List<PayDetail> payDetails = payService.getPayDetailFromNoteId(Integer.parseInt(note_id));
        for (PayDetail payDetail : payDetails) {
            payDetail.setSrc_username(userService.getUserFromUserId(payDetail.getSrc_userid()).getUser_name());
        }
        /*System.out.println("笔记ID: " + note_id);
        System.out.println("笔记详情 " + noteDetail);
        System.out.println("支付详情 "+payDetails);*/
        int subjectId = noteService.getNoteFormNoteId(Integer.parseInt(note_id)).getSubject_id();
        model.addAttribute("payDetails",payDetails);
        model.addAttribute("noteDetail", noteDetail);
        model.addAttribute("SubjectId",subjectId);
        return "NoteDetail";
    }

    @RequestMapping("delNote.action")
    @ResponseBody
    public boolean delNote(String noteCode){
        int i = noteService.delNoteFromNoteCode(noteCode);
        if (i != 0){
            /*System.out.println("删除成功");*/
            return true;
        }
        else{
            return false;
        }
    }

    @RequestMapping("searchNote.action")
    public String searchNote(String noteName,Model model){
        String searchName = "%"+noteName+"%";
        List<Note> notes = noteService.getNoteFromNoteNameLike(searchName);
        /*System.out.println(searchName);
        System.out.println("搜索到的笔记 "+notes);*/
        model.addAttribute("NoteList",notes);
        model.addAttribute("SearchPage","搜索笔记");
        return "NotePage";
    }
}
