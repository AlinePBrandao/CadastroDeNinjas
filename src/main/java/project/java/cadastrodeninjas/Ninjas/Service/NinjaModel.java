package project.java.cadastrodeninjas.Ninjas.Service;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import project.java.cadastrodeninjas.Missoes.Service.MissoesModel;

import java.util.List;

@Entity //NOTE: informa que a classe pertence ao banco de dados, transforma classe em entidade do BD
@Table(name = "tb_cadastro") //NOTE: nomenado a tabela
@NoArgsConstructor //NOTE: Gera um no args constructor automaticamente
@AllArgsConstructor//NOTE: Gera um All args constructor automaticamente

public class NinjaModel {

    @Id //annotacion que informa geração id automatico
    @GeneratedValue(strategy = GenerationType.IDENTITY) //annotacion para gerar id automatico a partir da estrategia declarada
    private long id; //NOTE: o ID sera atribuido automaticamente no banco de dados, não é necessaria atribuicao dos valores

    private String nome;
    private String email;
    private int idade;

    @ManyToOne //NOTE: varios ninja tem uma unica missao
    //NOTE: junta as colunas gerando uma nova
    @JoinColumn(name = "missoes_id") //NOTE: id = foreing key pu chave extrangeira
    private MissoesModel missoes;

    //private List<MissoesModel> missoes;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
