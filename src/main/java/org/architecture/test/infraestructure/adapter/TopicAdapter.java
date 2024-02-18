package org.architecture.test.infraestructure.adapter;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.architecture.test.application.usecase.ITopicService;
import org.architecture.test.domain.model.Subject;
import org.architecture.test.domain.model.Topic;
import org.architecture.test.infraestructure.db.dbo.SubjectEntity;
import org.architecture.test.infraestructure.db.dbo.TopicEntity;
import org.architecture.test.infraestructure.db.mapper.SubjectMapperEntity;
import org.architecture.test.infraestructure.db.mapper.TopicMapperEntity;
import org.architecture.test.infraestructure.db.repository.DataTopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class TopicAdapter implements ITopicService {

    private final DataTopicRepository repository;
    private final TopicMapperEntity mapper;
    private final SubjectMapperEntity subjectMapper;

    @Override
    public void save(Set<Topic> topics, Subject subject) {
        SubjectEntity subjectEntity = subjectMapper.toEntity(subject);
        List<TopicEntity> topic = topics.stream()
                .map(topicsParse -> this.toTopicEntity(topicsParse, subjectEntity)).toList();
        repository.saveAll(topic);
    }

    @Override
    public Topic findByUuid(String uuid) {
        TopicEntity topicEntity = repository.findById(uuid).orElseThrow(EntityNotFoundException::new);
        return mapper.toDomain(topicEntity);
    }

    @Override
    public List<Topic> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public Topic update(Topic topic, String uuid) {
        TopicEntity topicEntity = repository.findById(uuid).orElseThrow(EntityNotFoundException::new);
        topicEntity.setName(topic.getName());
        topicEntity.setStatus(topic.getStatus());
        repository.save(topicEntity);
        return mapper.toDomain(topicEntity);
    }

    @Override
    public void updateSubject(Set<Topic> topics, Subject subject) {
    }

    @Override
    public void delete(String uuid) {
        TopicEntity topicEntity = repository.findById(uuid).orElseThrow(EntityNotFoundException::new);
        repository.delete(topicEntity);
    }

    private TopicEntity toTopicEntity(Topic topic, SubjectEntity subjectEntity) {
        TopicEntity themeEntity = mapper.toEntity(topic);
        themeEntity.setSubject(subjectEntity);
        return themeEntity;
    }
}
