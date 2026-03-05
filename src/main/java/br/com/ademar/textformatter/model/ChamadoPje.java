package br.com.ademar.textformatter.model;

public class ChamadoPje {

    private String numeroProcesso;
    private String nomeUsuario;
    private String cpfCnpj;
    private String moduloSistema;
    private String descricaoErro;

    public ChamadoPje() {
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
