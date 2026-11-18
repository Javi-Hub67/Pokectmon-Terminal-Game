package PokemonTerminalGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GestionCartas {

    public static void listarCartas() {

        final String missingno = Utilidades.cargarAsciiArt("src/PokemonTerminalGame/Datos/ascii_art/000_Missingno.txt");

        boolean b = true;
        while (b) {

            Scanner scanner = new Scanner(System.in);

            System.out.println();
            System.out.println("\033[34mElige una opción\033[0m " + "(\033[31m1 - 3\033[0m): ");
            System.out.println("\033[31m1.\033[0m \033[34mGalería de sprites\033[0m");
            System.out.println("\033[31m2.\033[0m \033[34mCaracterísticas Pokémon\033[0m");
            System.out.println("\033[31m3.\033[0m \033[34mSalir\033[0m");

            ArrayList<HashMap<String, String>> pokemonLista = new ArrayList<>();

            pokemonLista = Utilidades.cargarPokemonData("src/PokemonTerminalGame/Datos/pokemon_data.txt");


            String opcion = scanner.nextLine();

            if (opcion.isEmpty()) {
                System.out.println("");
                System.out.println("\033[31mSelecciona una opción.\033[0m");
            } else {
                char seleccion = opcion.trim().charAt(0);
                if (seleccion == '1' || seleccion == '2' || seleccion == '3') {

                    switch (seleccion) {

                        case ('1'):

                            for (int i = 1; i < EstadoJugador.estadoJugador.size(); i++) {

                                if ((EstadoJugador.estadoJugador.get((pokemonLista.get(i)).get("NOMBRE").toLowerCase())) >= 1) {
                                    System.out.println(Utilidades.cargarAsciiArt((pokemonLista.get(i)).get("IMAGEN_ASCII")));
                                    System.out.println("\033[33m=\033[0m".repeat(50) + " " + (pokemonLista.get(i)).get("NOMBRE") + " " + (pokemonLista.get(i)).get("RAREZA") + " Nº " + (i) + " " + "\033[33m=\033[0m".repeat(50));
                                } else {
                                    System.out.println(missingno);
                                    System.out.println("\033[33m=\033[0m".repeat(50) + " ¿¿¿¿" + " " + "¿¿¿¿ " + "Nº " + (i) + " " + "\033[33m=\033[0m".repeat(50));
                                }
                                scanner.nextLine();
                                /**    ((pokemonLista.get(i)).get("NOMBRE").toLowerCase() // Los nombres de cada pkmn en orden */
                                /**    ((pokemonLista.get(i)).get("ID") // Los numeros de cada pkmn en orden */
                                /**    ((pokemonLista.get(i)).get("IMAGEN_ASCII")) Las rutas ASSCi de cada pkmn en orden */
                            }
                            break;
                        case ('2'):
                            System.out.printf("%s%n%s%n%s%n", "\033[32m=\033[0m".repeat(183), " ".repeat(12) + "\033[34mPOKÉMON COLECCIONADOS\033[0m", "\033[32m=\033[0m".repeat(183));
                            System.out.printf("%s%n",
                                    "\033[34mCant. Cartas\033[0m      " + "\033[32m|\033[0m " +
                                    "\033[34mID\033[0m      " + "\033[32m|\033[0m " +
                                    "\033[34mNombre\033[0m       " + "\033[32m|\033[0m " +
                                    "\033[34mTipo\033[0m             " + "\033[32m|\033[0m " +
                                    "\033[34mHábitat\033[0m           " + "\033[32m|\033[0m " +
                                    "\033[34mPeso\033[0m    " + "\033[32m|\033[0m " +
                                    "\033[34mAltura\033[0m  " + "\033[32m|\033[0m " +
                                    "\033[34mHP\033[0m   " + "\033[32m|\033[0m " +
                                    "\033[34mAtaque\033[0m  " + "\033[32m|\033[0m " +
                                    "\033[34mDefensa\033[0m  " + "\033[32m|\033[0m " +
                                    "\033[34mAtaque ESP.\033[0m  " + "\033[32m|\033[0m " +
                                    "\033[34mDefensa ESP.\033[0m  " + "\033[32m|\033[0m " +
                                    "\033[34mVelocidad\033[0m   " + "\033[32m|\033[0m " +
                                    "\033[34mRareza\033[0m  ");
                            System.out.println("\033[32m-\033[0m".repeat(183));

                            for (int i = 1; i < EstadoJugador.estadoJugador.size(); i++) {

                                if ((EstadoJugador.estadoJugador.get((pokemonLista.get(i)).get("NOMBRE").toLowerCase())) >= 1) {
                                    System.out.printf("%s%n",
                                            EstadoJugador.estadoJugador.get((pokemonLista.get(i)).get("NOMBRE").toLowerCase()).toString() + " ".repeat(18 - (EstadoJugador.estadoJugador.get((pokemonLista.get(i)).get("NOMBRE").toLowerCase())).toString().length()) + "\033[32m|\033[0m " +
                                            (pokemonLista.get(i)).get("ID") + " ".repeat(8 - ((pokemonLista.get(i)).get("ID")).length()) + "\033[32m|\033[0m " +
                                            (pokemonLista.get(i)).get("NOMBRE") + " ".repeat(13 - ((pokemonLista.get(i)).get("NOMBRE")).length()) + "\033[32m|\033[0m " +
                                            (pokemonLista.get(i)).get("TIPO/S") + " ".repeat(17 - ((pokemonLista.get(i)).get("TIPO/S")).length()) + "\033[32m|\033[0m " +
                                            (pokemonLista.get(i)).get("HABITAT") + " ".repeat(18 - ((pokemonLista.get(i)).get("HABITAT")).length()) + "\033[32m|\033[0m " +
                                            (pokemonLista.get(i)).get("PESO") + "\033[38;5;27mkg\033[0m" + " ".repeat(6 - ((pokemonLista.get(i)).get("PESO")).length()) + "\033[32m|\033[0m " +
                                            (pokemonLista.get(i)).get("ALTURA") + "\033[38;5;27mm\033[0m" + " ".repeat(7 - ((pokemonLista.get(i)).get("ALTURA")).length()) + "\033[32m|\033[0m " +
                                            (pokemonLista.get(i)).get("HP") + " ".repeat(5 - ((pokemonLista.get(i)).get("HP")).length()) + "\033[32m|\033[0m " +
                                            (pokemonLista.get(i)).get("ATAQUE") + " ".repeat(8 - ((pokemonLista.get(i)).get("ATAQUE")).length()) + "\033[32m|\033[0m " +
                                            (pokemonLista.get(i)).get("DEFENSA") + " ".repeat(9 - ((pokemonLista.get(i)).get("DEFENSA")).length()) + "\033[32m|\033[0m " +
                                            (pokemonLista.get(i)).get("ATAQUE ESP.") + " ".repeat(13 - ((pokemonLista.get(i)).get("ATAQUE ESP.")).length()) + "\033[32m|\033[0m " +
                                            (pokemonLista.get(i)).get("DEFENSA ESP.") + " ".repeat(14 - ((pokemonLista.get(i)).get("DEFENSA ESP.")).length()) + "\033[32m|\033[0m " +
                                            (pokemonLista.get(i)).get("VELOCIDAD") + " ".repeat(12 - ((pokemonLista.get(i)).get("VELOCIDAD")).length()) + "\033[32m|\033[0m " +
                                            (pokemonLista.get(i)).get("RAREZA") + " ".repeat(8 - ((pokemonLista.get(i)).get("VELOCIDAD")).length())
                                    );
                                    System.out.println("\033[32m-\033[0m".repeat(183));
                                } else {
                                    System.out.printf("%s%n",
                                            "0" + " ".repeat(17) + "\033[32m|\033[0m " +
                                            (pokemonLista.get(i)).get("ID") + " ".repeat(8 - ((pokemonLista.get(i)).get("ID")).length()) + "\033[32m|\033[0m " +
                                            (pokemonLista.get(0)).get("NOMBRE") + " ".repeat(13 - ((pokemonLista.get(0)).get("NOMBRE")).length()) + "\033[32m|\033[0m " +
                                            (pokemonLista.get(0)).get("TIPO/S") + " ".repeat(17 - ((pokemonLista.get(0)).get("TIPO/S")).length()) + "\033[32m|\033[0m " +
                                            (pokemonLista.get(0)).get("HABITAT") + " ".repeat(18 - ((pokemonLista.get(0)).get("HABITAT")).length()) + "\033[32m|\033[0m " +
                                            (pokemonLista.get(0)).get("PESO") + "\033[38;5;27mkg\033[0m" + " ".repeat(6 - ((pokemonLista.get(0)).get("PESO")).length()) + "\033[32m|\033[0m " +
                                            (pokemonLista.get(0)).get("ALTURA") + "\033[38;5;27mm\033[0m" + " ".repeat(7 - ((pokemonLista.get(0)).get("ALTURA")).length()) + "\033[32m|\033[0m " +
                                            (pokemonLista.get(0)).get("HP") + " ".repeat(5 - ((pokemonLista.get(0)).get("HP")).length()) + "\033[32m|\033[0m " +
                                            (pokemonLista.get(0)).get("ATAQUE") + " ".repeat(8 - ((pokemonLista.get(0)).get("ATAQUE")).length()) + "\033[32m|\033[0m " +
                                            (pokemonLista.get(0)).get("DEFENSA") + " ".repeat(9 - ((pokemonLista.get(0)).get("DEFENSA")).length()) + "\033[32m|\033[0m " +
                                            (pokemonLista.get(0)).get("ATAQUE ESP.") + " ".repeat(13 - ((pokemonLista.get(0)).get("ATAQUE ESP.")).length()) + "\033[32m|\033[0m " +
                                            (pokemonLista.get(0)).get("DEFENSA ESP.") + " ".repeat(14 - ((pokemonLista.get(0)).get("DEFENSA ESP.")).length()) + "\033[32m|\033[0m " +
                                            (pokemonLista.get(0)).get("VELOCIDAD") + " ".repeat(12 - ((pokemonLista.get(0)).get("VELOCIDAD")).length()) + "\033[32m|\033[0m " +
                                            (pokemonLista.get(0)).get("RAREZA") + " ".repeat(8 - ((pokemonLista.get(0)).get("VELOCIDAD")).length())
                                    );
                                    System.out.println("\033[32m-\033[0m".repeat(183));
                                }
                            }
                            System.out.println();
                            scanner.nextLine();
                            break;
                        case ('3'):
                            System.out.println("\033[33mSaliendo de la lista de cartas.\033[0m");
                            b = false;
                            break;
                    }
                } else {
                    System.out.println("\033[31mSelecciona una opción.\033[0m");
                }
            }
        }
    }
}
