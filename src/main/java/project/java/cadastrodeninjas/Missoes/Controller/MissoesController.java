package project.java.cadastrodeninjas.Missoes.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    //Adicionar missão
    @PostMapping("/create") //envia informações
    public String criateNinja(){
        return "Missão Criada";
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
