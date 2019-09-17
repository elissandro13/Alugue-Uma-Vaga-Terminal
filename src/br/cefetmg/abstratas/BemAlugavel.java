package br.cefetmg.abstratas;

import br.cefetmg.concretas.Pessoa;

public abstract class BemAlugavel {
    private Pessoa dono;
    private Pessoa usuario;
    private String estado;
    public double preco;
    
    public BemAlugavel(Pessoa dono, String estado,double valor) {
        this.dono = dono;
        this.estado = estado;
        this.usuario = null;
        this.preco = valor;
    }
    
    public Pessoa getDono() {
        return dono;
    }

    public void setDono(Pessoa dono) {
        this.dono = dono;
    }

    public Pessoa getUsuario() {
        return usuario;
    }

    public void setUsuario(Pessoa usuario) {
        this.usuario = usuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "BemAlugavel;";
    }

    public abstract double getPreco();
    
    

    public void setPreco(double preco) {
        this.preco = preco;
    }


}