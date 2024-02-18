package org.architecture.test.infraestructure.db.repository;

import org.architecture.test.infraestructure.db.dbo.SubjectEntity;
import org.architecture.test.infraestructure.db.dbo.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataTopicRepository extends JpaRepository<TopicEntity, String> {
    TopicEntity findByName(String uuid);
    void deleteAllBySubject(SubjectEntity subject);
}
