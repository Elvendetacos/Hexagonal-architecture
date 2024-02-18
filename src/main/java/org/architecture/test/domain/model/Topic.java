package org.architecture.test.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.architecture.test.domain.model.vo.Status;

@Getter
@Setter
public class Topic {
    private String uuid;
    private String name;
    private Status status;
    private Subject subject;
}
