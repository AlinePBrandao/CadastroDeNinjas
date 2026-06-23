package project.java.cadastrodeninjas.Ninjas.Service;

import org.springframework.stereotype.Service;
import project.java.cadastrodeninjas.Ninjas.Model.NinjaModel;
import project.java.cadastrodeninjas.Ninjas.Repository.NinjaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository; //NOTE: injeção de dependencia

    public NinjaService(NinjaRepository ninjaRepository){
        this.ninjaRepository = ninjaRepository;
    }

    //NOTE: Criar novo ninja
    public NinjaModel createNinja(NinjaModel model){
        return ninjaRepository.save(model);
    }

    //NOTE: Listar todos os ninjas
    public List<NinjaModel> showAllNinjas(){
        return  ninjaRepository.findAll();
    }

    //NOTE: Listar todos os ninjas por ID
    public NinjaModel showAllNinjasIDs(long id){
        Optional<NinjaModel> ninjaByID = ninjaRepository.findById(id); //NOTE: Ninja pode nao existir
        return ninjaByID.orElse(null);
    }
}
