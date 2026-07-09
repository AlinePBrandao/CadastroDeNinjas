package project.java.cadastrodeninjas.Missoes.Service;

import org.springframework.stereotype.Service;
import project.java.cadastrodeninjas.Missoes.Model.MissoesModel;
import project.java.cadastrodeninjas.Missoes.Repository.MissoesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository){
        this.missoesRepository = missoesRepository;
    }

    public MissoesModel createMissao(MissoesModel model){
        return missoesRepository.save(model);
    }

    public List<MissoesModel> showAllMissoes(){
        return missoesRepository.findAll();
    }

    public MissoesModel showAllMissoesIds(long id){
        Optional<MissoesModel> missoesById = missoesRepository.findById(id);
        return missoesById.orElse(null);
    }
}
