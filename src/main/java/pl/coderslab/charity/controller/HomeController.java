package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.UserService;
import pl.coderslab.charity.service.impl.DonationServiceImpl;
import pl.coderslab.charity.service.impl.InstitutionServiceImpl;

import java.util.List;


@Controller
public class HomeController {

    private final InstitutionServiceImpl institutionRepository;
    private final DonationServiceImpl donationRepository;
    private final UserService userService;

    public HomeController(InstitutionServiceImpl institutionRepository, DonationServiceImpl donationRepository, UserService userService) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
        this.userService = userService;
    }

    @RequestMapping("/")
    public String homeAction(Model model) {
        List<Institution> institutions = institutionRepository.getAllInstitutions();
        Integer numberOfBags = donationRepository.getNumberOfBags();
        Integer numberOfDonations = donationRepository.getNumberOfDonations();
        model.addAttribute("totalBags", numberOfBags);
        model.addAttribute("institutions", institutions);
        model.addAttribute("totalDonations", numberOfDonations);
        return "index";
    }
}
