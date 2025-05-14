package uno.logica;

import java.util.Collections;
import java.util.Stack;

public class Mazo {
    private Stack<Carta> cartes;

    public Mazo() {
        cartes = new Stack<>();
        for (CartaNormal.Color color : CartaNormal.Color.values()) {
            cartes.push(new CartaNormal(0,color));
            for (int i=1; i<=9; i++){
                cartes.push(new CartaNormal(i,color));
                cartes.push(new CartaNormal(i,color));
            }
            //Crear les cartes mesDos, ho posu 2 vegades ja que necesito 8.
            cartes.push(new mesDos("+2",color));
            cartes.push(new mesDos("+2",color));
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
        CartaNormal primeraCartaNormal = pilo.agafarCarta();
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
