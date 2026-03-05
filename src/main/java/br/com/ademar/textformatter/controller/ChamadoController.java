package br.com.ademar.textformatter.controller;

import br.com.ademar.textformatter.dto.ChamadoMonitorDTO;
import br.com.ademar.textformatter.dto.ChamadoPjeDTO;
import br.com.ademar.textformatter.dto.DevolucaoEquipamentoDTO;
import br.com.ademar.textformatter.dto.RemoverDoADDTO;
import br.com.ademar.textformatter.service.ChamadoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Tag(name = "Chamados", description = "Endpoints para geração e consulta de chamados formatados")
public class ChamadoController {

    private final ChamadoService chamadoService;

    public ChamadoController(ChamadoService chamadoService) {
        this.chamadoService = chamadoService;
    }

    @Operation(summary = "Exibe formulário do PJe", description = "Retorna a página de formulário para escalonamento PJe")
    @GetMapping("/pje")
    public String exibirFormulario(Model model) {
        model.addAttribute("chamado", new ChamadoPjeDTO());
        return "formulario";
    }

    @Operation(summary = "Gera texto de escalonamento PJe", description = "Recebe os dados do formulário, salva no banco e retorna o texto formatado")
    @PostMapping("/pje/gerar")
    public String gerarTexto(@Valid @ModelAttribute("chamado") ChamadoPjeDTO chamado,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "formulario";
        }

        String textoFormatado = chamadoService.formatarChamadoPje(chamado);
        model.addAttribute("textoFormatado", textoFormatado);
        return "formulario";
    }

    @Operation(summary = "Exibe formulário de substituição de monitor")
    @GetMapping("/monitor")
    public String exibirFormularioMonitor(Model model) {
        model.addAttribute("chamado", new ChamadoMonitorDTO());
        return "monitor";
    }

    @Operation(summary = "Gera texto de substituição de monitor", description = "Recebe dados do monitor, salva e retorna texto formatado")
    @PostMapping("/monitor/gerar")
    public String gerarTextoMonitor(@ModelAttribute("chamado") ChamadoMonitorDTO chamado, Model model) {
        String textoFormatado = chamadoService.formatarChamadoMonitor(chamado);
        model.addAttribute("textoFormatado", textoFormatado);
        return "monitor";
    }

    @Operation(summary = "Exibe formulário de remoção do AD")
    @GetMapping("/remover-ad")
    public String exibirFormularioRemoverAD(Model model) {
        model.addAttribute("remocao", new RemoverDoADDTO());
        return "remover-ad";
    }

    @Operation(summary = "Gera texto de remoção do Active Directory", description = "Recebe patrimônio, motivo e setor, salva e retorna texto formatado")
    @PostMapping("/remover-ad/gerar")
    public String gerarTextoRemoverAD(@Valid @ModelAttribute("remocao") RemoverDoADDTO remocao,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "remover-ad";
        }

        String textoFormatado = chamadoService.formatarRemocaoAD(remocao);
        model.addAttribute("textoFormatado", textoFormatado);
        return "remover-ad";
    }

    @Operation(summary = "Exibe formulário de devolução de equipamento")
    @GetMapping("/devolucao")
    public String exibirFormularioDevolucao(Model model) {
        model.addAttribute("devolucao", new DevolucaoEquipamentoDTO());
        return "devolucao";
    }

    @Operation(summary = "Gera texto de devolução de equipamento", description = "Recebe tipo, patrimônio e setor, salva e retorna texto formatado")
    @PostMapping("/devolucao/gerar")
    public String gerarTextoDevolucao(@Valid @ModelAttribute("devolucao") DevolucaoEquipamentoDTO devolucao,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "devolucao";
        }

        String textoFormatado = chamadoService.formatarDevolucao(devolucao);
        model.addAttribute("textoFormatado", textoFormatado);
        return "devolucao";
    }

    @Operation(summary = "Busca histórico de chamados", description = "Retorna todos os chamados gerados, ordenados por data (mais recente primeiro)")
    @GetMapping("/historico")
    public String exibirHistorico(Model model) {
        model.addAttribute("registros", chamadoService.buscarHistorico());
        return "historico";
    }
}
