package com.example.web1.servingwebcontent;

import com.example.web1.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("user", new User());

        return "greeting";
    }

    @RequestMapping(value = "/submitName", method = RequestMethod.POST)
    public String submitName(@ModelAttribute User user, BindingResult errors, Model model) {
        model.addAttribute("name", user.getName());

        return "greeting";
    }

}
