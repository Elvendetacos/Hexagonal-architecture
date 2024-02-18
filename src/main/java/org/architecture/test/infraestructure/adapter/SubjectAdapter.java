package org.architecture.test.infraestructure.adapter;

import jakarta.persistence.Access;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.architecture.test.application.usecase.ISubjectService;
import org.architecture.test.application.usecase.ITopicService;
import org.architecture.test.domain.model.Subject;
import org.architecture.test.infraestructure.db.dbo.SubjectEntity;
import org.architecture.test.infraestructure.db.dbo.TopicEntity;
import org.architecture.test.infraestructure.db.mapper.SubjectMapperEntity;
import org.architecture.test.infraestructure.db.repository.DataSubjectRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SubjectAdapter implements ISubjectService {
    private final DataSubjectRepository repository;
    private final SubjectMapperEntity mapper;
    private final ITopicService topicService;

    @Override
    public Subject save(Subject subject) {
        SubjectEntity subjectEntity = repository.save(mapper.toEntity(subject));
        Subject saved = mapper.toDomain(subjectEntity);
        topicService.save(subject.getTopics(), saved);
        return saved;
    }

    @Override
    public Subject findByUuid(String uuid) {
        SubjectEntity subjectEntity = repository.findById(uuid).orElseThrow(EntityNotFoundException::new);
        return mapper.toDomain(subjectEntity);
    }

    @Override
    public Subject update(Subject subject, String uuid) {
        SubjectEntity subjectEntity = repository.findById(uuid).orElseThrow(EntityNotFoundException::new);
        subjectEntity.setUuid(subject.getUuid());
        subjectEntity.setName(subject.getName());
        subjectEntity.setCarrier(subject.getCarrier());
        subjectEntity.setStatus(subject.getStatus());
        SubjectEntity updated = repository.save(subjectEntity);
        return mapper.toDomain(updated);
    }

    @Override
    public void delete(String uuid) {
        SubjectEntity subjectEntity = repository.findById(uuid).orElseThrow(EntityNotFoundException::new);
        repository.delete(subjectEntity);
    }
}
