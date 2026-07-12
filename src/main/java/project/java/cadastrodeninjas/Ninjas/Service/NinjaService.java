package project.java.cadastrodeninjas.Ninjas.Service;

import org.springframework.stereotype.Service;
import project.java.cadastrodeninjas.Ninjas.DTO.NinjaDTO;
import project.java.cadastrodeninjas.Ninjas.Mapper.NinjaMapper;
import project.java.cadastrodeninjas.Ninjas.Model.NinjaModel;
import project.java.cadastrodeninjas.Ninjas.Repository.NinjaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository; //NOTE: injeção de dependencia
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //NOTE: Criar novo ninja
    public NinjaDTO createNinja(NinjaDTO modelDTO){
        NinjaModel model = ninjaMapper.map(modelDTO);
        model = ninjaRepository.save(model);
        return ninjaMapper.map(model);
    }

    //NOTE: Listar todos os ninjas
    public List<NinjaModel> showAllNinjas(){
        return  ninjaRepository.findAll();
    }

    //NOTE: Listar os ninjas por ID
    public NinjaModel showNinjasById(long id){
        Optional<NinjaModel> ninjaByID = ninjaRepository.findById(id); //NOTE: Ninja pode nao existir
        return ninjaByID.orElse(null);
    }

    //NOTE: Atualizar ninja
    public NinjaModel alterNinjas(long id, NinjaModel alterModel){
        if (ninjaRepository.existsById(id)){
            alterModel.setId(id);
            return ninjaRepository.save(alterModel);
        }
        else {
            return null;
        }
    }

    //NOTE: Deletar ninja - tem que ser um metodo void, nada sera retornado
    public void deleteNinjas(Long id){
       ninjaRepository.deleteById(id);
    }
}
