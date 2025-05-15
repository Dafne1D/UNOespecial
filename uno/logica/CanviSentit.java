package uno.logica;

import uno.Partida;

public class CanviSentit extends CartaEspecial{
    Partida partida;
    public CanviSentit(Partida partida, Color color){
        super(color);
        this.simbol="S";
        this.partida = partida;
    }
    public void accio(Partida partida){
        OrdreJugadors ordre = partida.getOrdreJugadors();
        Jugador jugador = ordre.getJugadorActiu();
        ordre.canviDeSentit();
        System.out.println("S'ha canvia el sentit li toca a "+jugador.getNom());
    }
}
