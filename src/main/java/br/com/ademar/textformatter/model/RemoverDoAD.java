package br.com.ademar.textformatter.model;

import jakarta.validation.constraints.NotBlank;

public class RemoverDoAD {

    @NotBlank(message = "O patrimônio é obrigatório")
    private String patrimonio;

    @NotBlank(message = "O motivo da remoção é obrigatório")
    private String motivoRemocao;

    @NotBlank(message = "O setor do equipamento é obrigatório")
    private String setorEquipamento;

    public RemoverDoAD() {
    }

    public String getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }

    public String getMotivoRemocao() {
        return motivoRemocao;
    }

    public void setMotivoRemocao(String motivoRemocao) {
        this.motivoRemocao = motivoRemocao;
    }

    public String getSetorEquipamento() {
        return setorEquipamento;
    }

    public void setSetorEquipamento(String setorEquipamento) {
        this.setorEquipamento = setorEquipamento;
    }
}
