package br.cefetmg.concretas;

public class Pessoa {

    private String nome,cpf;
    private double saldo;
    
    public Pessoa(String nome,String cpf,double saldo){
        this.nome = nome;
        this.cpf = cpf;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "\n\t######################\n\t" + this.nome + "\n\tCPF : "  + this.cpf + "\n\tSaldo : " + this.saldo +"\n\t######################";
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}