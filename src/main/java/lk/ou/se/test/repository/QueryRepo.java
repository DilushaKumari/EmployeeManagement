package lk.ou.se.test.repository;

import lk.ou.se.test.entity.CustomEntity;

import java.util.List;

public interface QueryRepo {
    List<CustomEntity> getDependentsById(String id);
}
