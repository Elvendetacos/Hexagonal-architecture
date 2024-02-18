package org.architecture.test.infraestructure.db.repository;

import org.architecture.test.infraestructure.db.dbo.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataSubjectRepository extends JpaRepository<SubjectEntity, String> {
    SubjectEntity findByName(String uuid);
}
