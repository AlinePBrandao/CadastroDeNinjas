package project.java.cadastrodeninjas.Ninjas.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.java.cadastrodeninjas.Missoes.Service.MissoesService;
import project.java.cadastrodeninjas.Ninjas.DTO.NinjaDTO;
import project.java.cadastrodeninjas.Ninjas.Service.NinjaService;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")

public class NinjaControllerUi {

    private final NinjaService ninjaService;
    private final MissoesService missoesService;

    public NinjaControllerUi(NinjaService ninjaService, MissoesService missoesService) {
        this.ninjaService = ninjaService;
        this.missoesService = missoesService;
    }

    @GetMapping("/showAllNinjas")
    public String showAllNinjas(Model model){
        List<NinjaDTO> ninjas = ninjaService.showAllNinjas();
        model.addAttribute("ninjas", ninjas);
        return "ninjas-listar"; //NOTE: retorna o nome da pagina que renderiza, nesse caso a pagina html
    }

    @GetMapping("/showNinjasById/{id}")
    public String showNinjasById(@PathVariable Long id, Model model){
        NinjaDTO ninja = ninjaService.showNinjasById(id);

        if (ninja != null){
            model.addAttribute("ninja", ninja);
            return "ninja-detalhes";
        }
        else {
            model.addAttribute("mensagem", "Ninja não encontrado");
            return "ninjas-listar";
        }
    }

    @GetMapping("/createNinja")
    public String createNinja(Model model){
        model.addAttribute("ninja", new NinjaDTO());
        model.addAttribute("missoes", missoesService.showAllMissoes());
        return "ninja-adicionar";
    }

    @GetMapping("/updateNinja/{id}")
    public String updateNinjas(@PathVariable Long id, Model model){
        NinjaDTO ninja =  ninjaService.showNinjasById(id);
        if (ninja != null){
            model.addAttribute("ninja", ninja);
            model.addAttribute("missoes", missoesService.showAllMissoes());
            return "ninja-alterar";
        }
        model.addAttribute("mensagem", "Ninja não encontrado");
        return "redirect:/ninjas/ui/showAllNinjas";
    }

    @PostMapping("/save")
    public String saveNinja(@ModelAttribute NinjaDTO ninja, @RequestParam(required = false) Long missoesId, RedirectAttributes redirectAttributes){
        NinjaDTO saveNinja = ninjaService.saveNinja(ninja, missoesId);
        redirectAttributes.addFlashAttribute("mensagem", "Ninja salvo com sucesso!");
        return "redirect:/ninjas/ui/showNinjasById/" + saveNinja.getId();
    }

    @GetMapping("/deleteNinja/{id}") //deleta informações
    public String deleteNinjas(@PathVariable Long id){
        ninjaService.deleteNinjas(id);
        return "redirect:/ninjas/ui/showAllNinjas";
    }
}
