package com.example.shixun.controller;


import com.example.shixun.pojo.Message;
import com.example.shixun.pojo.User;
import com.example.shixun.service.MessageService;
import com.example.shixun.service.MessageServiceImpl;
import com.example.shixun.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.swing.text.Style;
import java.util.List;

@Controller
public class UserController {

    @Resource
    UserServiceImpl userService;

    @Resource
    MessageServiceImpl messageService;
    /*
     *
     *
     * 登陆
     *
     * */
    @RequestMapping("/login")
    //@ResponseBody
    public String loginCheck(String username,String password,Model model, HttpSession session){

        if(username!=null&&password!=null) {
            User user = userService.login(username);
            if(user!=null) {
                if(user.getPwd().equals(password)) {
                    session.setAttribute("loginUser", username);

                    List<Message> messages=messageService.queryMessage();
                    model.addAttribute("messages",messages);
                    System.out.println("messsage:========"+messages);
                    return "redirect:/index";
                }
                else{
                    model.addAttribute("msg","密码错误");
                    return  "login";
                }
            }
            else{
                model.addAttribute("msg","账号错误");
                return  "login";
            }
        }
        else{
            model.addAttribute("msg","账号或密码不能为空");
            return  "login";
        }

    }


    @RequestMapping("/")
    public String login(){

        return  "login";
    }


    /*
     *
     *
     * 首页
     *
     * */
    @RequestMapping("/index")
    public String index(Model model){

        List<Message> messages=messageService.queryMessage();
        model.addAttribute("messages",messages);
        System.out.println("messsage:========"+messages);
        return  "/index";
    }


    /*
     *
     * 添加页面
     *
     * */
    @RequestMapping("/add")
    public String add(){

        return  "/add";
    }


    /*
     *
     *
     * 添加信息
     *
     * */
    @RequestMapping("/addmessage")
    public String addMessage(Message message){

        int n= messageService.addMessage(message);
        return "redirect:/index";

    }

    /*
     *
     * 删除信息
     * */
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id){

        int n=messageService.deleteMessage(id);
        return "redirect:/index";

    }



    /*
     *
     * 更改信息
     * */
    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id") String id,Model model){

        Message message=messageService.queryMessageById(id);
        model.addAttribute("message",message);
        return "update";

    }
    /*
     *
     * 更改信息
     * */
    @RequestMapping("/update")
    public String updateMessage(Message message,Model model){

        int n=messageService.updateMessage(message);

        return "redirect:/index";

    }

    /*
     *
     * 搜索信息
     * */
    @RequestMapping("/search")
    public String searchMessage(String content,Model model){


        List<Message> messages=messageService.queryByMessage(content);
        model.addAttribute("messages",messages);
        System.out.println("=========ddd"+messages);
        return "index";

    }


    /*
     *
     * 搜索信息
     * */
    @RequestMapping("/quit")
    public String quit(HttpSession session){

        session.invalidate();

        return "login";

    }

}