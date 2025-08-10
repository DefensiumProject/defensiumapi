package br.com.defensium.defensiumapi.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_credencial")
public class CredencialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", nullable = false)
    private Long codigo;

    @Column(name = "codigo_public", unique = true, nullable = false)
    private String codigoPubico;

    @ManyToOne
    @JoinColumn(name = "id_plataforma", nullable = false)
    private PlataformaEntity plataformaEntity;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "usuario", nullable = false)
    private String usuario;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "url")
    private String url;

    @Column(name = "data_criacao", updatable = false, nullable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_edicao")
    private LocalDateTime dataEdicao;

    @Column(name = "data_delecao")
    private LocalDateTime dataDelecao;

    public CredencialEntity() {
        this.dataCriacao = LocalDateTime.now();
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getCodigoPubico() {
        return codigoPubico;
    }

    public void setCodigoPubico(String codigoPubico) {
        this.codigoPubico = codigoPubico;
    }

    public PlataformaEntity getPlataformaEntity() {
        return plataformaEntity;
    }

    public void setPlataformaEntity(PlataformaEntity plataformaEntity) {
        this.plataformaEntity = plataformaEntity;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataEdicao() {
        return dataEdicao;
    }

    public void setDataEdicao(LocalDateTime dataEdicao) {
        this.dataEdicao = dataEdicao;
    }

    public LocalDateTime getDataDelecao() {
        return dataDelecao;
    }

    public void setDataDelecao(LocalDateTime dataDelecao) {
        this.dataDelecao = dataDelecao;
    }

}
