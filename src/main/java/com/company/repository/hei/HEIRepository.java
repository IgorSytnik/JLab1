package com.company.repository.hei;

import com.company.domain.hei.HigherEducationalInstitution;

import java.util.List;

public interface HEIRepository
//        extends CrudRepository<HigherEducationalInstitution, Long>
{
    HigherEducationalInstitution findById(long id);
    List<HigherEducationalInstitution> findAll();
    HigherEducationalInstitution save(HigherEducationalInstitution higherEducationalInstitution);
    HigherEducationalInstitution update(HigherEducationalInstitution higherEducationalInstitution);
    HigherEducationalInstitution delete(HigherEducationalInstitution higherEducationalInstitution);
}
