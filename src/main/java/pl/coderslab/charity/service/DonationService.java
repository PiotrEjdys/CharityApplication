package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;

import java.util.List;


public interface DonationService {
    List<Donation> getAllDonations();

    Donation getDonationById(long id);

    void addDonation(Donation donation);

    void deleteDonationById(long id);

    void updateDonation(Donation donation);
}
