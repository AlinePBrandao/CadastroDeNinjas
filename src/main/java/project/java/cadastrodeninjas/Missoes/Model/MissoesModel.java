package project.java.cadastrodeninjas.Missoes.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.java.cadastrodeninjas.Ninjas.Model.NinjaModel;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
//@NoArgsConstructor
//@AllArgsConstructor
//@Data

public class MissoesModel {

    @Id //NOTE: annotations leem o codigo ate ; ou fechamento de }
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "dificuldade")
    private String dificuldade;

    @OneToMany(mappedBy = "missoes") //NOTE: uma missao pode ter varios ninjas
    @JsonIgnore //NOTE: ignora loop serialização
    private List<NinjaModel> ninja;

}
