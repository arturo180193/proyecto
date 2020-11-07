package isil.proyecto.dae2.service;

import isil.proyecto.dae2.model.Client;
import isil.proyecto.dae2.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public void createOrUpdate(Client client){
        clientRepository.save(client);
    }

    public void delete(Long id){
        clientRepository.deleteById(id);
    }

    public Client findById(Long id){
        return clientRepository.findById(id).orElse(null);
    }

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

}
