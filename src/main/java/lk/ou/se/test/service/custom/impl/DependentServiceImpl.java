package lk.ou.se.test.service.custom.impl;

import lk.ou.se.test.entity.Dependent;
import lk.ou.se.test.repository.DependentRepo;
import lk.ou.se.test.service.custom.DependentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DependentServiceImpl implements DependentService {

    @Autowired
    private DependentRepo dependentRepo;


    @Override
    public void saveDependent(Dependent dependent) {
        dependentRepo.save(dependent);
    }

    @Override
    public void updateDependent(Dependent dependent) {
        Dependent existingDependent = dependentRepo.findById(dependent.getDependent_id()).orElse(null);
        existingDependent.setDependent_fname(dependent.getDependent_fname());
        existingDependent.setDependent_lname(dependent.getDependent_lname());
        existingDependent.setDependent_mobile(dependent.getDependent_mobile());

        dependentRepo.save(existingDependent);
    }

    @Override
    public void deleteDependent(String dependentId) {
        dependentRepo.deleteById(dependentId);
    }

    @Override
    public List<Dependent> findAllDependents() {
        return dependentRepo.findAll();
    }

    @Override
    public Dependent findDependentById(String dependentId) {
        return dependentRepo.findById(dependentId).orElse(null);
    }

}
