package com.akicat.noteshareremake.controller;

import com.akicat.noteshareremake.model.User;
import com.akicat.noteshareremake.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserCenterController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/usercenter.info")
    public String UserCenterAction(HttpSession session, Model model) {
        User sessionUser = (User) session.getAttribute("USER_SESSION");
        //获取用户数据
        User user = userService.getUserFromUserId(sessionUser.getUser_id());
        User newUser = new User();
        newUser.setUser_age(user.getUser_age());
        newUser.setUser_name(user.getUser_name());
        newUser.setUser_sex(user.getUser_sex());
        newUser.setUser_email(user.getUser_email());
        model.addAttribute("userInfo", newUser);
        return "usercenter/updatePersonalInfo";
    }

    @RequestMapping("/usercenter.password")
    public String UserPasswordAction() {
        return "usercenter/updatePersonalPassword";
    }

    @RequestMapping("updatePersonalInfo.action")
    @ResponseBody
    public Map updatePersonalInfo(User user, HttpSession session) {
        User preUser = (User) session.getAttribute("USER_SESSION");
        System.out.println("preuser" + preUser);
        user.setUser_id(preUser.getUser_id());
        System.out.println("newuser" + user);
        int i = userService.updateUserInfo(user);
        Map map = new HashMap();
        if (i != 0) {
            System.out.println("成功");
            map.put("update", true);
        } else {
            map.put("update", false);
        }
        return map;
    }

    @RequestMapping("updatePersonalPassword.action")
    @ResponseBody
    public boolean updatePersonalPassword(String userPass, String newUserPass, HttpSession session) {
        User preUser = (User) session.getAttribute("USER_SESSION");
        System.out.println("preuser " + preUser);
        System.out.println("UserPass "+ userPass);
        System.out.println("当前密码 " + preUser.getUser_pass());
        System.out.println("要修改密码 " + newUserPass);
        if(userPass.equals(preUser.getUser_pass())){
            preUser.setUser_pass(newUserPass);
            User user = new User();
            user.setUser_id(preUser.getUser_id());
            user.setUser_pass(newUserPass);
            int i = userService.updateUserPass(user);
            System.out.println(i);
            return i!=0;
        }
        else
            return false;
    }
}
