package project.java.cadastrodeninjas.Missoes.Service;

import project.java.cadastrodeninjas.Missoes.Model.MissoesModel;
import project.java.cadastrodeninjas.Missoes.Repository.MissoesRepository;

public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository){
        this.missoesRepository = missoesRepository;
    }

    public MissoesModel createMissao(MissoesModel model){
        return missoesRepository.save(model);
    }
}
