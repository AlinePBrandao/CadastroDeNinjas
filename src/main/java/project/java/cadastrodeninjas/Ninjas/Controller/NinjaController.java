package project.java.cadastrodeninjas.Ninjas.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.java.cadastrodeninjas.Ninjas.DTO.NinjaDTO;
import project.java.cadastrodeninjas.Ninjas.Service.NinjaService;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    //NOTE: injeção de dependencia
    private final NinjaService ninjaService;

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
    public ResponseEntity<String> createNinja(@RequestBody NinjaDTO model){ //NOTE: envia no corpo da requisição um json com os dados cadastrados a serem desserializados
        NinjaDTO ninja = ninjaService.createNinja(model);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + ninja.getNome());
    }

    //NOTE: Mostrar todos os ninjas (READ)
    @GetMapping("/showAllNinjas")
    public ResponseEntity<List<NinjaDTO>> showAllNinjas(){
        List<NinjaDTO> ninjas = ninjaService.showAllNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //NOTE: Mostrar ninja por ID (READ)
    @GetMapping("/showNinjasById/{id}") //NOTE: Path variable onde o usuario digita o ID na url
    public ResponseEntity<?> showNinjasById(@PathVariable Long id){
        NinjaDTO ninja = ninjaService.showNinjasById(id);

        if (ninja != null){
            return ResponseEntity.ok(ninja);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O Ninja de ID " + id + " não foi encontrado");
        }
    }

    //NOTE: Alterar dados do ninja (UPDATE)
    @PutMapping("/updateNinja/{id}") //altera informações
    public ResponseEntity<?> alterNinjas(@PathVariable Long id, @RequestBody NinjaDTO alterModel){
        NinjaDTO ninja =  ninjaService.updateNinjas(id, alterModel);
        if (ninja != null){
            return ResponseEntity.ok(ninja);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O Ninja de ID " + id + " não foi encontrado");
        }
    }

    //NOTE: Deletar ninja (DELETE)
    @DeleteMapping("/deleteNinja/{id}") //deleta informações
    public ResponseEntity<String> deleteNinjas(@PathVariable Long id){

        if (ninjaService.showNinjasById(id) != null) {
            ninjaService.deleteNinjas(id);
            return ResponseEntity.ok("Ninja com o ID " + id + " deletado com sucesso");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O Ninja de ID " + id + " não foi encontrado");
        }
    }
}
