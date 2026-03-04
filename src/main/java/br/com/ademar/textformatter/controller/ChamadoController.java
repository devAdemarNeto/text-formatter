package br.com.ademar.textformatter.controller;

import br.com.ademar.textformatter.model.ChamadoPje;
import br.com.ademar.textformatter.service.ChamadoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String gerarTexto(ChamadoPje chamado, Model model) {
        String textoFormatado = chamadoService.formatarChamadoPje(chamado);

        model.addAttribute("chamado", chamado);
        model.addAttribute("textoFormatado", textoFormatado);
        return "formulario";
    }
}
