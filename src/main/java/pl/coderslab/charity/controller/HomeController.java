package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.JpaInstitutionRepository;

import java.util.List;


@Controller
public class HomeController {

    private final JpaInstitutionRepository repository;

    public HomeController(JpaInstitutionRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("")
    public String homeAction(Model model) {
        List<Institution> institutions = repository.getAllInstitutions();
        model.addAttribute("institutions", institutions);
        return "index";
    }
}
