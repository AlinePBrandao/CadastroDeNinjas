package project.java.cadastrodeninjas.Missoes.Service;

import org.springframework.stereotype.Service;
import project.java.cadastrodeninjas.Missoes.DTO.MissoesDTO;
import project.java.cadastrodeninjas.Missoes.Mapper.MissoesMapper;
import project.java.cadastrodeninjas.Missoes.Model.MissoesModel;
import project.java.cadastrodeninjas.Missoes.Repository.MissoesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public MissoesDTO createMissao(MissoesDTO modelDTO){
        MissoesModel model = missoesMapper.map(modelDTO);
        model = missoesRepository.save(model);
        return missoesMapper.map(model);
    }

    public List<MissoesModel> showAllMissoes(){
        return missoesRepository.findAll();
    }

    public MissoesModel showMissoesById(long id){
        Optional<MissoesModel> missoesById = missoesRepository.findById(id);
        return missoesById.orElse(null);
    }

    public MissoesModel alterMissoes(long id, MissoesModel alterModel){
        if (missoesRepository.existsById(id)){
            alterModel.setId(id);
            return missoesRepository.save(alterModel);
        }
        else {
            return null;
        }
    }

    public void deleteMissao(Long id){
        missoesRepository.deleteById(id);
    }
}
