package uno.logica;

public abstract class Carta {
    protected Color color;
    public enum Color {
        Groc,
        Vermell,
        Blau,
        Verd,
    }

    public Carta(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
    public abstract boolean esCompatible(Carta otraCarta);
}