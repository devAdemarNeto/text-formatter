package br.com.ademar.textformatter.mapper;

import br.com.ademar.textformatter.dto.ChamadoMonitorDTO;
import br.com.ademar.textformatter.dto.ChamadoPjeDTO;
import br.com.ademar.textformatter.dto.DevolucaoEquipamentoDTO;
import br.com.ademar.textformatter.dto.RemoverDoADDTO;
import br.com.ademar.textformatter.model.ChamadoMonitor;
import br.com.ademar.textformatter.model.ChamadoPje;
import br.com.ademar.textformatter.model.DevolucaoEquipamento;
import br.com.ademar.textformatter.model.RemoverDoAD;

public class ChamadoMapper {

    // ===== ChamadoPje =====

    public static ChamadoPje toEntity(ChamadoPjeDTO dto) {
        ChamadoPje entity = new ChamadoPje();
        entity.setNumeroProcesso(dto.getNumeroProcesso());
        entity.setNomeUsuario(dto.getNomeUsuario());
        entity.setCpfCnpj(dto.getCpfCnpj());
        entity.setModuloSistema(dto.getModuloSistema());
        entity.setDescricaoErro(dto.getDescricaoErro());
        return entity;
    }

    public static ChamadoPjeDTO toDTO(ChamadoPje entity) {
        ChamadoPjeDTO dto = new ChamadoPjeDTO();
        dto.setNumeroProcesso(entity.getNumeroProcesso());
        dto.setNomeUsuario(entity.getNomeUsuario());
        dto.setCpfCnpj(entity.getCpfCnpj());
        dto.setModuloSistema(entity.getModuloSistema());
        dto.setDescricaoErro(entity.getDescricaoErro());
        return dto;
    }

    // ===== ChamadoMonitor =====

    public static ChamadoMonitor toEntity(ChamadoMonitorDTO dto) {
        ChamadoMonitor entity = new ChamadoMonitor();
        entity.setPatrimonioMonitor(dto.getPatrimonioMonitor());
        entity.setPatrimonioNotebook(dto.getPatrimonioNotebook());
        entity.setConexoesDisponiveis(dto.getConexoesDisponiveis());
        entity.setMotivoSubstituicao(dto.getMotivoSubstituicao());
        return entity;
    }

    public static ChamadoMonitorDTO toDTO(ChamadoMonitor entity) {
        ChamadoMonitorDTO dto = new ChamadoMonitorDTO();
        dto.setPatrimonioMonitor(entity.getPatrimonioMonitor());
        dto.setPatrimonioNotebook(entity.getPatrimonioNotebook());
        dto.setConexoesDisponiveis(entity.getConexoesDisponiveis());
        dto.setMotivoSubstituicao(entity.getMotivoSubstituicao());
        return dto;
    }

    // ===== RemoverDoAD =====

    public static RemoverDoAD toEntity(RemoverDoADDTO dto) {
        RemoverDoAD entity = new RemoverDoAD();
        entity.setPatrimonio(dto.getPatrimonio());
        entity.setMotivoRemocao(dto.getMotivoRemocao());
        entity.setSetorEquipamento(dto.getSetorEquipamento());
        return entity;
    }

    public static RemoverDoADDTO toDTO(RemoverDoAD entity) {
        RemoverDoADDTO dto = new RemoverDoADDTO();
        dto.setPatrimonio(entity.getPatrimonio());
        dto.setMotivoRemocao(entity.getMotivoRemocao());
        dto.setSetorEquipamento(entity.getSetorEquipamento());
        return dto;
    }

    // ===== DevolucaoEquipamento =====

    public static DevolucaoEquipamento toEntity(DevolucaoEquipamentoDTO dto) {
        DevolucaoEquipamento entity = new DevolucaoEquipamento();
        entity.setTipoEquipamento(dto.getTipoEquipamento());
        entity.setPatrimonio(dto.getPatrimonio());
        entity.setSetorOrigem(dto.getSetorOrigem());
        return entity;
    }

    public static DevolucaoEquipamentoDTO toDTO(DevolucaoEquipamento entity) {
        DevolucaoEquipamentoDTO dto = new DevolucaoEquipamentoDTO();
        dto.setTipoEquipamento(entity.getTipoEquipamento());
        dto.setPatrimonio(entity.getPatrimonio());
        dto.setSetorOrigem(entity.getSetorOrigem());
        return dto;
    }
}
