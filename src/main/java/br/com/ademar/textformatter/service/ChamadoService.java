package br.com.ademar.textformatter.service;

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
                + "Descrição do Erro: " + chamado.getDescricaoErro() + "\n"
                + "Link do Print: " + chamado.getLinkPrint();
    }
}
