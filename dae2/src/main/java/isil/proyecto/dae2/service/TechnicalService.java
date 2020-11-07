package isil.proyecto.dae2.service;

import isil.proyecto.dae2.model.Client;
import isil.proyecto.dae2.model.Report;
import isil.proyecto.dae2.model.Technical;
import isil.proyecto.dae2.repository.ClientRepository;
import isil.proyecto.dae2.repository.ReportRepository;
import isil.proyecto.dae2.repository.TechnicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TechnicalService {

    @Autowired
    private TechnicalRepository technicalRepository;

    public void createOrUpdate(Technical technical){
        technicalRepository.save(technical);
    }

    public void delete(Long id){
        technicalRepository.deleteById(id);
    }

    public Technical findById(Long id){
        return technicalRepository.findById(id).orElse(null);
    }

    public List<Technical> findAll(){
        return technicalRepository.findAll();
    }

}
