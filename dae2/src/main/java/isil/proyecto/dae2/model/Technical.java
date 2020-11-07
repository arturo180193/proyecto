package isil.proyecto.dae2.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tbl_technical")
@Entity
public class Technical {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "technical_id")
    private Long id;
    @Column(length = 50)
    private String name;
    @Column
    private String type;
    @Column(length = 9)
    private String phone;
    @Column(length = 50)
    private String email;
    @Column(length = 50)
    private String adress;

    @OneToMany(mappedBy = "technical", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Report> reports;

}
