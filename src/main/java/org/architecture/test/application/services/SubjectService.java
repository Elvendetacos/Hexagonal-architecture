package org.architecture.test.application.services;

import lombok.RequiredArgsConstructor;
import org.architecture.test.application.usecase.ISubjectService;
import org.architecture.test.domain.model.Subject;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SubjectService {
    private final ISubjectService subjectService;

    public Subject save(Subject subject){
        return subjectService.save(subject);
    }
    public Subject findByUuid(String uuid){
        return subjectService.findByUuid(uuid);
    }
    public Subject update(Subject subject, String uuid){
        return subjectService.update(subject, uuid);
    }
    public void delete(String uuid){
        subjectService.delete(uuid);
    }

}
