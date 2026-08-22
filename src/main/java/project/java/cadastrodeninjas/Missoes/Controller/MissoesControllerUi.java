package project.java.cadastrodeninjas.Missoes.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.java.cadastrodeninjas.Missoes.DTO.MissoesDTO;
import project.java.cadastrodeninjas.Missoes.Service.MissoesService;
import project.java.cadastrodeninjas.Ninjas.Service.NinjaService;

import java.util.List;

@Controller
@RequestMapping("/missoes/ui")

public class MissoesControllerUi {

    private final MissoesService missoesService;

    public MissoesControllerUi(MissoesService missoesService, NinjaService ninjaService) {
        this.missoesService = missoesService;
    }

    @PostMapping("/create") //envia informações
    public String createMissao(Model model){
        model.addAttribute("missao", new MissoesDTO());
        return "missoes-adicionar";
    }

    @GetMapping("/showAll")
    public String showAllMissoes(Model model){
        List<MissoesDTO> missoes = missoesService.showAllMissoes();
        model.addAttribute("missoes", missoes);
        return "missoes-listar";
    }
    @GetMapping("/showById/{id}")
    public String showMissoesById(@PathVariable Long id, Model model){
       MissoesDTO missao = missoesService.showMissoesById(id);

       if (missao != null){
           model.addAttribute("missao", missao);
           return "missoes-detalhes";
       }
       else {
           model.addAttribute("mensagem", "Missao não encontrado");
           return "missoes-listar";
       }
    }

    @GetMapping("/update/{id}")
    public String updateMissoes(@PathVariable Long id, Model model){
        MissoesDTO missao = missoesService.showMissoesById(id);
        if (missao != null){
            model.addAttribute("missao", missao);
            return "missao-alterar";
        }
        else {
            model.addAttribute("mensagem", "Missao não encontrado");
            return "missoes-listar";
        }
    }

    @PostMapping("/save")
    public String saveMissao(MissoesDTO missao, Model model){
        model.addAttribute("missao", missao);
        missoesService.saveMissao(missao);
        return "redirect:/missoes/ui/missoes-listar";
    }


    @DeleteMapping("/delete/{id}")
    public String deleteMissao(@PathVariable Long id){
        missoesService.deleteMissao(id);
        return "redirect:/missoes/ui/missoes-listar";
    }
}
