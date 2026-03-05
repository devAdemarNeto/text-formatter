package br.com.ademar.textformatter.dto;

import jakarta.validation.constraints.NotBlank;

public class ChamadoPjeDTO {

    @NotBlank(message = "O número do processo é obrigatório")
    private String numeroProcesso;

    @NotBlank(message = "O nome do usuário é obrigatório")
    private String nomeUsuario;

    private String cpfCnpj;
    private String moduloSistema;

    @NotBlank(message = "A descrição do erro é obrigatória")
    private String descricaoErro;

    public ChamadoPjeDTO() {
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getModuloSistema() {
        return moduloSistema;
    }

    public void setModuloSistema(String moduloSistema) {
        this.moduloSistema = moduloSistema;
    }

    public String getDescricaoErro() {
        return descricaoErro;
    }

    public void setDescricaoErro(String descricaoErro) {
        this.descricaoErro = descricaoErro;
    }
}
