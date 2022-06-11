package peaksoft.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import peaksoft.enums.StudyFormat;
import javax.persistence.*;
import static javax.persistence.CascadeType.MERGE;

@Entity
@Table(name = "students")
@Getter
@Setter
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    private String email;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "study_format")
    private StudyFormat studyFormat;
    @ManyToOne(cascade = {MERGE})
    private Group group;
}

