package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.email.serviceimpl.EmailServiceImpl;
import pl.coderslab.charity.model.RandomToken;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;

@Controller
public class RegisterController {

    private final UserService userService;
    private final EmailServiceImpl emailService;

    public RegisterController(UserService userService, EmailServiceImpl emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    @GetMapping("/register")
    public String getRegistrationForm(User user) {
        return "register";
    }

    @PostMapping("/register")
    public String postRegistrationForm(@Valid User user, BindingResult result, @RequestParam String password2) {
        if (result.hasErrors() || !user.getPassword().equals(password2)) {
            return "register";
        } else {
            String token = RandomToken.generateRandom();
            user.setToken(token);
            userService.saveUser(user);
            emailService.sendSimpleMessage
                    (user.getUsername(), "Weryfikcaj adresu email",
                            "Aby dokończyć rejestrację kliknij w link: "+"http://localhost:8080/register/"+user.getToken());
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/register/{token}",method = {RequestMethod.GET,RequestMethod.POST})
    public String confirmationGet(@PathVariable String token){
        User user = userService.findUserByToken(token);
        user.setToken(null);
        user.setEnabled(true);
        userService.updateUser(user);

        return "redirect:/login";

    }
//    @PostMapping("/register/{token}")
//    public String confirmRegistration(@PathVariable String token){
//        User user = userService.findUserByToken(token);
//        user.setToken(null);
//        user.setEnabled(true);
//        userService.updateUser(user);
//
//        return "redirect:/login";
//    }


}
