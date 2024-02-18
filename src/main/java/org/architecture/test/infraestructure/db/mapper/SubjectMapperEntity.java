package org.architecture.test.infraestructure.db.mapper;

import org.architecture.test.domain.model.Subject;
import org.architecture.test.infraestructure.db.dbo.SubjectEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface SubjectMapperEntity {
    Subject toDomain(SubjectEntity subjectEntity);
    @Mapping(target = "subject", ignore = true)
    SubjectEntity toEntity(Subject subject);
}
