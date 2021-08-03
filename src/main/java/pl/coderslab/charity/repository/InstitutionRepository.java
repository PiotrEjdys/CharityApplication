package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.model.Institution;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {
    @Query(value = "SELECT i FROM Institution i where i.id=?1")
    Institution getInstitutionById(long id);
}
