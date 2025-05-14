package uno.logica;

public class CartaNormal extends Carta {
    private final int numero;

    public CartaNormal(int numero, Color color) {
        super(color);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public boolean esCompatible(Carta otraCarta) {
        if (otraCarta instanceof CartaNormal) {
            CartaNormal otra = (CartaNormal) otraCarta;
            return this.numero == otra.numero || this.color == otra.color;
        } else {
            return this.color == otraCarta.getColor();
        }
    }
}