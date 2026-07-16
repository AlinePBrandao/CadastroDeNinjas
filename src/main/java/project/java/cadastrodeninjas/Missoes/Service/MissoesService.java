package project.java.cadastrodeninjas.Missoes.Service;

import org.springframework.stereotype.Service;
import project.java.cadastrodeninjas.Missoes.DTO.MissoesDTO;
import project.java.cadastrodeninjas.Missoes.Mapper.MissoesMapper;
import project.java.cadastrodeninjas.Missoes.Model.MissoesModel;
import project.java.cadastrodeninjas.Missoes.Repository.MissoesRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public MissoesDTO createMissao(MissoesDTO modelDTO){
        MissoesModel model = missoesMapper.map(modelDTO);
        model = missoesRepository.save(model);
        return missoesMapper.map(model);
    }

    public List<MissoesDTO> showAllMissoes(){
        List<MissoesModel> model = missoesRepository.findAll();
        return model.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    public MissoesDTO showMissoesById(long id){
        Optional<MissoesModel> missoesById = missoesRepository.findById(id);
        return missoesById.map(missoesMapper::map).orElse(null);
    }

    public MissoesDTO alterMissoes(long id, MissoesDTO alterModel){
        Optional<MissoesModel> missaoExist = missoesRepository.findById(id);
        if (missaoExist.isPresent()){
            MissoesModel updateMissao = missoesMapper.map(alterModel);
            updateMissao.setId(id);
            MissoesModel missao = missoesRepository.save(updateMissao);
            return missoesMapper.map(missao);
        }
            return null;
    }

    public void deleteMissao(Long id){
        missoesRepository.deleteById(id);
    }
}
