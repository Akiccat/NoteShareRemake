package com.akicat.noteshareremake.controller;


import com.akicat.noteshareremake.model.Note;
import com.akicat.noteshareremake.model.Subject;
import com.akicat.noteshareremake.model.User;
import com.akicat.noteshareremake.service.UserService;
import com.akicat.noteshareremake.service.impl.NoteServiceImpl;
import com.akicat.noteshareremake.service.impl.SubjectServiceImpl;
import com.akicat.noteshareremake.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;


import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private SubjectServiceImpl subjectService;

    @Autowired
    private NoteServiceImpl noteService;


    @RequestMapping("/indexAction")
    public String indexAction() {
        return "UserIndex";
    }

    @RequestMapping("/SubjectAction")
    public String SubjectAction(Model model) {
        List<Subject> subjectList = subjectService.getSubjectList();
        model.addAttribute("SubjectList",subjectList);
        return "Choose";
    }
    @RequestMapping("/chartAction")
    public String chartAction() {
        return "chart";
    }

    @RequestMapping("/login.action")
    @ResponseBody
    public String loginAction(Model model, String userName, String userPass, HttpSession session) {
        // 通过账号和密码查询用户
        /*System.out.println(userName+userPass);*/
        User user = userService.getCheckUser(userName, userPass);
        if (user != null) {
            /*System.out.println("Login success");*/
            // 将用户对象添加到Session
            session.setAttribute("USER_SESSION", user);
            return "{\"login\":true,\"username\":\"" + userName + "\"}";
        }
        /*System.out.println("Login failed");*/
        model.addAttribute("msg", "账号或密码错误，请重新输入！");
        // 返回到登录页面
        return "{\"login\":false,\"msg\":\"用户名或密码错误\"}";
    }

    @RequestMapping("reg.action")
    @ResponseBody
    public Map regAction(User user) {
        int i = userService.addUser(user);
        Map map = new HashMap();
        if (i != 0) {
            map.put("reg",true);
        } else {
            map.put("reg",false);
        }
        System.out.println("注册"+i);
        return map;
    }
    @RequestMapping("logout.action")
    @ResponseBody
    public Map logOut(HttpSession session){
        System.out.println("用户已登出");
        session.invalidate();
        Map map = new HashMap();
        map.put("msg","success");
        return map;
    }
    @RequestMapping("Choose.action")
    public String ChooseAction(String subjectId,Model model){
        List<Note> notes = noteService.getNoteFormSubject(Integer.parseInt(subjectId));
        model.addAttribute("NoteList",notes);
        Subject subject = subjectService.getSubjectFromId(Integer.parseInt(subjectId));
        model.addAttribute("subject",subject.getName());
        model.addAttribute("subjectId",subject.getSubject_id());
        return "NotePage";
    }



}
