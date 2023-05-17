package cla_war;

import java.util.Scanner;

public class Jogo {
    
    static void Iniciar(){
        System.out.println("=======Clã WAR========");
        Menu();
    }
    
    static void Menu(){
        int i = 1;
        Scanner in = new Scanner(System.in);
        
        while(i != 0){
            System.out.println("1- Iniciar Jogo");
            System.out.println("2- Como Jogar");
            System.out.println("3- Informações sobre o jogo");
            System.out.println("0- sair do jogo");
            System.out.println("Escolha uma opção acima: ");
            i = in.nextInt();
            
            switch(i){
                case 0: 
                    System.out.println("Obrigado por jogar clã war versão 1, saindo ...");
                default: 
                    System.out.println("Entrada inválida, tente novamente");
                    break;
            }
            
        }
    }
}
