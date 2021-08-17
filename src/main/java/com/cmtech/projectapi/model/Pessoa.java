package com.cmtech.projectapi.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String nome;

    @Embedded
    private Endereco endereco;

    @NotNull
    private boolean ativo;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pessoa pessoa = (Pessoa) o;

        if (ativo != pessoa.ativo) return false;
        return nome.equals(pessoa.nome);
    }

    @Override
    public int hashCode() {
        int result = nome.hashCode();
        result = 31 * result + (ativo ? 1 : 0);
        return result;
    }
}
