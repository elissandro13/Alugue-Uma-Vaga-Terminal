import br.cefetmg.concretas.Vaga;
import br.cefetmg.enums.EstadoEnum;
import br.cefetmg.concretas.Alugar;
import br.cefetmg.concretas.Pessoa;
import java.util.*;



public class Main {

    public static ArrayList vagas = new ArrayList();
    public static ArrayList pessoas = new ArrayList();
    public static EstadoEnum livre = EstadoEnum.LIVRE;
    public static EstadoEnum ocupado = EstadoEnum.OCUPADO;
    public static EstadoEnum indis = EstadoEnum.INDISPONIVEL;

    public static final Scanner scanner = new Scanner(System.in);

    public static Pessoa cadastrarPessoa(){
        System.out.println("Digite o nome da pessoa: ");
        String nome = lerTeclado();
        System.out.println("Digite o cpf da pessoa: ");
        String cpf = lerTeclado();
        System.out.println("Digite o saldo da pessoa: ");
        double saldo = lerTecladoDouble();
        lerTeclado();
        Pessoa p = new Pessoa(nome, cpf,saldo);
        return p;
    }

    public static Pessoa compararPessoa(String cpf){
        for (int i = 0; i < pessoas.size(); i++) {
            Pessoa p = (Pessoa) pessoas.get(i);
            if(p.getCpf().equals(cpf)){
                return p;
            }
        }
        return null;
    }
    public static Vaga cadastrarVaga(Pessoa p,int num){
        System.out.println("Estado de ocupação: L - Para Livre I - Para Indisponível");
        String estadoEscolha = lerTeclado().toUpperCase();
        String estado;
        if(estadoEscolha.equals("L")){
            estado = livre.name();
        }
        else {
            estado = indis.name();
        }
        System.out.println("Digite o valor de aluguel da vaga:  Caso não deseje alugar coloque '0' ");
        double valor = lerTecladoDouble();
        lerTeclado();
        Vaga vaga = new Vaga(p,estado,num,valor);
        return vaga;
    }
    public static int lerTecladoInt(){
        return scanner.nextInt();
    }
    private static void mudarEstado(Vaga v, String estadoTemporario) {
        if(v.getEstado().equals(estadoTemporario)){
            System.out.println("A vaga já está nesse estado");
        }
        else {
            v.setEstado(estadoTemporario);
        }
    }
    public static double lerTecladoDouble(){
        return scanner.nextDouble();
    }
    public static String lerTeclado(){
        return scanner.nextLine();
    }
    public static void main(String[] args) {
       
        
        String action;
        int contPosicao = 0;
        Alugar alugar = new Alugar();
        boolean quit = false;
        do {
            Pessoa p;
            System.out.println("\n\t-------------------------------------\n"
            + "\t// 1 - Para Cadastrar Nova Vaga\n"
            + "\t// 2 - Para Listar Todas as Vagas\n"
            + "\t// 3 - Para Checar Uma Vaga Especifica\n"
            + "\t// 4 - Para mudar o estado de uma vaga\n"
            + "\t// 5 - Para Cadastrar Uma pessoa\n"
            + "\t// 6 - Para Ler dados de uma pessoa\n"
            + "\t// 7 - Para Alugar uma Vaga\n"
            + "\t// 8 - Para Listar Todas as Pessoas\n"
            + "\t// 10 - Para sair\n"
            + "\t-------------------------------------\n");

            action = lerTeclado();
            switch (action) {
                case "1":
                    System.out.println("A - Para Cadastrar usando Uma Nova Pessoa\n"
                    + "B - Para Cadastrar Usando Uma pessoa Existente");
                    String opcao = lerTeclado().toUpperCase();
                    if(opcao.equals("A")){
                        Pessoa tempPessoa = cadastrarPessoa();
                        pessoas.add(tempPessoa);
                        Vaga v = cadastrarVaga(tempPessoa, contPosicao++);
                        //System.out.println(v.toString());
                        vagas.add(v);
                        
                    }
                    else {
                        System.out.println("Digite o cpf da pessoa: ");
                        String cpf = lerTeclado();
                        p = compararPessoa(cpf);
                        Vaga v = cadastrarVaga(p, contPosicao++);
                        vagas.add(v);

                    }
                    
                    
                
                    break;
                
                case "2":
                
                    for (int i = 0; i < vagas.size(); i++) {
                        Vaga v = (Vaga) vagas.get(i);
                        if(v.getEstado().equals(ocupado.name())){
                            System.out.println(v.toStringCompleto());
                        }
                        else {
                            System.out.println(v.toString());
                        }
                    }
                
                    break;
                case "3":

                    System.out.println("Digite a posição da vaga ");
                    int pos = lerTecladoInt();
                    lerTeclado();
                    Vaga v = (Vaga) vagas.get(pos);
                    System.out.println(v.toString() + "\n");

                    break;

                case "4":

                    System.out.println("Digite a posição da vaga: ");
                    pos = lerTecladoInt();
                    lerTeclado();
                    v = (Vaga) vagas.get(pos);
                    System.out.println("1 - Para tornar a vaga livre\n"
                    + "2 - Para tornar a vaga indisponivel");
                    int x = lerTecladoInt();
                    lerTeclado();
                    String estadoTemporario;
                    if (x == 1) {
                        estadoTemporario = livre.name();
                    }
                    else {
                        estadoTemporario = indis.name();
                    }
                    mudarEstado(v,estadoTemporario);

                    break;
                
                case "5":

                
                    pessoas.add(cadastrarPessoa());
                    
                    
                    
                    break;

                case "6":

                    System.out.println("Digite o cpf da pessoa: ");
                    String cpf = lerTeclado();
                    p = compararPessoa(cpf);
                    System.out.println(p.toString());

                    break;
                
                case "7":

                    System.out.println("Digite o número da vaga: ");
                    pos = lerTecladoInt();
                    lerTeclado();
                    v = (Vaga) vagas.get(pos);
                    System.out.println("Digite o cpf da pessoa que vai alugar: ");
                    cpf = lerTeclado();
                    p = compararPessoa(cpf);
                    System.out.println("Deseja mudar o preco do aluguel? s/n ");
                    String mudar = lerTeclado();
                    if (mudar.equals("s")) {
                        System.out.println("Digite o preço do aluguel: ");
                        Double preco = lerTecladoDouble();
                        lerTeclado();
                        alugar.Aluga(v,p,preco);
                    }
                    else  {
                        alugar.Aluga(v,p);
                    }
                    
                     

                    break;
                
                case "8":

                    for (int i = 0; i < pessoas.size(); i++) {
                        p =  (Pessoa) pessoas.get(i);
                        System.out.println(p.toString());
                        
                    }
                    break;

                case "10":
                    quit = true;
                    break;
                default:
                    System.out.println("Comando não catalogado");
                    break;
            }
        } while (quit == false);
        
        

        
    }

}