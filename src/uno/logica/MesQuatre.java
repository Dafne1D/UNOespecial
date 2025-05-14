package uno.logica;

public class MesQuatre extends CartaEspecial{
    public MesQuatre(Color color){
        super(null);
        this.simbol = "+4";
    }
    public void accio(Mazo mazo, Jugador jugador, OrdreJugadors ordre){
        ordre.passarTorn();
        for (int i = 0; i<4; i++){
            jugador.robarCarta(mazo);
        }
    }
}
