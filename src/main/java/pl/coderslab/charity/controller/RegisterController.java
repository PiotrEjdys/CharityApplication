package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.email.serviceimpl.EmailServiceImpl;
import pl.coderslab.charity.model.RandomToken;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.UserService;

import javax.servlet.http.HttpSession;
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
    public String postRegistrationForm(@Valid User user, BindingResult result, @RequestParam String password2, HttpSession session) {
        if (result.hasErrors() || !user.getPassword().equals(password2) || userService.findByUserName(user.getUsername()) !=null) {
            return "register";
        } else {
            String token = RandomToken.generateRandom();
            user.setToken(token);
            userService.saveUser(user);
            String lang = (String) session.getAttribute("language");
            if (lang.equals("pl")){
                String polishMailSubject="Weryfikcaj adresu email";
                String polishMailText="Aby dokończyć rejestrację kliknij w link: http://localhost:8080/register/"+user.getToken();
                emailService.sendSimpleMessage
                        (user.getUsername(), polishMailSubject,
                                polishMailText);
            }else if (lang.equals("en")){
                String englishMailSubject="Email verification";
                String englishMailText="Open this link to finish registration http://localhost:8080/register/"+user.getToken();
                emailService.sendSimpleMessage
                        (user.getUsername(), englishMailSubject,
                                englishMailText);
            }
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
}
