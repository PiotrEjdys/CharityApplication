package pl.coderslab.charity.repository;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.service.DonationService;

import java.util.List;
@Service
public class JpaDonationRepository implements DonationService {

    private final DonationRepository repository;

    public JpaDonationRepository(DonationRepository repository) {
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
}
