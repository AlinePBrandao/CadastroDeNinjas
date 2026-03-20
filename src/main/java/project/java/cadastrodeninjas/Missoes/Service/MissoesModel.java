package project.java.cadastrodeninjas.Missoes.Service;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.java.cadastrodeninjas.Ninjas.Service.NinjaModel;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class MissoesModel {

    @Id //NOTE: annotations leem o codigo ate ; ou fechamento de }
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String dificuldade;

    @OneToMany(mappedBy = "missoes") //NOTE: uma missao pode ter varios ninjas
    private List<NinjaModel> ninja;

}
