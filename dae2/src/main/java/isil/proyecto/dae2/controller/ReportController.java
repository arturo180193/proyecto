package isil.proyecto.dae2.controller;

import isil.proyecto.dae2.model.Report;
import isil.proyecto.dae2.service.ClientService;
import isil.proyecto.dae2.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private ClientService ClientService;

    @GetMapping("/reports")
    public String reportList(Model model){
        model.addAttribute("reports",reportService.findAll() );
        return "report";
    }

    @GetMapping("/reports/add")
    public String reportAdd(Model model){
        model.addAttribute("report", new Report());
        model.addAttribute("clients", ClientService.findAll());
        return "reportsAdd";
    }

    @PostMapping("/reports/save")
    public String reportSave(Report report){
        reportService.createOrUpdate(report);
        return "redirect:/reports";
    }

    @GetMapping("/reports/edit/{id}")
    public String reportEdit(@PathVariable Long id, Model model){
        model.addAttribute("report", reportService.findById(id));
        model.addAttribute("clients", ClientService.findAll());
        return "reportsAdd";
    }

    @GetMapping("reports/delete/{id}")
    public String reportDelete(@PathVariable Long id){
        reportService.delete(id);
        return "redirect:/reports";
    }



}
