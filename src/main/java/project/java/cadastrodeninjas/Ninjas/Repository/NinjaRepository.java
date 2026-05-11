package project.java.cadastrodeninjas.Ninjas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.java.cadastrodeninjas.Ninjas.Model.NinjaModel;

public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
}
