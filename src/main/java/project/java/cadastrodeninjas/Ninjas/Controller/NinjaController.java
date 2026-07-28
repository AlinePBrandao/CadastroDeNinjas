package project.java.cadastrodeninjas.Ninjas.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Mensagem de boas vindas",  description = "Essa rota mostra uma mensagem de boas vidas") //NOTE: Annotation do Swagger
    public String boasvindas(){
        return "Boas Vindas! Essa é minha primeira mensagem nessa rota";
    }

    //NOTE: Adicionar ninja (CREATE)
    @PostMapping("/createNinja") //NOTE: envia informações
    @Operation(summary = "Cria um novo ninja", description = "Rota cria um novo ninja e insere no banco de dados")
    @ApiResponses(value = { //NOTE: Respostas do servidor
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja")
    })

    public ResponseEntity<String> createNinja(@RequestBody NinjaDTO model){ //NOTE: envia no corpo da requisição um json com os dados cadastrados a serem desserializados
        NinjaDTO ninja = ninjaService.createNinja(model);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + ninja.getNome());
    }

    //NOTE: Mostrar todos os ninjas (READ)
    @GetMapping("/showAllNinjas")
    @Operation(summary = "Lista todos os ninjas", description = "Rota lista todos os ninjas cadastrados")
    @ApiResponses(value = { //NOTE: Respostas do servidor
            @ApiResponse(responseCode = "200", description = "Ninjas encontrados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninjas não encontrados")
    })

    public ResponseEntity<List<NinjaDTO>> showAllNinjas(){
        List<NinjaDTO> ninjas = ninjaService.showAllNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //NOTE: Mostrar ninja por ID (READ)
    @GetMapping("/showNinjasById/{id}") //NOTE: Path variable onde o usuario digita o ID na url
    @Operation(summary = "Lista ninja por ID", description = "Rota lista um ninja pelo seu id")
    @ApiResponses(value = { //NOTE: Respostas do servidor
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })

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
    @Operation(summary = "Altera ninja por ID", description = "Rota altera um ninja pelo seu id")
    @ApiResponses(value = { //NOTE: Respostas do servidor
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Não foi possível alterar")
    })

    public ResponseEntity<?> updateNinjas(
            @Parameter(description = "Usuário manda o id no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuário manda os dados do ninja a ser atualizado no corpo do requisição")
            @RequestBody NinjaDTO updateModel){
        NinjaDTO ninja =  ninjaService.updateNinjas(id, updateModel);
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
    @Operation(summary = "Deleta ninja por id", description = "Rota deleta um ninja pelo seu id")
    @ApiResponses(value = { //NOTE: Respostas do servidor
            @ApiResponse(responseCode = "200", description = "Ninja deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não deletado")
    })

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
