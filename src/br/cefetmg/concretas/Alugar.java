package br.cefetmg.concretas;


import br.cefetmg.enums.EstadoEnum;
import br.cefetmg.abstratas.BemAlugavel;



public class Alugar {
    EstadoEnum livre = EstadoEnum.LIVRE;
    EstadoEnum ocupado = EstadoEnum.OCUPADO;
    EstadoEnum indis = EstadoEnum.INDISPONIVEL;
    public void Aluga(BemAlugavel bem,Pessoa usuario,double preco){
        if(livre.name().equals(bem.getEstado())){
            if(usuario.getSaldo() < preco){
                System.out.println("Saldo do contratante insuficiente");
            }
            else {
                bem.setUsuario(usuario);
                bem.setEstado(ocupado.name());
                bem.setPreco(preco);
                bem.getUsuario().setSaldo(usuario.getSaldo()-preco);
                bem.getDono().setSaldo(bem.getDono().getSaldo()+preco);
            }
        }
        else if(indis.name().equals(bem.getEstado())){
            System.out.println("Essa vaga não pode ser alugada");
        }
        else if(ocupado.name().equals(bem.getEstado())){
            System.out.println("Vaga está ocupada");
        }
    }

    public void Aluga(BemAlugavel bem,Pessoa usuario){
        if(livre.name().equals(bem.getEstado())){
            if(usuario.getSaldo() < bem.getPreco()){
                System.out.println("Saldo do contratante insuficiente");
            }
            else {
                bem.setUsuario(usuario);
                bem.setEstado(ocupado.name());
                double preco = bem.getPreco();
                bem.getUsuario().setSaldo(usuario.getSaldo()-preco);
                bem.getDono().setSaldo(bem.getDono().getSaldo()+preco);
            }
        }
        else if(indis.name().equals(bem.getEstado())){
            System.out.println("Essa vaga não pode ser alugada");
        }
        else if(ocupado.name().equals(bem.getEstado())){
            System.out.println("Vaga está ocupada");
        }
    }
}