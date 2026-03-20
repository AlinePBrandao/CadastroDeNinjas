package project.java.cadastrodeninjas.Missoes.Service;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import project.java.cadastrodeninjas.Ninjas.Service.NinjaModel;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor

public class MissoesModel {

    @Id //NOTE: annotations leem o codigo ate ; ou fechamento de }
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String dificuldade;

    @OneToMany(mappedBy = "missoes") //NOTE: uma missao pode ter varios ninjas
    private List<NinjaModel> ninja;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }
}
