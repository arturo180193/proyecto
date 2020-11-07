package isil.proyecto.dae2.controller;

import isil.proyecto.dae2.model.Client;
import isil.proyecto.dae2.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;


    @GetMapping("/clients")
    public String clientList(Model model){
        model.addAttribute("clients",clientService.findAll() );
        return "client";
    }

    @GetMapping("/clients/add")
    public String clientAdd(Model model){
        model.addAttribute("client", new Client());
        return "clientsAdd";
    }

    @PostMapping("/clients/save")
    public String clientSave(Client client){
        clientService.createOrUpdate(client);
        return "redirect:/clients";
    }

    @GetMapping("/clients/edit/{id}")
    public String clientEdit(@PathVariable Long id, Model model){
        model.addAttribute("client", clientService.findById(id));
        return "clientsAdd";
    }

    @GetMapping("clients/delete/{id}")
    public String clientDelete(@PathVariable Long id){
        clientService.delete(id);
        return "redirect:/clients";
    }


}
