package uno.logica;


public abstract class CartaEspecial extends Carta {
    protected String simbol;

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


