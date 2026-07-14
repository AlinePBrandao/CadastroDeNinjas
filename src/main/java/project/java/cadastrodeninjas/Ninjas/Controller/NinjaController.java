package project.java.cadastrodeninjas.Ninjas.Controller;

import org.springframework.web.bind.annotation.*;
import project.java.cadastrodeninjas.Ninjas.DTO.NinjaDTO;
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
    @PostMapping("/createNinja") //NOTE: envia informações
    public NinjaDTO createNinja(@RequestBody NinjaDTO model){ //NOTE: envia no corpo da requisição um json com os dados cadastrados a serem desserializados
        return ninjaService.createNinja(model);
    }

    //NOTE: Mostrar todos os ninjas (READ)
    @GetMapping("/showAllNinjas")
    public List<NinjaDTO> showAllNinjas(){
        return ninjaService.showAllNinjas();
    }

    //NOTE: Mostrar ninja por ID (READ)
    @GetMapping("/showNinjasById/{id}") //NOTE: Path variable onde o usuario digita o ID na url
    public NinjaDTO showNinjasById(@PathVariable Long id){
        return ninjaService.showNinjasById(id);
    }

    //NOTE: Alterar dados do ninja (UPDATE)
    @PutMapping("/alterNinja/{id}") //altera informações
    public NinjaDTO alterNinjas(@PathVariable Long id, @RequestBody NinjaDTO alterModel){
        return ninjaService.alterNinjas(id, alterModel);
    }

    //NOTE: Deletar ninja (DELETE)
    @DeleteMapping("/deleteNinja/{id}") //deleta informações
    public void deleteNinjas(@PathVariable Long id){
        ninjaService.deleteNinjas(id);
    }
}
