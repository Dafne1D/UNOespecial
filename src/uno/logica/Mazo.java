package uno.logica;

import java.util.Collections;
import java.util.Stack;

public class Mazo {
    private Stack<Carta> cartes;

    public Mazo() {
        cartes = new Stack<>();
        for (Carta.Color color : Carta.Color.values()) {
            cartes.push(new CartaNormal(0,color));
            for (int i=1; i<=9; i++){
                cartes.push(new CartaNormal(i,color));
                cartes.push(new CartaNormal(i,color));
            }
            //Crear les cartes mesDos, ho posu 2 vegades ja que necesito 8.
            cartes.push(new MesDos("+2",color));
            cartes.push(new MesDos("+2",color));
            //Crear cares canvi sentit
            cartes.push(new CanviSentit("\uD83D\uDEC7",color));
            cartes.push(new CanviSentit("\uD83D\uDEC7",color));
            //crear mes quatre
            cartes.push(new MesQuatre(null));
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
