package uno.logica;

public class CanviSentit extends CartaEspecial{
    public CanviSentit(String sim, Color color){
        super(color);
        this.simbol = "\uD83D\uDEC7";
    }
    public void accio(OrdreJugadors ordre){
        ordre.canviDeSentit();
    }
}
