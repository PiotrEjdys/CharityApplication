package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Institution;

import java.util.List;

@Service
public interface InstitutionService {
    List<Institution> getAllInstitutions();

    Institution getInstitutionById(long id);

    void addInstitution(Institution institution);

    void deleteInstitutionById(long id);

    void updateInstitution(Institution institution);
}
