package br.com.ademar.textformatter.dto;

public class ChamadoMonitorDTO {

    private String patrimonioMonitor;
    private String patrimonioNotebook;
    private String conexoesDisponiveis;
    private String motivoSubstituicao;

    public ChamadoMonitorDTO() {
    }

    public String getPatrimonioMonitor() {
        return patrimonioMonitor;
    }

    public void setPatrimonioMonitor(String patrimonioMonitor) {
        this.patrimonioMonitor = patrimonioMonitor;
    }

    public String getPatrimonioNotebook() {
        return patrimonioNotebook;
    }

    public void setPatrimonioNotebook(String patrimonioNotebook) {
        this.patrimonioNotebook = patrimonioNotebook;
    }

    public String getConexoesDisponiveis() {
        return conexoesDisponiveis;
    }

    public void setConexoesDisponiveis(String conexoesDisponiveis) {
        this.conexoesDisponiveis = conexoesDisponiveis;
    }

    public String getMotivoSubstituicao() {
        return motivoSubstituicao;
    }

    public void setMotivoSubstituicao(String motivoSubstituicao) {
        this.motivoSubstituicao = motivoSubstituicao;
    }
}
