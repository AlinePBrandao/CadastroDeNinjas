package project.java.cadastrodeninjas.Missoes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.java.cadastrodeninjas.Missoes.Model.MissoesModel;

public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {
}
