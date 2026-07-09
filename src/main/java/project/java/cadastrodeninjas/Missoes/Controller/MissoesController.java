package project.java.cadastrodeninjas.Missoes.Controller;

import org.springframework.web.bind.annotation.*;
import project.java.cadastrodeninjas.Missoes.Model.MissoesModel;
import project.java.cadastrodeninjas.Missoes.Service.MissoesService;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService){
        this.missoesService = missoesService;
    }

    @PostMapping("/createMissao") //envia informações
    public MissoesModel createMissao(@RequestBody MissoesModel model){
        return missoesService.createMissao(model);
    }

    //Mostrar missões
    @GetMapping("/all")
    public String showMissoes(){
        return "Todas as Missões";
    }

    //Mostrar missões por ID
    @GetMapping("/allIDs")
    public String showMissoesIDs(){
        return "IDs Missões";
    }

    //Alterar missão
    @PutMapping("/alter")
    public String alterMissoes(){
        return "Missão alterada";
    }

    //Deletar missão
    @DeleteMapping("/delete")
    public String deleteMissao(){
        return "Missão deletada";
    }
}
