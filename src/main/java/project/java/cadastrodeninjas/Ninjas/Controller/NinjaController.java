package project.java.cadastrodeninjas.Ninjas.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    //Endpoints
    @GetMapping("/boasvindas") //NOTE: passando uma rota, retorna informações
    public String boasvindas(){
        return "Boas Vindas! Essa é minha primeira mensagem nessa rota";
    }

    //Adicionar ninja (CREATE)
    @PostMapping("/create") //envia informações
    public String criateNinja(){
        return "Ninja criado";
    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/all")
    public String showAllNinjas(){
        return "Todos os Ninjas";
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
