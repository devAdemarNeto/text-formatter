package br.com.ademar.textformatter.dto;

import java.time.LocalDateTime;

public class HistoricoItemDTO {

    private LocalDateTime dataCriacao;
    private String tipoChamado;
    private String resumo;

    public HistoricoItemDTO() {
    }

    public HistoricoItemDTO(LocalDateTime dataCriacao, String tipoChamado, String resumo) {
        this.dataCriacao = dataCriacao;
        this.tipoChamado = tipoChamado;
        this.resumo = resumo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getTipoChamado() {
        return tipoChamado;
    }

    public void setTipoChamado(String tipoChamado) {
        this.tipoChamado = tipoChamado;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }
}
