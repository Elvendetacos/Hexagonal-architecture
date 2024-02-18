package org.architecture.test.application.services;

import lombok.RequiredArgsConstructor;
import org.architecture.test.application.usecase.ITopicService;
import org.architecture.test.domain.model.Subject;
import org.architecture.test.domain.model.Topic;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class TopicService {
    private final ITopicService topicService;

    private Topic findByUuid(String uuid){
        return topicService.findByUuid(uuid);
    }

    private List<Topic> findAll(){
        return topicService.findAll();
    }

    private Topic update(Topic topic, String uuid){
        return topicService.update(topic, uuid);
    }

    private void updateSubject(Set<Topic> topics, Subject subject){
        topicService.updateSubject(topics, subject);
    }

    private void delete(String uuid){
        topicService.delete(uuid);
    }
}
