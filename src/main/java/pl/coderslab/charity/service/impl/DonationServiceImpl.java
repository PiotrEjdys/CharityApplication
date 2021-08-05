package pl.coderslab.charity.service.impl;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.service.IDonationService;

import java.util.List;

@Service
public class DonationServiceImpl implements IDonationService {

    private final DonationRepository repository;

    public DonationServiceImpl(DonationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Donation> getAllDonations() {
        return repository.findAll();
    }

    @Override
    public Donation getDonationById(long id) {
        return repository.getDonationById(id);
    }

    @Override
    public void addDonation(Donation donation) {
        repository.save(donation);
    }

    @Override
    public void deleteDonationById(long id) {
        repository.deleteById(id);
    }

    @Override
    public void updateDonation(Donation donation) {
        repository.save(donation);
    }

    @Override
    public Integer getNumberOfBags() {
        return repository.getNumberOfBags();
    }

    @Override
    public Integer getNumberOfDonations() {
        return repository.getNumberOfDonations();
    }

}
