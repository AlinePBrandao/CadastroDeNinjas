package project.java.cadastrodeninjas.Missoes.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesDTO {

    private Long id;
    private String nome;
    private String dificuldade;
    private String descricao;
}
