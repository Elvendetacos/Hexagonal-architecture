package org.architecture.test.infraestructure.db.dbo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.architecture.test.domain.model.vo.Status;

@Entity
@Table(name = "topics")
@Getter @Setter
public class TopicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @ManyToOne
    private SubjectEntity subject;
}
