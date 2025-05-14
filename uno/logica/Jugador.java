package uno.logica;

import java.util.ArrayList;

public class Jugador {
    private final String nom;
    private ArrayList<CartaNormal> cartes;

    public Jugador(String nomJugador) {
        nom = nomJugador;
        cartes = new ArrayList<>();
    }

    public String getNom(){return nom;}
    public ArrayList<CartaNormal> getCartes(){return cartes;}

    public int nombreDeCartes() {
        return cartes.size();
    }

    public void tirarCarta(CartaNormal cartaNormal, Pilo pilo) {
        cartes.remove(cartaNormal);
        pilo.addCarta(cartaNormal);
    }

    public void robarCarta(Mazo mazo) {
        cartes.add(mazo.agafarCarta());
    }

    public boolean potTirarCarta(Pilo pilo) {
        boolean jugadorPotTirar = false;
        Carta ultimaCarta = pilo.consultarCarta();
        for (Carta carta: cartes) {
            if (ultimaCarta.esCompatible(carta)){
                jugadorPotTirar = true;
            }
        }
        return jugadorPotTirar;
    }
}
