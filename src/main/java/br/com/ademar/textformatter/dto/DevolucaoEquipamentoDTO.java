package br.com.ademar.textformatter.dto;

import jakarta.validation.constraints.NotBlank;

public class DevolucaoEquipamentoDTO {

    @NotBlank(message = "O tipo de equipamento é obrigatório")
    private String tipoEquipamento;

    @NotBlank(message = "O patrimônio é obrigatório")
    private String patrimonio;

    @NotBlank(message = "O setor de origem é obrigatório")
    private String setorOrigem;

    public DevolucaoEquipamentoDTO() {
    }

    public String getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(String tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public String getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }

    public String getSetorOrigem() {
        return setorOrigem;
    }

    public void setSetorOrigem(String setorOrigem) {
        this.setorOrigem = setorOrigem;
    }
}
