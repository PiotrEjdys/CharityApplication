package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.JpaDonationRepository;
import pl.coderslab.charity.repository.JpaInstitutionRepository;

import java.util.List;


@Controller
public class HomeController {

    private final JpaInstitutionRepository institutionRepository;
    private final JpaDonationRepository donationRepository;

    public HomeController(JpaInstitutionRepository institutionRepository, JpaDonationRepository donationRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }

    @RequestMapping("")
    public String homeAction(Model model) {
        List<Institution> institutions = institutionRepository.getAllInstitutions();
        Integer numberOfBags = donationRepository.getNumberOfBags();
        model.addAttribute("totalBags",numberOfBags);
        model.addAttribute("institutions", institutions);
        return "index";
    }
}
