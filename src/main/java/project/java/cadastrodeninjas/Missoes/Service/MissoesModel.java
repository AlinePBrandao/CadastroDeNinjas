package project.java.cadastrodeninjas.Missoes.Service;

import jakarta.persistence.*;
import project.java.cadastrodeninjas.Ninjas.Service.NinjaModel;

@Entity
@Table(name = "tb_missoes")

public class MissoesModel {

    @Id //NOTE: annotations leem o codigo ate ; ou fechamento de }
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String dificuldade;

    private NinjaModel ninja;

    public MissoesModel() {
    }

    public MissoesModel(String nome, String dificuldade) {
        this.nome = nome;
        this.dificuldade = dificuldade;
    }

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
