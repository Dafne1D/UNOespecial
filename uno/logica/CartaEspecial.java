package uno.logica;


public abstract class CartaEspecial extends Carta {
    protected String simbol;

    public void accio(){
    }

    public CartaEspecial(Color color) {
        super(color);
    }

    public String getSimbol() {
        return simbol;
    }

    @Override
    public boolean esCompatible(Carta otraCarta) {
        return this.color == otraCarta.getColor();
    }
}


class mesDos extends CartaEspecial {
    public mesDos(String sim, Color color){
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

class mesQuatre extends CartaEspecial{
    public mesQuatre(Color color){
        super(color);
        this.simbol = "+4";
    }
    public void accio(Mazo mazo, Jugador jugador, OrdreJugadors ordre){
        ordre.passarTorn();
        for (int i = 0; i<4; i++){
            jugador.robarCarta(mazo);
        }
    }
}

class canviSentit extends CartaEspecial{
    public  canviSentit(Color color){
        super(color);
        this.simbol = "\uD83D\uDEC7";
    }
    public void accio(OrdreJugadors ordre){

    }
}
