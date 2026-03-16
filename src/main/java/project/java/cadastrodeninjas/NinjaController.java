package project.java.cadastrodeninjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas") //NOTE: passando uma rota
    public String boasvindas(){
        return "Boas Vindas! Essa é minha primeira mensagem nessa rota";
    }
}
