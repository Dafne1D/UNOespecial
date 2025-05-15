package uno.logica;

import uno.Partida;

public class MesDos extends CartaEspecial {
    Partida partida;
    public MesDos(Partida partida, Color color){
        super(color);
        this.simbol="+2";
        this.partida = partida;
    }

    public void accio() {
        OrdreJugadors ordre = partida.getOrdreJugadors();
        ordre.passarTorn();
        Jugador jugador = ordre.getJugadorActiu();
        Mazo mazo = partida.getMazo();
        jugador.robarCarta(mazo);
        jugador.robarCarta(mazo);
        System.out.println(jugador.getNom()+"ha robat 2 cartes");
    }
}
