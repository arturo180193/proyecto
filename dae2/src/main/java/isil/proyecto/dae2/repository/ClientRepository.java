package isil.proyecto.dae2.repository;

import isil.proyecto.dae2.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    @Query("select c from Client c where c.id = :id ")
    Client findByid(String id);

}
