package peaksoft.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
@ToString
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "group_name")
    private String groupName;
    private String dateOfStart;
    private String dateOfFinish;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Course> courses=new ArrayList<>();

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Student>students=new ArrayList<>();

    public void setCourse(Course course){
        this.courses.add(course);
    }
    public void setStudent(Student student){
        this.students.add(student);
    }

}
