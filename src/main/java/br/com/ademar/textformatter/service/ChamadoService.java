package br.com.ademar.textformatter.service;

import br.com.ademar.textformatter.dto.ChamadoMonitorDTO;
import br.com.ademar.textformatter.dto.ChamadoPjeDTO;
import br.com.ademar.textformatter.dto.DevolucaoEquipamentoDTO;
import br.com.ademar.textformatter.dto.RemoverDoADDTO;
import br.com.ademar.textformatter.mapper.ChamadoMapper;
import br.com.ademar.textformatter.model.ChamadoMonitor;
import br.com.ademar.textformatter.model.ChamadoPje;
import br.com.ademar.textformatter.model.DevolucaoEquipamento;
import br.com.ademar.textformatter.model.RemoverDoAD;
import br.com.ademar.textformatter.repository.ChamadoMonitorRepository;
import br.com.ademar.textformatter.repository.ChamadoPjeRepository;
import br.com.ademar.textformatter.repository.DevolucaoEquipamentoRepository;
import br.com.ademar.textformatter.repository.RemoverDoADRepository;
import org.springframework.stereotype.Service;

@Service
public class ChamadoService {

    private final ChamadoPjeRepository chamadoPjeRepository;
    private final ChamadoMonitorRepository chamadoMonitorRepository;
    private final RemoverDoADRepository removerDoADRepository;
    private final DevolucaoEquipamentoRepository devolucaoEquipamentoRepository;

    public ChamadoService(ChamadoPjeRepository chamadoPjeRepository,
            ChamadoMonitorRepository chamadoMonitorRepository,
            RemoverDoADRepository removerDoADRepository,
            DevolucaoEquipamentoRepository devolucaoEquipamentoRepository) {
        this.chamadoPjeRepository = chamadoPjeRepository;
        this.chamadoMonitorRepository = chamadoMonitorRepository;
        this.removerDoADRepository = removerDoADRepository;
        this.devolucaoEquipamentoRepository = devolucaoEquipamentoRepository;
    }

    public String formatarChamadoPje(ChamadoPjeDTO dto) {
        ChamadoPje entity = ChamadoMapper.toEntity(dto);
        chamadoPjeRepository.save(entity);

        return "===== CHAMADO N3 - PJe =====\n\n"
                + "Número do Processo: " + entity.getNumeroProcesso() + "\n"
                + "Usuário Afetado: " + entity.getNomeUsuario() + "\n"
                + "CPF/CNPJ: " + entity.getCpfCnpj() + "\n"
                + "Módulo do Sistema: " + entity.getModuloSistema() + "\n"
                + "Descrição do Erro: " + entity.getDescricaoErro();
    }

    public String formatarChamadoMonitor(ChamadoMonitorDTO dto) {
        ChamadoMonitor entity = ChamadoMapper.toEntity(dto);
        chamadoMonitorRepository.save(entity);

        return String.format(
                "Usuário solicita a substituição do monitor de patrimônio %s, que apresenta o seguinte defeito: %s. "
                        + "O monitor está conectado ao notebook de patrimônio %s. "
                        + "As conexões disponíveis no equipamento são: %s.",
                entity.getPatrimonioMonitor(),
                entity.getMotivoSubstituicao(),
                entity.getPatrimonioNotebook(),
                entity.getConexoesDisponiveis());
    }

    public String formatarRemocaoAD(RemoverDoADDTO dto) {
        RemoverDoAD entity = ChamadoMapper.toEntity(dto);
        removerDoADRepository.save(entity);

        return String.format(
                "Solicito a remoção do computador %s do Active Directory. Motivo: %s. Setor de origem: %s.",
                entity.getPatrimonio(),
                entity.getMotivoRemocao(),
                entity.getSetorEquipamento());
    }

    public String formatarDevolucao(DevolucaoEquipamentoDTO dto) {
        DevolucaoEquipamento entity = ChamadoMapper.toEntity(dto);
        devolucaoEquipamentoRepository.save(entity);

        return String.format(
                "Usuário solicita a devolução de %s, patrimônio %s, referente ao setor: %s. "
                        + "O equipamento deverá ser retirado do inventário da unidade.",
                entity.getTipoEquipamento(),
                entity.getPatrimonio(),
                entity.getSetorOrigem());
    }
}
