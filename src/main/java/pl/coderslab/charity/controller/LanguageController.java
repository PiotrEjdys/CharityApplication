package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = "language")
public class LanguageController {
//    @GetMapping("/")
//    public String changeLanguageGet() {
//        return "language";
//    }

    @PostMapping("/")
    public String changeLanguage(@RequestParam String language, Model model){
        model.addAttribute("language",language);
        return "redirect:/";
    }
}
