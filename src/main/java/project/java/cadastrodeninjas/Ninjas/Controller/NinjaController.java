package project.java.cadastrodeninjas.Ninjas.Controller;

import org.springframework.web.bind.annotation.*;
import project.java.cadastrodeninjas.Ninjas.Model.NinjaModel;
import project.java.cadastrodeninjas.Ninjas.Service.NinjaService;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    //NOTE: injeção de dependencia
    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    //Endpoints
    @GetMapping("/boasvindas") //NOTE: passando uma rota, retorna informações
    public String boasvindas(){
        return "Boas Vindas! Essa é minha primeira mensagem nessa rota";
    }

    //Adicionar ninja (CREATE)
    @PostMapping("/create") //envia informações
    public String createNinja(){
        return "Ninja Criado";
    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/showAll")
    public List<NinjaModel> showAllNinjas(){
        return ninjaService.showAllNinjas();
    }

    //Mostrar ninja por ID (READ)
    @GetMapping("/allIDs")
    public String showAllNinjasIDs(){
        return "IDs Ninjas";
    }

    //Alterar dados do ninja (UPDATE)
    @PutMapping("/alter") //altera informações
    public String alterNinjas(){
        return "Alter Ninja";
    }

    //Deletar ninja (DELETE)
    @DeleteMapping("/delete") //deleta informações
    public String deleteNinjas(){
        return "Delete Ninja";
    }

}
