package isil.proyecto.dae2.repository;

import isil.proyecto.dae2.model.Client;
import isil.proyecto.dae2.model.Technical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalRepository extends JpaRepository<Technical,Long> {

    @Query("select c from Technical c where c.id = :id ")
    Technical findByid(String id);


}
