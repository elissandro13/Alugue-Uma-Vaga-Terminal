package br.cefetmg.enums;

public enum EstadoEnum {    
    LIVRE(1), OCUPADO(2), INDISPONIVEL(3);
     
    private final int valor;
    EstadoEnum(int valorOpcao){
        valor = valorOpcao;
    }
    public int getValor(){
        return valor;
    }
}