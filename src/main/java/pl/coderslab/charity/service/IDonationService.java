package pl.coderslab.charity.service;

import pl.coderslab.charity.model.Donation;

import java.util.List;


public interface IDonationService {
    List<Donation> getAllDonations();

    Donation getDonationById(long id);

    void addDonation(Donation donation);

    void deleteDonationById(long id);

    void updateDonation(Donation donation);

    Integer getNumberOfBags();

    Integer getNumberOfDonations();
}
