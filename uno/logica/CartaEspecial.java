package uno.logica;


public abstract class CartaEspecial extends Carta {
    protected String simbol;

    public CartaEspecial(Color color) {
        super(color);
    }

    @Override
    public boolean esCompatible(Carta otraCarta) {
        if (this.color == Color.Negre || otraCarta.color == Color.Negre){
            return true;
        } else if (otraCarta instanceof CartaEspecial) {
            CartaEspecial otra = (CartaEspecial) otraCarta;
            return this.simbol == otra.simbol || this.color == otra.color;
        }else {
            return this.color == otraCarta.getColor();
        }
    }
}


