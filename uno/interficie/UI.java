package uno.interficie;

import uno.logica.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private static Scanner input = new Scanner(System.in);
    // ANSI escape codes 
    public static final String RESET = "\u001B[0m"; 
    public static final String RED = "\u001B[31m"; 
    public static final String GREEN = "\u001B[32m"; 
    public static final String YELLOW = "\u001B[33m"; 
    public static final String BLUE = "\u001B[34m";

    private static final int ALTURA_CARTA = 7;

    private static String pintarCarta(Carta carta) {
        String color = "";
        switch (carta.getColor()) {
            case Groc:
                color = YELLOW;
                break;
            case Vermell:
                color = RED;
                break;
            case Blau:
                color = BLUE;
                break;
            case Verd:
                color = GREEN;
                break;
            default:
                break;
        }

        String valorCarta;
        if (carta instanceof CartaNormal){
            CartaNormal cartaNormal = (CartaNormal) carta;
            valorCarta = String.valueOf(cartaNormal.getNumero());
        } else if (carta instanceof MesDos) {
            valorCarta = "+2";
        } else if (carta instanceof MesQuatre) {
            valorCarta = "+4";
        } else if (carta instanceof CanviSentit) {
            valorCarta = "S";
        } else{
            valorCarta = "P";
        }

        if (valorCarta.length() < 2){
            String cartaPintada = String.format("""
            %s┌─────────┐%s
            %s│ %s       │%s
            %s│         │%s
            %s│   UNO   │%s
            %s│         │%s
            %s│      %s  │%s
            %s└─────────┘%s""",
                    color, RESET,
                    color, valorCarta, RESET,
                    color, RESET,
                    color, RESET,
                    color, RESET,
                    color, valorCarta, RESET,
                    color, RESET);
            return cartaPintada;
        }else {
            String cartaPintada = String.format("""
            %s┌─────────┐%s
            %s│ %s      │%s
            %s│         │%s
            %s│   UNO   │%s
            %s│         │%s
            %s│      %s │%s
            %s└─────────┘%s""",
                    color, RESET,
                    color, valorCarta, RESET,
                    color, RESET,
                    color, RESET,
                    color, RESET,
                    color, valorCarta, RESET,
                    color, RESET);
            return cartaPintada;
        }
    }

    public static void mostrarCarta(Carta carta) {
        System.out.println(pintarCarta(carta));
    }

    public static void mostrarCartes(ArrayList<Carta> cartes) {
        int quantitat = cartes.size();
        String[][] cartesPintades = new String[quantitat][];

        for (int i = 0; i < quantitat; i++) {
            cartesPintades[i] = pintarCarta(cartes.get(i)).split("\n");
        }

        int altura = cartesPintades[0].length;

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < quantitat; j++) {
                System.out.print(cartesPintades[j][i] + "  ");
            }
            System.out.println();
        }
        System.out.print("    ");
        for (int j = 0; j < quantitat; j++) {
            if (j+1<10) {
                System.out.print("(" + (j+1) +")          ");
            }
            else {
                System.out.print("(" + (j+1) +")         ");
            }
        }
        System.out.println();
    }

    public static ArrayList<String> demanarJugadors() {
        System.out.print("Quanta gent jugará?: ");
        int quantitatJugadors = input.nextInt();
        input.nextLine();
        ArrayList<String> llistaNoms = new ArrayList<>();
        for (int i=1; i<quantitatJugadors+1; i++) {
            System.out.print("Introdueix el nom del jugador "+i+": ");
            String nomJugador = input.nextLine();
            llistaNoms.add(nomJugador);
        }
        System.out.println();
        return llistaNoms;
    }

    public static void tornJugador(Jugador jugador, Pilo pilo) {
        System.out.println("És el torn de "+jugador.getNom());
        mostrarUltimaCarta(pilo);
    }

    public static void senseCartes() {
        System.out.println("No tens cartes que puguis tirar. Robant una carta...");
    }

    public static void mostrarMa(Jugador jugador) {
        System.out.println("LA TEVA MÁ:");
        mostrarCartes(jugador.getCartes());
    }

    public static void mostrarUltimaCarta(Pilo pilo) {
        System.out.println("ULTIMA CARTA DEL PILÓ");
        mostrarCarta(pilo.consultarCarta());
        System.out.println();
    }

    public static Carta demanarCarta(Jugador jugador, Pilo pilo) {
        mostrarMa(jugador);
        do {
            System.out.print("Escull una carta: ");
            int indexCartaEscollida = input.nextInt();

            if (indexCartaEscollida > 0 && indexCartaEscollida <= jugador.nombreDeCartes()) {
                Carta cartaEscollida = jugador.getCartes().get(indexCartaEscollida-1);

                if (cartaEscollida.esCompatible(pilo.consultarCarta())){
                    return cartaEscollida;
                } else {
                    System.out.println("Aquesta carta no coincideix amb l'última del pilo!");
                }
            } else {
                System.out.println("ERROR: Has escollit una posició no vàlida");
            }
        } while (true);
    }

    public static void victoria(Jugador jugador) {
        System.out.println(jugador.getNom()+" ha guanyat la partida!");
    }
}
