package cla_war;

public class Personagem {
    //energia vital
    public double ev;
    //capacidade de dano
    public int cd;
    //força de ataque
    public int fa;
    //abilidade especial
    public int ab;
    //a personagem
    public String persona;
    
    //método que define a abilidade especiald e cada jogador com base no atributo ab
    public void habilidadeEspecial(){
        
    }

    //método que desconta valores na ev (energia vital) do personagem
    public void descontarEv(double valor){
        this.ev -= valor;  
    }

}
