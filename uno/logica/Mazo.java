package uno.logica;

import uno.Partida;

import java.awt.*;
import java.util.Collections;
import java.util.Stack;

public class Mazo {
    private Stack<Carta> cartes;

    public Mazo(Partida partida) {
        cartes = new Stack<>();
        for (Carta.Color color : Carta.Color.values()) {
            if (color == Carta.Color.Negre){
                break;
            }
            cartes.push(new CartaNormal(0,color));
            for (int i=1; i<=9; i++){
                cartes.push(new CartaNormal(i,color));
                cartes.push(new CartaNormal(i,color));
            }
            //Crear les cartes mesDos, ho posu 2 vegades ja que necesito 8.
            cartes.push(new MesDos(partida, color));
            cartes.push(new MesDos(partida, color));
            //Crear cartes canvi sentit
            cartes.push(new CanviSentit(partida, color));
            cartes.push(new CanviSentit(partida,color));

            cartes.push(new Prohibit(partida, color));
            cartes.push(new Prohibit(partida, color));
        }
        for (int i = 0; i<4 ; i++) {
            cartes.push(new MesQuatre(partida));
        }
    }


    public boolean esBuid() {return cartes.isEmpty();}

    public Stack<Carta> getCartes() {
        return cartes;
    }

    public Carta agafarCarta() {
        return cartes.pop();
    }

    public void reiniciar(Pilo pilo) {
        Carta primeraCartaNormal = pilo.agafarCarta();
        while (!pilo.getCartes().empty()){
            cartes.push(pilo.agafarCarta());
        }
        pilo.addCarta(primeraCartaNormal);
        barrejar();
    }
    public void barrejar() {
        Collections.shuffle(cartes);
    }
}
