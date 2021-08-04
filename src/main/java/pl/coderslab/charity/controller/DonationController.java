package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.JpaCategoryRepository;
import pl.coderslab.charity.repository.JpaDonationRepository;
import pl.coderslab.charity.repository.JpaInstitutionRepository;

import java.util.List;

@Controller
public class DonationController {
    private final JpaCategoryRepository categoryRepository;
    private final JpaInstitutionRepository institutionRepository;
    private final JpaDonationRepository donationRepository;

    public DonationController(JpaCategoryRepository categoryRepository, JpaInstitutionRepository institutionRepository, JpaDonationRepository donationRepository) {
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }

    @GetMapping("/form")
    public String getForm(Donation donation){
        return "form";
    }
    @PostMapping("/form")
    public String postForm(Donation donation){
        donationRepository.addDonation(donation);
        return "redirect:/formConfirmation";
    }
    @GetMapping("/formConfirmation")
    public String getFormConfirm(){
        return "form-confirmation";
    }

    @ModelAttribute("categories")
    List<Category> getAllCategories(){
        return categoryRepository.getAllCategories();
    }
    @ModelAttribute("institutions")
    List<Institution> getAllInstitutions(){
        return institutionRepository.getAllInstitutions();
    }
}
