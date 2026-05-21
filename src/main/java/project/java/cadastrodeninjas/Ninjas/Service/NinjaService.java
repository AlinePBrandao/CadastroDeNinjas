package project.java.cadastrodeninjas.Ninjas.Service;

import org.springframework.stereotype.Service;
import project.java.cadastrodeninjas.Ninjas.Model.NinjaModel;
import project.java.cadastrodeninjas.Ninjas.Repository.NinjaRepository;

import java.util.List;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository; //NOTE: injeção de dependencia

    public NinjaService(NinjaRepository ninjaRepository){
        this.ninjaRepository = ninjaRepository;
    }

    //NOTE: Listar todos os ninjas
    public List<NinjaModel> showAllNinjas(){
        return  ninjaRepository.findAll();
    }
}
