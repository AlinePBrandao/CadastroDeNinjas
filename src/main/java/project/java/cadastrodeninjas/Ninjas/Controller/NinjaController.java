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

    //NOTE: Endpoints
    @GetMapping("/boasvindas") //NOTE: passando uma rota, retorna informações
    public String boasvindas(){
        return "Boas Vindas! Essa é minha primeira mensagem nessa rota";
    }

    //NOTE: Adicionar ninja (CREATE)
    @PostMapping("/create") //NOTE: envia informações
    public NinjaModel createNinja(@RequestBody NinjaModel model){ //NOTE: envia no corpo da requisição um json com os dados cadastrados a serem desserializados
        return ninjaService.createNinja(model);
    }

    //NOTE: Mostrar todos os ninjas (READ)
    @GetMapping("/showAll")
    public List<NinjaModel> showAllNinjas(){
        return ninjaService.showAllNinjas();
    }

    //NOTE: Mostrar ninja por ID (READ)
    @GetMapping("/showAllIDs/{id}") //NOTE: Path variable onde o usuario digita o ID na url
    public NinjaModel showAllNinjasIDs(@PathVariable Long id){
        return ninjaService.showAllNinjasIDs(id);
    }

    //NOTE: Alterar dados do ninja (UPDATE)
    @PutMapping("/alter") //altera informações
    public String alterNinjas(){
        return "Alter Ninja";
    }

    //NOTE: Deletar ninja (DELETE)
    @DeleteMapping("/delete") //deleta informações
    public String deleteNinjas(){
        return "Delete Ninja";
    }

}
