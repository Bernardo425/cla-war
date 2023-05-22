package cla_war;
import cla_war.Jogo;
import java.util.Scanner;

public class Cla_war {

    public static void main(String[] args) {
        int i = 1;
        Scanner in = new Scanner(System.in);
        
        System.out.println("=======Clã WAR========");
        //Menu principal
        while(i != 0){
            System.out.println("1- Iniciar Jogo");
            System.out.println("2- Como Jogar");
            System.out.println("3- Informações sobre o jogo");
            System.out.println("0- sair do jogo");
            System.out.println("Escolha uma opção acima: ");
            System.out.print(">>");
            while(!in.hasNextInt()){
                System.out.println("XX entrada inválida, tem que inserir um número inteiro XX");
                System.out.print(">>");
                in.nextLine();
            }
            i = in.nextInt();
            
            switch(i){
                case 0: 
                    System.out.println("Obrigado por jogar clã war versão 1, saindo ...");
                    break;
                case 1:
                    System.out.println("Selecionando jogadores");
                    Jogo.Jogar();
                    break;
                default:
                    System.out.println("?? opção inválida, tente novamente ??");
                    break;
            }
            
        }
    }
    
}
