package br.com.ademar.textformatter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class ChamadoMonitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patrimonioMonitor;
    private String patrimonioNotebook;
    private String conexoesDisponiveis;
    private String motivoSubstituicao;
    private LocalDateTime dataCriacao;

    public ChamadoMonitor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
