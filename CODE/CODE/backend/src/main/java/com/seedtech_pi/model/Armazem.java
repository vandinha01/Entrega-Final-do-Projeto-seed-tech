package com.seedtech_pi.model;

import jakarta.persistence.*;

@Entity
@Table(name="armazens")
public class Armazem {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String localizacao;
    @Column(name="capacidade_kg")
    private Double capacidadeKg;

    public Armazem() {}
    public Integer getId(){return id;}
    public void setId(Integer id){this.id=id;}
    public String getNome(){return nome;}
    public void setNome(String nome){this.nome=nome;}
    public String getLocalizacao(){return localizacao;}
    public void setLocalizacao(String l){this.localizacao=l;}
    public Double getCapacidadeKg(){return capacidadeKg;}
    public void setCapacidadeKg(Double c){this.capacidadeKg=c;}
}
