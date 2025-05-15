package uno.logica;

import uno.Partida;

import java.sql.SQLOutput;

public class Prohibit extends CartaEspecial{
    Partida partida;
    public Prohibit(Partida partida, Color color){
        super(color);
        this.simbol="P";
        this.partida = partida;
    }
    public void accio(){
        OrdreJugadors ordre = partida.getOrdreJugadors();
        Jugador jugador = ordre.getJugadorActiu();
        ordre.passarTorn();
        System.out.println(jugador.getNom()+ "Ha estat bloquejat");
    }
}