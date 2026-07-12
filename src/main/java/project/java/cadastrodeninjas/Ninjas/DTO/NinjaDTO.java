package project.java.cadastrodeninjas.Ninjas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.java.cadastrodeninjas.Missoes.Model.MissoesModel;

//Annotations Lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaDTO {

    private long id;
    private String nome;
    private String email;
    private int idade;
    private String rank;
    private MissoesModel missoes;
    //TODO: alterar missoes para Missoes DTO
    //private MissoesDTO missoes;
}
