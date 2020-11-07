package isil.proyecto.dae2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tbl_client")
@Entity
public class Client {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "client_id")
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String adress;
    @Column(length = 50)
    private String email;
    @Column(length = 16)
    private String credicard;
    @Column(length = 9)
    private String phone;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Report> reports;

}
