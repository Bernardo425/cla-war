package cla_war;

import java.util.Scanner;
import java.util.Random;
import cla_war.Jogador;

public class Jogo {
   
    
    // função que será chamada na opção 1 do menu
    // retorna 1 caso o jogo decorra na normalidade e um dos jogadores saia vencedor
    // retorna 2 quando após a seleção dos jogadores, decidir-se não continuar para a batalha
    static int Jogar(){
        Scanner in = new Scanner(System.in);
        // declarando as variaveis para armazenar os dados do jogador 1 e os dados do jogador 2
        Jogador jogador1;
        Jogador jogador2;
        Jogador vencedor_do_turno = null;
        

        //recebendo os dados dos jogadores 1 e 2
        jogador1 = pedirJogadores(1);
        //enquanto o jogador 2 selecioanr o mesmo personagem que o jogador 1, é pedido para tentar novamente
        while((jogador2 = pedirJogadores(2)).numero_personagem == jogador1.numero_personagem) 
            System.out.println(jogador2.numero_personagem +" deculpa, mas o personagem " + jogador1.numero_personagem + " já foi escolhido, insira novamente os seus dados ecolhendo uma personagem diferente");

        System.out.println("Jogador 1 -" + jogador1.nome +"- foi selecionado para: " + jogador1.personagem.persona);
        System.out.println("Jogador 2 -" + jogador2.nome +"- foi selecionado para: " + jogador2.personagem.persona);

        System.out.println("Personagens escolhidos, deseja partir para a batalha? se sim digite 1, se não digite 0");
        System.out.print(">>");

        while(!in.hasNextInt()){
            System.out.println("XX entrada inválida, tem que inserir um número inteiro XX ");
            System.out.print(">>");
            in.nextLine();
        }
        if( in.nextInt() == 0 ) return 2;

        //Começo do código da batalha ...
        System.out.println("Começando a batalha...");

        // A BATAlha ocorre enquanto  energia vital dos jogadores for maior que 0, ou seja, basta a EV de um dos jogadores seja menor ou igual a zero, o jogo acaba
        for(int numero_turno = 1 /* variavel responsável por armazenar o valor de controle do turno */; (jogador1.personagem.ev > 0)  && (jogador2.personagem.ev > 0); numero_turno++){
            apresentarDados(jogador1, numero_turno);
            apresentarDados(jogador2, numero_turno);
            vencedor_do_turno = turno(jogador1, jogador2, numero_turno);

            System.out.println("seguir para o proximo turno? se sim digite 1, se não digite 0");
            System.out.print(">>");

            while(!in.hasNextInt()){
                System.out.println("XX entrada inválida, tem que inserir um número inteiro XX ");
                System.out.print(">>");
                in.nextLine();
            }
            if( in.nextInt() == 0 ) return 2;
        }

        
        //fim da batalha
        System.out.println("A batalha terminou, o jogador vencedor é : -"+vencedor_do_turno.nome+"-");
        System.out.println("voltando ao menu principal...");
        return 1;
    }

    //método responsável por apresentar os dados dos jogadores
    static void apresentarDados(Jogador jogador, int turno){
        System.out.println("Entrando no turno " + turno);
        System.out.println("Dados do jogador -" + jogador.nome +"-");
        System.out.println("EV: " + jogador.personagem.ev);
        System.out.println("CD: " + jogador.personagem.cd);
    }

    //método responsável por definir um turno e retornar o jogador responsável do turno
    static Jogador turno(Jogador jogador1, Jogador jogador2, int turno){
        Scanner in = new Scanner(System.in);
        Random r = new Random();
        //variavel responsável por armazenar o proprietario do turno
        Jogador proprietario_turno, nao_proprietario_turno;

        //variavel responsável por armazenar o estado de validação da entrada de valores
        boolean entrada_turno;
        //variaveis dos turnos, especificados no enunciado;
        int N, ND, FA, PNF;

        //se n for par, é a vez do jogador 2
        //se n não for par, é a vez do jogador 1
        if(turno%2 == 0){
            proprietario_turno = jogador2;
            nao_proprietario_turno = jogador1;
        }else{
            proprietario_turno = jogador1;
            nao_proprietario_turno = jogador2;
        }

        System.out.println("Vez do jogador -"+proprietario_turno.nome+"-");
        //essa estrutura de repetição permite que o jogador não prossiga enquanto não ser inserido um valor de N válido
        do{
            System.out.println("Digite um número de 1 a 9 ");
            System.out.print( "()"+proprietario_turno.nome+") >>");
            //enquanto não for digitado um inteiro
            while(!in.hasNextInt()){
                System.out.println("XX entrada inválida, tem que inserir um número inteiro XX ");
                System.out.print(">>");
                in.nextLine();
            }
            if(entrada_turno = ((N = in.nextInt()) < 1 || N > 9) ){
                System.out.println("?? opnção inválida, tente novamente ??");
            }
        }while(entrada_turno);

        //gerando o ND (número do dado), um número aleatório de 1 a 6
        System.out.println("Gerando o número do DADO...");
        System.out.println("::: " + (ND = r.nextInt(6) + 1));
        //calculando o PNF
        System.out.println("O valor mágico é: "+(PNF = (FA = proprietario_turno.personagem.fa) * N));
        if((PNF % ND) == 0 || (PNF % ND) == 0){
            //caso a condição seja verdadeira, ou seja, caso o PNF for múltiplo ou divisor de ND (número do dado) ou ND for divisor de PNF, o proprietario do turno vence 
            //na energia vital do jogador não proprietario do turno é subtraido o valor da capacidade de dano do proprietario do turno
            nao_proprietario_turno.personagem.descontarEv(proprietario_turno.personagem.cd);
            System.out.println(proprietario_turno.nome+" venceu o turno " + turno);
            return proprietario_turno;
        }else{
            //caso a condição não seja verdadeira, o jogador não proprietário do turno vence o turno e na energia vital do proprietario do turno de subtraida 25% da capacidade de dano do jogador não proprietario do turno
            proprietario_turno.personagem.descontarEv(nao_proprietario_turno.personagem.cd * 0.25);
            System.out.println(nao_proprietario_turno.nome+" venceu o turno " + turno);
            return nao_proprietario_turno;
        }
    }

    static Jogador pedirJogadores(int numero){

        Scanner in = new Scanner(System.in);
        Jogador jogador = new Jogador();

        boolean entrada_personagem;

        System.out.println();
        System.out.println("Dados do jogador " + numero +":");
        System.out.println("Insira o seu nome: ");
        System.out.print(">> ");
        jogador.nome = in.nextLine();
        
        do{
            System.out.println("Selecione o personagem: ");
            System.out.println("1- BernaBlood");
            System.out.println(" -- Capacidade de dano: 25");
            System.out.println(" -- Força de ataque: 3");
            System.out.println("2- EmiliNightmare");
            System.out.println(" -- Capacidade de dano: 15");
            System.out.println(" -- Força de ataque: 3");
            System.out.println("3- LindaMeduza");
            System.out.println(" -- Capacidade de dano: 17");
            System.out.println(" -- Força de ataque: 6");
            System.out.println("4- MiguelÂngelo");
            System.out.println(" -- Capacidade de dano: 19");
            System.out.println(" -- Força de ataque: 5");
            System.out.println("5- LeoSteel");
            System.out.println(" -- Capacidade de dano: 25");
            System.out.println(" -- Força de ataque: 5");
            System.out.println("6- IlmaStarfire");
            System.out.println(" -- Capacidade de dano: 30");
            System.out.println(" -- Força de ataque: 3");
            System.out.print(">> ");
            while(!in.hasNextInt()){
                System.out.println("XX entrada inválida, tem que inserir um número inteiro XX ");
                System.out.print(">>");
                in.nextLine();
            }
            if(entrada_personagem = ((jogador.numero_personagem = in.nextInt()) < 1 || jogador.numero_personagem > 6)){
                System.out.println("?? opnção inválida, tente novamente ??");
            }
        }while(entrada_personagem);

        jogador.selecionarPersonagem(jogador.numero_personagem);
        return jogador;
    }
}
