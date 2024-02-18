package org.architecture.test.application.usecase;

import org.architecture.test.domain.model.Subject;
import org.architecture.test.domain.model.Topic;

import java.util.List;
import java.util.Set;

public interface ITopicService {
    void save(Set<Topic> topics, Subject subject);
    Topic findByUuid(String uuid);
    List<Topic> findAll();
    Topic update(Topic topic, String uuid);
    void updateSubject(Set<Topic> topics, Subject subject);
    void delete(String uuid);
}
