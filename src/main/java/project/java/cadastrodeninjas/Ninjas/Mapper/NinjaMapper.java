package project.java.cadastrodeninjas.Ninjas.Mapper;

import org.springframework.stereotype.Component;
import project.java.cadastrodeninjas.Missoes.Mapper.MissoesMapper;
import project.java.cadastrodeninjas.Ninjas.DTO.NinjaDTO;
import project.java.cadastrodeninjas.Ninjas.Model.NinjaModel;

@Component
public class NinjaMapper {

    private MissoesMapper missoesMapper;
    public NinjaMapper(MissoesMapper missoesMapper){
        this.missoesMapper = missoesMapper;
    }

    public NinjaModel map(NinjaDTO ninjaDTO){
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setRank(ninjaDTO.getRank());
        ninjaModel.setMissoes(missoesMapper.map(ninjaDTO.getMissoes()));

        return ninjaModel;
    }

    public NinjaDTO map(NinjaModel ninjaModel){
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setRank(ninjaModel.getRank());
        ninjaDTO.setMissoes(missoesMapper.map(ninjaModel.getMissoes()));

        return ninjaDTO;
    }
}