package pl.coderslab.charity.service;

import pl.coderslab.charity.model.Institution;

import java.util.List;


public interface IInstitutionService {
    List<Institution> getAllInstitutions();

    Institution getInstitutionById(long id);

    void addInstitution(Institution institution);

    void deleteInstitutionById(long id);

    void updateInstitution(Institution institution);
}
