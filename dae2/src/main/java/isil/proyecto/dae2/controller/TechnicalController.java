package isil.proyecto.dae2.controller;


import isil.proyecto.dae2.model.Technical;
import isil.proyecto.dae2.service.TechnicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TechnicalController {

    @Autowired
    private TechnicalService technicalService;


    @GetMapping("/technicals")
    public String technicalList(Model model){
        model.addAttribute("technicals",technicalService.findAll() );
        return "technical";
    }

    @GetMapping("/technicals/add")
    public String technicalAdd(Model model){
        model.addAttribute("technical", new Technical());
        return "technicalsAdd";
    }

    @PostMapping("/technicals/save")
    public String technicalSave(Technical technical){
        technicalService.createOrUpdate(technical);
        return "redirect:/technicals";
    }

    @GetMapping("/technicals/edit/{id}")
    public String technicalEdit(@PathVariable Long id, Model model){
        model.addAttribute("technical", technicalService.findById(id));
        return "technicalsAdd";
    }

    @GetMapping("technicals/delete/{id}")
    public String technicalDelete(@PathVariable Long id){
        technicalService.delete(id);
        return "redirect:/technicals";
    }

}
