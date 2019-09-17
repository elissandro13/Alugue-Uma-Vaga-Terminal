package br.cefetmg.concretas;


import br.cefetmg.abstratas.BemAlugavel;

public class Vaga extends BemAlugavel {
    private int numero;

    public Vaga(Pessoa dono, String estado, int numero,double valor) {
        super(dono, estado,valor);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "\n\t*******************************\n\tVaga Número " + this.numero + "\n\tDono : " + getDono().getNome() + "\n\tEstado de Ocupação: " + getEstado() +  "\n\t*******************************\n";
    }

    public String toStringCompleto(){
        return "\n\t*******************************\n\tVaga Número " + this.numero + "\n\tDono : " + getDono().getNome() + "\n\tEstado de Ocupação: " + getEstado() + "\n\tLocatário " + this.getUsuario().getNome() + 
        "\n\tPreco do aluguel : "+ this.getPreco() + "\n\t*******************************\n";
    }
    
    @Override
    public  double getPreco(){
        return this.preco;
    }
    


}