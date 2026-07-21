package project.java.cadastrodeninjas.Ninjas.Service;

import org.springframework.stereotype.Service;
import project.java.cadastrodeninjas.Ninjas.DTO.NinjaDTO;
import project.java.cadastrodeninjas.Ninjas.Mapper.NinjaMapper;
import project.java.cadastrodeninjas.Ninjas.Model.NinjaModel;
import project.java.cadastrodeninjas.Ninjas.Repository.NinjaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository; //NOTE: injeção de dependencia
    private final NinjaMapper ninjaMapper;

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
    public List<NinjaDTO> showAllNinjas(){
        List<NinjaModel> model = ninjaRepository.findAll();
        //NOTE: Retorna a list
       return model.stream()
               .map(ninjaMapper::map)//NOTE: Transforma elementos do stream
               .collect(Collectors.toList()); //NOTE: Converte o stream em uma coleção
    }

    //NOTE: Listar os ninjas por ID
    public NinjaDTO showNinjasById(long id){
        Optional<NinjaModel> ninjaByID = ninjaRepository.findById(id); //NOTE: Ninja pode nao existir
        return ninjaByID.map(ninjaMapper::map).orElse(null); //NOTE: Também usa streams
    }

    //NOTE: Atualizar ninja
    public NinjaDTO updateNinjas(long id, NinjaDTO alterModel){
        Optional<NinjaModel> ninjaExist = ninjaRepository.findById(id);
        if (ninjaExist.isPresent()){
            NinjaModel updatedNinja = ninjaMapper.map(alterModel);
            updatedNinja.setId(id);
            NinjaModel  ninja = ninjaRepository.save(updatedNinja);
            return ninjaMapper.map(ninja);
        }
        return null;
    }

    //NOTE: Deletar ninja - tem que ser um metodo void, nada sera retornado. Não depende do DTO, não depende do moddel, e sim do Repositpry (JPA)
    public void deleteNinjas(Long id){
       ninjaRepository.deleteById(id);
    }
}
