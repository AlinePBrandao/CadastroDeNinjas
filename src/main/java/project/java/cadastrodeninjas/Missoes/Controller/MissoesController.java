package project.java.cadastrodeninjas.Missoes.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.java.cadastrodeninjas.Missoes.DTO.MissoesDTO;
import project.java.cadastrodeninjas.Missoes.Service.MissoesService;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService){
        this.missoesService = missoesService;
    }

    @PostMapping("/createMissao") //envia informações
    public ResponseEntity<String> createMissao(@RequestBody MissoesDTO model){
        MissoesDTO newMissao = missoesService.createMissao(model);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missao criada com sucesso: " + newMissao.getNome());
    }

    @GetMapping("/showAllMissoes")
    public ResponseEntity<List<MissoesDTO>> showAllMissoes(){
        List<MissoesDTO> missoes = missoesService.showAllMissoes();
        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/showMissoesById/{id}")
    public ResponseEntity<?> showMissoesById(@PathVariable Long id){
        MissoesDTO missoes = missoesService.showMissoesById(id);

        if (missoes != null){
            return ResponseEntity.ok(missoes);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A Missao de ID " + id + " não foi encontrada");
        }
    }

    @PutMapping("/alterMissao/{id}")
    public ResponseEntity<?> alterMissoes(@PathVariable Long id, @RequestBody MissoesDTO alterModel){
        MissoesDTO missoes = missoesService.alterMissoes(id, alterModel);
        if (missoes != null){
            return ResponseEntity.ok(missoes);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A Missao de ID " + id + " não foi encontrada");
        }
    }

    @DeleteMapping("/deleteMissao/{id}")
    public ResponseEntity<String> deleteMissao(@PathVariable Long id){
        if (missoesService.showMissoesById(id) != null){
            missoesService.deleteMissao(id);
            return ResponseEntity.ok("Missao com o ID " + id + " deletado com sucesso");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A Missao de ID " + id + " não foi encontrada");
        }
    }
}
