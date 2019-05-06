package com.thymeleaf.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 主页控制器
 */
@Controller
public class MainController {
    @GetMapping("/")
    public String root() {
        return "redirect:/index";
    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login-error")
    public String loginErr(Model model) {
        model.addAttribute("loginError", true);
        model.addAttribute("errorMsg", "登录失败, 账号或密码错误");
        return "login";
    }
}