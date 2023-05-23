
package isptec.pii.pp2.cla_war.jogo;

public class Jogador {
    public Personagem personagem;
    public String nome;
    public int numero_personagem;
    
    public void selecionarPersonagem(int numero_personagem){
        
        Personagem personagem = new Personagem();
        personagem.ev = 100;
        
        switch(numero_personagem){
            case 1:
                //BernaBlood
                personagem.persona = "BernaBlood";
                personagem.cd = 25;
                personagem.fa = 3;
                personagem.ab = 1;
                break;
            case 2:
                //Emili Nightmare
                personagem.persona = "Emili Nightmare";
                personagem.cd = 15;
                personagem.fa = 3;
                personagem.ab = 2;
                break;
            case 3:
                //Linda Meduza
                personagem.persona = "Linda Meduza";
                personagem.cd = 17;
                personagem.fa = 6;
                personagem.ab = 3;
                break;
            case 4:
                //Miguel Ângelo
                personagem.persona = "Miguel Ângelo";
                personagem.cd = 19;
                personagem.fa = 5;
                personagem.ab = 4;
                break;
            case 5:
                //LeoSteel
                personagem.persona = "LeoSteel";
                personagem.cd = 25;
                personagem.fa = 6;
                personagem.ab = 5;
                break;
            case 6:
                //Ilma Starfire
                personagem.persona = "Ilma Starfire";
                personagem.cd = 30;
                personagem.fa = 3;
                personagem.ab = 6;
                break;
        }
        
        this.personagem = personagem;
    }
}
