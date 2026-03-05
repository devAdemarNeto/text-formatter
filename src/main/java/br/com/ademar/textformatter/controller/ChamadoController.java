package br.com.ademar.textformatter.controller;

import br.com.ademar.textformatter.model.ChamadoMonitor;
import br.com.ademar.textformatter.model.ChamadoPje;
import br.com.ademar.textformatter.model.RemoverDoAD;
import br.com.ademar.textformatter.service.ChamadoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChamadoController {

    private final ChamadoService chamadoService;

    public ChamadoController(ChamadoService chamadoService) {
        this.chamadoService = chamadoService;
    }

    @GetMapping("/pje")
    public String exibirFormulario(Model model) {
        model.addAttribute("chamado", new ChamadoPje());
        return "formulario";
    }

    @PostMapping("/pje/gerar")
    public String gerarTexto(@Valid @ModelAttribute("chamado") ChamadoPje chamado,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "formulario";
        }

        String textoFormatado = chamadoService.formatarChamadoPje(chamado);
        model.addAttribute("textoFormatado", textoFormatado);
        return "formulario";
    }

    @GetMapping("/monitor")
    public String exibirFormularioMonitor(Model model) {
        model.addAttribute("chamado", new ChamadoMonitor());
        return "monitor";
    }

    @PostMapping("/monitor/gerar")
    public String gerarTextoMonitor(ChamadoMonitor chamado, Model model) {
        String textoFormatado = chamadoService.formatarChamadoMonitor(chamado);

        model.addAttribute("chamado", chamado);
        model.addAttribute("textoFormatado", textoFormatado);
        return "monitor";
    }

    @GetMapping("/remover-ad")
    public String exibirFormularioRemoverAD(Model model) {
        model.addAttribute("remocao", new RemoverDoAD());
        return "remover-ad";
    }

    @PostMapping("/remover-ad/gerar")
    public String gerarTextoRemoverAD(@Valid @ModelAttribute("remocao") RemoverDoAD remocao,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "remover-ad";
        }

        String textoFormatado = chamadoService.formatarRemocaoAD(remocao);
        model.addAttribute("textoFormatado", textoFormatado);
        return "remover-ad";
    }
}
