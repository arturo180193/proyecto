package isil.proyecto.dae2.service;

import isil.proyecto.dae2.model.Report;
import isil.proyecto.dae2.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public void createOrUpdate(Report client){
        reportRepository.save(client);
    }

    public void delete(Long id){
        reportRepository.deleteById(id);
    }

    public Report findById(Long id){
        return reportRepository.findById(id).orElse(null);
    }

    public List<Report> findAll(){
        return reportRepository.findAll();
    }
}
