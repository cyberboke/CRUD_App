package com.example.crud_app.controller;

import com.example.crud_app.model.User;
import com.example.crud_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String findAllUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("newUser", new User());
        return "users";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("user", userService.getById(id));
        return "user";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(ModelMap modelMap, @PathVariable("id") long id) {
        modelMap.addAttribute("user", userService.getById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user,
                         @PathVariable("id") long id) {
        userService.edit(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }
}
