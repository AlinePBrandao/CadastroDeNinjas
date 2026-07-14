package project.java.cadastrodeninjas.Missoes.Controller;

import org.springframework.web.bind.annotation.*;
import project.java.cadastrodeninjas.Missoes.DTO.MissoesDTO;
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
    public MissoesDTO createMissao(@RequestBody MissoesDTO model){
        return missoesService.createMissao(model);
    }

    @GetMapping("/showAllMissoes")
    public List<MissoesDTO> showMissoes(){
        return missoesService.showAllMissoes();
    }

    @GetMapping("/showMissoesById/{id}")
    public MissoesDTO showMissoesById(@PathVariable Long id){
        return missoesService.showMissoesById(id);
    }

    //Alterar missão
    @PutMapping("/alterMissao/{id}")
    public MissoesDTO alterMissoes(@PathVariable Long id, @RequestBody MissoesDTO alterModel){
        return missoesService.alterMissoes(id, alterModel);
    }

    //Deletar missão
    @DeleteMapping("/deleteMissao/{id}")
    public void deleteMissao(@PathVariable Long id){
        missoesService.deleteMissao(id);
    }
}
