package uno.logica;

public class MesDos extends CartaEspecial {
    public MesDos(String sim, Color color){
        super(color);
        this.simbol = "+2";
    }

    public void accio(Mazo mazo, Jugador jugador, OrdreJugadors ordre) {
        ordre.passarTorn();
        jugador.robarCarta(mazo);
        jugador.robarCarta(mazo);
        System.out.println("El jugador ha robat 2 cartes");
    }
}
