package PokemonTerminalGame;

import java.util.HashMap;
import java.util.Scanner;

public class main {

    public static void iniciarJuego() {

        Scanner scanner = new Scanner(System.in);

        boolean b = true;
        System.out.println();
        System.out.println();

        System.out.println("Bienvenido a Pokémon Terminal Game: ");

        while (b) {

            System.out.println();
            System.out.printf("%n%s%n%s%s%s%n%s%n", "\033[32m=\033[0m".repeat(38), " ".repeat(8), "\033[34mPOKEMON TERMINAL GAME\033[0m", " ".repeat(8), "\033[32m=\033[0m".repeat(38));
            System.out.println("\033[31m1.\033[0m \033[34mConseguir Sobre\033[0m");
            System.out.println("\033[31m2.\033[0m \033[34mAbrir Sobre\033[0m");
            System.out.println("\033[31m3.\033[0m \033[34mListar Cartas\033[0m");
            System.out.println("\033[31m4.\033[0m \033[34mLuchar\033[0m");
            System.out.println("\033[31m5.\033[0m \033[34mNueva Partida\033[0m");
            System.out.println("\033[31m6.\033[0m \033[34mSalir\033[0m");
            System.out.println("\033[32m-\033[0m".repeat(38));
            System.out.print("\033[34mElige una opción\033[0m (\033[31m1\033[1" + "0m - \033[31m6\033[0m): ");
            System.out.println();


            String linea = scanner.nextLine();
            if (linea.isEmpty()) {
                System.out.println("");
                System.out.println("\033[31mSelecciona una opción.\033[0m");
            } else if (linea.charAt(0) != '1' && linea.charAt(0) != '2' && linea.charAt(0) != '3' && linea.charAt(0) != '4' && linea.charAt(0) != '5' && linea.charAt(0) != '6') {
                System.out.println("");
                System.out.println("\033[31mSelecciona una opción.\033[0m");
            } else {

                char accion = linea.trim().charAt(0);

                if (accion == '1' || accion == '2' || accion == '3' || accion == '4' || accion == '5' || accion == '6') {

                    switch (accion) {

                        case '1':
                            GestionSobres.contarEnterParaSobre();
                            break;
                        case '2':
                            GestionSobres.abrirSobre();
                            break;
                        case '3':
                            GestionCartas.listarCartas();
                            break;
                        case '4':
                            Lucha.luchar();
                            break;
                        case '5':
                            EstadoJugador.nuevaPartida();
                            break;
                        case '6':
                            b = false;
                            break;
                    }
                } else {
                    System.out.println("");
                    System.out.println("4Opción no válida.\033[0m");
                }
        }
        }
    }

    static void main(String[] args) {

        EstadoJugador.inicializarEstado();
        iniciarJuego();
        EstadoJugador.guardarEstado();

    }
}
