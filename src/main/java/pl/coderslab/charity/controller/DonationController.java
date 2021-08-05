package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.impl.CategoryServiceImpl;
import pl.coderslab.charity.service.impl.DonationServiceImpl;
import pl.coderslab.charity.service.impl.InstitutionServiceImpl;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DonationController {
    private final CategoryServiceImpl categoryRepository;
    private final InstitutionServiceImpl institutionRepository;
    private final DonationServiceImpl donationRepository;

    public DonationController(CategoryServiceImpl categoryRepository, InstitutionServiceImpl institutionRepository, DonationServiceImpl donationRepository) {
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }

    @GetMapping("/form")
    public String getForm(Donation donation) {
        return "form";
    }

    @PostMapping("/form")
    public String postForm(@Valid Donation donation, BindingResult result) {
        if (result.hasErrors()) {
            return "form";
        }
        donationRepository.addDonation(donation);
        return "redirect:/formConfirmation";
    }

    @GetMapping("/formConfirmation")
    public String getFormConfirm() {
        return "form-confirmation";
    }

    @ModelAttribute("categories")
    List<Category> getAllCategories() {
        return categoryRepository.getAllCategories();
    }

    @ModelAttribute("institutions")
    List<Institution> getAllInstitutions() {
        return institutionRepository.getAllInstitutions();
    }
}
