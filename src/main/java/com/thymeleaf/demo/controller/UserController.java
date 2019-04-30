package com.thymeleaf.demo.controller;

import com.thymeleaf.demo.entity.User;
import com.thymeleaf.demo.repository.IUserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserRespository userRespository;

    @GetMapping
    public ModelAndView list(Model model) {
        List<User> users = userRespository.listUsers();
        model.addAttribute("userList", users);
        model.addAttribute("title", "用户管理");
        return new ModelAndView("/users/list", "userModel", model);
    }

    /**
     * 根据 id 查询用户
     */
    @GetMapping("/{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model) {
        User user = userRespository.findUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "查看用户");
        return new ModelAndView("/users/view", "userModel", model);
    }

    /**
     * 获取创建表单页面
     * @param model
     * @return
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "创建用户");
        return new ModelAndView("/users/form", "userModel", model);
    }

    @PostMapping
    public ModelAndView saveOrUpdate(User user) {
        User dbUser = userRespository.saveOrUpdateUser(user);
        if (dbUser != null) {
            return new ModelAndView("redirect:/users");
        }
        return new ModelAndView("redirect:/users/form");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id, Model model) {
        userRespository.deleteUserById(id);
        return new ModelAndView("redirect:/users");
    }

    /**
     * 根据 id 获取修改用户
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/modify/{id}")
    public ModelAndView modify(@PathVariable("id") Long id, Model model) {
        User user = userRespository.findUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("/users/form", "userModel", model);
    }

}
