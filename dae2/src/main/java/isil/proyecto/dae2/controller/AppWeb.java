package isil.proyecto.dae2.controller;

import isil.proyecto.dae2.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppWeb {

    @GetMapping(value = {"/login", "/"})
    public String login(){
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

    @GetMapping("/menu")
    public String menu(){
        return "menu";
    }

}
