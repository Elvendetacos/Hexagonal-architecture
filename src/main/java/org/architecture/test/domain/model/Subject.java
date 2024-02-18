package org.architecture.test.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.architecture.test.domain.model.vo.Status;

import java.util.Set;
import java.util.UUID;

@Getter @Setter
public class Subject {
    private String uuid;
    private String name;
    private String carrier;
    private Status status;
    private Set<Topic> topics;
}
