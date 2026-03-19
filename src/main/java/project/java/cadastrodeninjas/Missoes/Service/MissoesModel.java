package project.java.cadastrodeninjas.Missoes.Service;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_missoes")

public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nomeMissao;
    private String dificuldade;

    public MissoesModel() {
    }

    public MissoesModel(String nomeMissao, String dificuldade) {
        this.nomeMissao = nomeMissao;
        this.dificuldade = dificuldade;
    }

    public String getNomeMissao() {
        return nomeMissao;
    }

    public void setNomeMissao(String nomeMissao) {
        this.nomeMissao = nomeMissao;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }
}
