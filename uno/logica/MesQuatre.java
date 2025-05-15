package uno.logica;

import uno.Partida;

public class MesQuatre extends CartaEspecial{
    Partida partida;

    public MesQuatre(Partida partida){
        super(Color.Negre);
        this.simbol = "+4";
        this.partida = partida;
    }
    public void accio(){
        OrdreJugadors ordre = partida.getOrdreJugadors();

        ordre.passarTorn();
        Jugador jugador = ordre.getJugadorActiu();
        Mazo mazo = partida.getMazo();
        for (int i = 0; i<4; i++){
            jugador.robarCarta(mazo);
        }
        System.out.println(jugador.getNom()+" Ha robat 4 cartes");
    }
}
