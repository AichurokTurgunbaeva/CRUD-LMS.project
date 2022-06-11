package peaksoft.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter
@ToString
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    private String locatedCountry;

    @OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private List<Course> courses=new ArrayList<>();

    public void setCourse(Course course) {
        this.courses.add(course);
    }
}
