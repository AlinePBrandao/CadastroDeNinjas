package project.java.cadastrodeninjas.Ninjas.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import project.java.cadastrodeninjas.Missoes.Model.MissoesModel;

@Entity //NOTE: informa que a classe pertence ao banco de dados, transforma classe em entidade do BD
@Table(name = "tb_cadastro") //NOTE: nomenado a tabela

@NoArgsConstructor //NOTE: Gera um no args constructor automaticamente
@AllArgsConstructor//NOTE: Gera um All args constructor automaticamente
@Data //NOTE: Gera Getters e Setters automaticamente
@ToString(exclude = "missoes") //NOTE: converte objetos referência de memória e transformar em valor em memória
//NOTE: Excluir missoes soluciona o problema de recursão onde missão está em um loop infinito

public class NinjaModel {

    @Id //annotacion que informa geração id automatico
    @GeneratedValue(strategy = GenerationType.IDENTITY) //annotacion para gerar id automatico a partir da estrategia declarada
    @Column(name = "id")
    private long id; //NOTE: o ID sera atribuido automaticamente no banco de dados, não é necessaria atribuicao dos valores

    @Column(name = "nome")
    private String nome;

    @Column(unique = true) //NOTE: torna a coluna email unica
    private String email;

    @Column(name = "idade")
    private int idade;

    @Column(name = "rank")
    private String rank;

    @ManyToOne //NOTE: varios ninja tem uma unica missao
    //sem annotation @JsonIgnore para que a missão não seja ignorada pelo banco
    //NOTE: junta as colunas gerando uma nova
    @JoinColumn(name = "missoes_id") //NOTE: id = foreing key
    private MissoesModel missoes;
}
