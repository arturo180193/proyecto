package isil.proyecto.dae2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tbl_report")
@Entity
public class Report {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "report_id")
    private Long id;

    @Column
    private String description;

    @Column(length = 20)
    private String location;

    @Column
    private String status;

    @Column(name = "client_id")
    private Long idclient;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private Client client;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "technical_id", insertable = false, updatable = false)
    private Technical technical;

}
