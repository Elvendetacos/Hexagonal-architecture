package org.architecture.test.infraestructure.db.mapper;

import org.architecture.test.domain.model.Subject;
import org.architecture.test.domain.model.Topic;
import org.architecture.test.infraestructure.db.dbo.SubjectEntity;
import org.architecture.test.infraestructure.db.dbo.TopicEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TopicMapperEntity {
    Topic toDomain(TopicEntity topicEntity);
    @Mapping(target = "topic", ignore = true)
    TopicEntity toEntity(Topic topic);
}
