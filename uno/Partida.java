package uno;

import uno.interficie.*;
import uno.logica.*;

import java.util.ArrayList;

public class Partida {
    private int NOMBRE_INICIAL_CARTES = 7;

    private int quantitatJugadors;

    Mazo mazo = new Mazo(this);
    Pilo pilo = new Pilo();
    OrdreJugadors ordreJugadors = new OrdreJugadors();

    public void jugar() {
        preparar();
        boolean partidaAcabada = false;
        do {
            partidaAcabada = torn();
        } while (!partidaAcabada);
        UI.victoria(ordreJugadors.getJugadorActiu());
    }

    private void preparar() {
        mazo.barrejar();

        ArrayList<String> nomsJugadors = UI.demanarJugadors();
        quantitatJugadors = nomsJugadors.size();
        for (String nomJugador : nomsJugadors) {
            ordreJugadors.crearJugador(nomJugador);
        }
        ordreJugadors.barrejarOrdre();

        repartirCartes();

        Carta primeraCarta = mazo.agafarCarta();
        pilo.addCarta(primeraCarta);
    }

    private boolean torn() {
        // torn() torna true si la partida acaba, False si continua.
        Jugador jugadorActiu = ordreJugadors.getJugadorActiu();
        UI.tornJugador(jugadorActiu, pilo);

        boolean potTirar = jugadorActiu.potTirarCarta(pilo);
        while (!potTirar) {
            if (mazo.esBuid()) {
                mazo.reiniciar(pilo);
            } else {
                UI.senseCartes();
                jugadorActiu.robarCarta(mazo);
                potTirar = jugadorActiu.potTirarCarta(pilo);
            }
        }
        Carta cartaTirada = UI.demanarCarta(jugadorActiu, pilo);
        jugadorActiu.tirarCarta(cartaTirada,pilo);

        if (jugadorActiu.nombreDeCartes() <= 0) {
            return true;
        } else {
            ordreJugadors.passarTorn();
            return false;
        }
    }

    private void repartirCartes() {
        for (int i=0; i<quantitatJugadors*NOMBRE_INICIAL_CARTES; i++){
            ordreJugadors.getJugadorActiu().robarCarta(mazo);
            ordreJugadors.passarTorn();
        }
    }

    public OrdreJugadors getOrdreJugadors() { return ordreJugadors; }
    public Mazo getMazo(){return mazo;}
}
