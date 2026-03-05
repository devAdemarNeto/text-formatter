package br.com.ademar.textformatter.service;

import br.com.ademar.textformatter.model.ChamadoMonitor;
import br.com.ademar.textformatter.model.ChamadoPje;
import org.springframework.stereotype.Service;

@Service
public class ChamadoService {

    public String formatarChamadoPje(ChamadoPje chamado) {
        return "===== CHAMADO N3 - PJe =====\n\n"
                + "Número do Processo: " + chamado.getNumeroProcesso() + "\n"
                + "Usuário Afetado: " + chamado.getNomeUsuario() + "\n"
                + "CPF/CNPJ: " + chamado.getCpfCnpj() + "\n"
                + "Módulo do Sistema: " + chamado.getModuloSistema() + "\n"
                + "Descrição do Erro: " + chamado.getDescricaoErro();
    }

    public String formatarChamadoMonitor(ChamadoMonitor chamado) {
        return String.format(
                "Usuário solicita a substituição do monitor de patrimônio %s, que apresenta o seguinte defeito: %s. "
                        + "O monitor está conectado ao notebook de patrimônio %s. "
                        + "As conexões disponíveis no equipamento são: %s.",
                chamado.getPatrimonioMonitor(),
                chamado.getMotivoSubstituicao(),
                chamado.getPatrimonioNotebook(),
                chamado.getConexoesDisponiveis());
    }
}
