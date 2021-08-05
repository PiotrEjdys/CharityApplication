package pl.coderslab.charity.service.impl;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.service.IInstitutionService;

import java.util.List;

@Service
public class InstitutionServiceImpl implements IInstitutionService {

    private final InstitutionRepository repository;

    public InstitutionServiceImpl(InstitutionRepository repository) {
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
