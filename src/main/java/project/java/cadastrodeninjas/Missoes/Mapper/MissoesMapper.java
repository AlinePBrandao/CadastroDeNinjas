package project.java.cadastrodeninjas.Missoes.Mapper;

import org.springframework.stereotype.Component;
import project.java.cadastrodeninjas.Missoes.DTO.MissoesDTO;
import project.java.cadastrodeninjas.Missoes.Model.MissoesModel;

@Component
public class MissoesMapper {
    public MissoesModel map(MissoesDTO missoesDTO){
        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(missoesDTO.getId());
        missoesModel.setNome(missoesDTO.getNome());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());
        missoesModel.setDescricao(missoesDTO.getDescricao());

        return missoesModel;
    }
    public MissoesDTO map(MissoesModel missoesModel){
        MissoesDTO missoesDTO = new MissoesDTO();
        missoesDTO.setId(missoesDTO.getId());
        missoesDTO.setNome(missoesDTO.getNome());
        missoesDTO.setDificuldade(missoesDTO.getDificuldade());
        missoesDTO.setDescricao(missoesDTO.getDescricao());

        return missoesDTO;
    }
}
