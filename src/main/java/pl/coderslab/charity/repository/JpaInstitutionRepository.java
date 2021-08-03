package pl.coderslab.charity.repository;

import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;

public class JpaInstitutionRepository implements InstitutionService {

    private final InstitutionRepository repository;

    public JpaInstitutionRepository(InstitutionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Institution> getAllInstitutions() {
        return repository.findAll();
    }

    @Override
    public Institution getInstitutionById(long id) {
        return repository.getInstitutionById(id);
    }

    @Override
    public void addInstitution(Institution institution) {
        repository.save(institution);
    }

    @Override
    public void deleteInstitutionById(long id) {
        repository.deleteById(id);
    }

    @Override
    public void updateInstitution(Institution institution) {
        repository.save(institution);
    }
}
