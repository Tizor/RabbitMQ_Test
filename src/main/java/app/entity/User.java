package app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class User {

    @Id
    @Column(name = "customer_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Long age;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "userNote", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("userNote")
    private List<Note> notes = new ArrayList<>();

}
