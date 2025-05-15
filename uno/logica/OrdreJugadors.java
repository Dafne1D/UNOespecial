package uno.logica;

import java.util.LinkedList;
import java.util.Collections;

public class OrdreJugadors {
    private LinkedList<Jugador> jugadors;
    private int jugadorActiuIndex = 0;
    private boolean sentitNormal = true;

    public OrdreJugadors() {
        jugadors = new LinkedList<>();
    }

    public Jugador getJugadorActiu() { return jugadors.get(jugadorActiuIndex); }

    public void crearJugador(String nomJugador) {
        jugadors.add(new Jugador(nomJugador));
    }

    public void passarTorn() {
        if (sentitNormal){
            jugadorActiuIndex++;
            if (jugadorActiuIndex > jugadors.size()-1){
                jugadorActiuIndex = 0;
            }
        }else {
            jugadorActiuIndex--;
            if (jugadorActiuIndex < 0){
                jugadorActiuIndex = jugadors.size()-1;
            }
        }
    }

    public void canviDeSentit() {
        sentitNormal = !sentitNormal;
        passarTorn();
    }



    public void barrejarOrdre() {
        Collections.shuffle(jugadors);
    }
}
