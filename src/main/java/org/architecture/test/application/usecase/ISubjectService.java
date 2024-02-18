package org.architecture.test.application.usecase;

import org.architecture.test.domain.model.Subject;

public interface ISubjectService {
    Subject save(Subject subject);
    Subject findByUuid(String uuid);
    Subject update(Subject subject, String uuid);
    void delete(String uuid);
}
