package com.akicat.noteshareremake.controller;

import com.akicat.noteshareremake.model.PayDetail;
import com.akicat.noteshareremake.model.User;
import com.akicat.noteshareremake.service.impl.PayServiceImpl;
import com.akicat.noteshareremake.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

@Controller
public class PayController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    PayServiceImpl payService;
    @RequestMapping("notePay.action")
    public String notePay(int note_id, int user_id, String note_code, String word, int price, HttpSession session, Model model) {
        System.out.println("笔记ID: " + note_id);
        System.out.println("上传笔记的用户ID:" + user_id);
        System.out.println("笔记码:" + note_code);
        System.out.println("留言: " + word);
        System.out.println("价格: " + price);
        PayDetail payDetail = new PayDetail();

        //使用时间戳生成PayCode
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
        String PayCode = str + s;


        User user = (User) session.getAttribute("USER_SESSION");
        System.out.println("SessionUser: "+user);
        payDetail.setPay_code(PayCode);
        payDetail.setPay_date(d1);
        payDetail.setNote_id(note_id);
        payDetail.setNote_code(note_code);
        payDetail.setSrc_userid(user.getUser_id());
        payDetail.setDst_userid(user_id);
        payDetail.setWord(word);
        payDetail.setPrice(price);
        payDetail.setState(1);
        payDetail.setDst_username(userService.getUserFromUserId(user_id).getUser_name());
        payDetail.setSrc_username(userService.getUserFromUserId(user.getUser_id()).getUser_name());
        System.out.println("支付详情: "+payDetail);
        int pay = payService.insertPayDetail(payDetail);
        model.addAttribute("payDetail",payDetail);
        return "pay";
    }

    @RequestMapping("payConfirm.action")
    public String payConfirm(Model model,String payCode) {
        payService.updatePayState(payCode);
        model.addAttribute("payState","Success");
        return "pay";
    }
}
