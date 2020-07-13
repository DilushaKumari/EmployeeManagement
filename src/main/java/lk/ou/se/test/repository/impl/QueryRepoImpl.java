package lk.ou.se.test.repository.impl;

import lk.ou.se.test.entity.CustomEntity;
import lk.ou.se.test.repository.QueryRepo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QueryRepoImpl implements QueryRepo {

    @PersistenceContext
    private EntityManager entityManager;

    public List<CustomEntity> getDependentsById(String id)  {
        List<Object[]> resultList = entityManager.createNativeQuery("SELECT e.emp_id,d.dependent_fname,d.dependent_lname FROM Employee  e JOIN Dependent d WHERE e.emp_id=?1")
                .setParameter(1, id)
                .getResultList();
        List<CustomEntity> sendDependents = new ArrayList<>();
        for (Object[] cols : resultList) {
            sendDependents.add(new CustomEntity((String) cols[0], (String) cols[1], (String) cols[2])     );  }
        return sendDependents;
    }
}
