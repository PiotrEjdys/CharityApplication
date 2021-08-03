package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.model.Donation;


public interface DonationRepository extends JpaRepository<Donation,Long> {

    @Query(value = "SELECT d FROM Donation d where d.id=?1")
    Donation getDonationById(long id);

    @Query(value = "SELECT SUM(d.quantity) FROM Donation  d")
    Integer getNumberOfBags();
}
