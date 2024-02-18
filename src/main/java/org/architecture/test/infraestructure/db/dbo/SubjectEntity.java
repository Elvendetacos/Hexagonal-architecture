package org.architecture.test.infraestructure.db.dbo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.architecture.test.domain.model.vo.Status;

import java.util.Set;

@Entity
@Table(name = "subjects")
@Getter @Setter
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    private String name;
    private String carrier;
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "subject")
    private Set<TopicEntity> topics;
}
