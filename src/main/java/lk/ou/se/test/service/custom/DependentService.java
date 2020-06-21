package lk.ou.se.test.service.custom;

import lk.ou.se.test.entity.Dependent;
import lk.ou.se.test.service.SuperService;

import java.util.List;

public interface DependentService extends SuperService {

    void saveDependent(Dependent dependent);

    void updateDependent(Dependent dependent);

    void deleteDependent(String dependentId) ;

    List<Dependent> findAllDependents() ;

    Dependent findDependentById(String dependentId);



}
