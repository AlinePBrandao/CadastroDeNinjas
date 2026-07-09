package project.java.cadastrodeninjas.Missoes.Controller;

import org.springframework.web.bind.annotation.*;
import project.java.cadastrodeninjas.Missoes.Model.MissoesModel;
import project.java.cadastrodeninjas.Missoes.Service.MissoesService;

import java.util.List;

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

    @GetMapping("/showAllMissoes")
    public List<MissoesModel> showMissoes(){
        return missoesService.showAllMissoes();
    }

    @GetMapping("/showMissoesById/{id}")
    public MissoesModel showMissoesById(@PathVariable Long id){
        return missoesService.showMissoesById(id);
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
