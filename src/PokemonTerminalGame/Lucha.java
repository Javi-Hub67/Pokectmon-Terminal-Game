package PokemonTerminalGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Lucha {

    public static void luchar() {

        Scanner scanner = new Scanner(System.in);

        boolean d = true;

        String pokemon1ASCII = "";
        String pokemon2ASCII = "";
        double pokemonFuerza1 = 0.0;
        double pokemonFuerza2 = 0.0;

        while (d) {

            ArrayList<HashMap<String, String>> pokemonLista = new ArrayList<>();

            ArrayList<String> cartasObtenidas = new ArrayList<>();

            pokemonLista = Utilidades.cargarPokemonData("src/PokemonTerminalGame/Datos/pokemon_data.txt");

            for (int i = 1; i < EstadoJugador.estadoJugador.size(); i++) {

                if ((EstadoJugador.estadoJugador.get((pokemonLista.get(i)).get("NOMBRE").toLowerCase())) >= 1) {
                    cartasObtenidas.add((pokemonLista.get(i)).get("NOMBRE"));
                }
            }
            if (cartasObtenidas.size() >= 2) {

                Random random = new Random();

                int numeropkmn1 = random.nextInt(0, cartasObtenidas.size());
                int numeropkmn2 = random.nextInt(0, cartasObtenidas.size());

                boolean c = true;

                while (c) {

                    if (numeropkmn2 == numeropkmn1) {
                        numeropkmn2 = random.nextInt(0, cartasObtenidas.size());
                    } else {
                        c = false;
                    }
                }

                String pokemon1 = cartasObtenidas.get(numeropkmn1);
                String pokemon2 = cartasObtenidas.get(numeropkmn2);

                for (int i = 0; i < pokemonLista.size(); i++) {

                    if ((pokemonLista.get(i)).get("NOMBRE").equals(pokemon1)) {
                        pokemonFuerza1 =
                                Double.parseDouble((pokemonLista.get(i)).get("HP")) +
                                        Double.parseDouble((pokemonLista.get(i)).get("ATAQUE")) +
                                        Double.parseDouble((pokemonLista.get(i)).get("DEFENSA")) +
                                        Double.parseDouble((pokemonLista.get(i)).get("ATAQUE ESP.")) +
                                        Double.parseDouble((pokemonLista.get(i)).get("DEFENSA ESP.")) +
                                        Double.parseDouble((pokemonLista.get(i)).get("VELOCIDAD"));
                        pokemon1ASCII = Utilidades.cargarAsciiArt((pokemonLista.get(i)).get("IMAGEN_ASCII"));
                    }
                }

                for (int i = 0; i < pokemonLista.size(); i++) {

                    if ((pokemonLista.get(i)).get("NOMBRE").equals(pokemon2)) {
                        pokemonFuerza2 =
                                Double.parseDouble((pokemonLista.get(i)).get("HP")) +
                                        Double.parseDouble((pokemonLista.get(i)).get("ATAQUE")) +
                                        Double.parseDouble((pokemonLista.get(i)).get("DEFENSA")) +
                                        Double.parseDouble((pokemonLista.get(i)).get("ATAQUE ESP.")) +
                                        Double.parseDouble((pokemonLista.get(i)).get("DEFENSA ESP.")) +
                                        Double.parseDouble((pokemonLista.get(i)).get("VELOCIDAD"));
                        pokemon2ASCII = Utilidades.cargarAsciiArt((pokemonLista.get(i)).get("IMAGEN_ASCII"));
                    }
                }

                System.out.println("\033[34m¡Bienvenido a la Arena Pokémon!\033[0m");
                System.out.println("\033[33m=\033[0m".repeat(50));
                System.out.println("\033[34mLa Batalla será entre: \033[0m");
                System.out.println();
                System.out.println(" ".repeat(12) + "\033[34mPOKÉMON\033[0m \033[31m1\033[0m");
                System.out.println("\033[38;5;55m_\033[0m".repeat(106 + pokemon1.length()));
                System.out.println();
                System.out.println(" ".repeat(50) + "\033[34mNOMBRE\033[0m: " + pokemon1);
                System.out.println(pokemon1ASCII);


                System.out.println();
                System.out.println(" ".repeat(12) + "\033[34mPOKÉMON\033[0m \033[31m2\033[0m");
                System.out.println("\033[38;5;55m_\033[0m".repeat(106 + pokemon1.length()));
                System.out.println();
                System.out.println(" ".repeat(50) + "\033[34mNOMBRE\033[0m: " + pokemon2);
                System.out.println(pokemon2ASCII);
                System.out.printf("%n%n");
                System.out.println("Apuesta por el ganador (\033[31m1\033[0m/\033[31m2\033[0m):");

                String apuesta = scanner.nextLine().trim().toLowerCase();
                scanner.nextLine();

                boolean t = true;

                while (t) {
                    if (!apuesta.isEmpty()) {
                        if (apuesta.charAt(0) == '1' || apuesta.charAt(0) == '2') {
                            t = false;
                        } else {
                            System.out.println("\033[34mIntroduce una respuesta válida.\033[0m");
                            apuesta = scanner.nextLine().trim();
                            scanner.nextLine();
                        }
                    } else {
                        System.out.println("\033[34mIntroduce una respuesta válida.\033[0m");
                        apuesta = scanner.nextLine().trim();
                        scanner.nextLine();
                    }
                }

                System.out.println("Calculando resultados...");
                System.out.println("\033[38;5;88mLa fuerza de \033[0m" + pokemon1 + "\033[38;5;88m es: \033[0m" + pokemonFuerza1);
                System.out.println("\033[38;5;88mLa fuerza de \033[0m" + pokemon2 + "\033[38;5;88m es: \033[0m" + pokemonFuerza2);


                if (pokemonFuerza1 > pokemonFuerza2) {

                    if (apuesta.charAt(0) == '1') {
                        System.out.println("\033[35mGanaste la apuesta\033[0m");
                    } else {
                        System.out.println("\033[38;5;94mPerdiste la apuesta\033[0m");
                    }

                } else if (pokemonFuerza2 > pokemonFuerza1) {
                    if (apuesta.charAt(0) == '2') {
                        System.out.println("\033[35mGanaste la apuesta\033[0m");
                    } else {
                        System.out.println("\033[38;5;94mPerdiste la apuesta\033[0m");
                    }
                } else {
                    System.out.println("\033[95mEl resultado es empate.\033[0m");
                }

                pokemonFuerza1 = 0.0;
                pokemonFuerza2 = 0.0;

                System.out.println("\033[34m¿Quieres volver a luchar?\033[0m (\033[38;5;27mS\033[0m\033[32m/\033[0m\033[31mN\033[0m)");
                String respuesta = scanner.nextLine().toLowerCase();

                boolean ñ = true;

                while (ñ) {
                    if (respuesta.isEmpty()) {
                        System.out.println("\033[31mIntroduce una respuesta, \033[38;5;88mmanin\033[31m.\033[0m");
                        respuesta = scanner.nextLine().toLowerCase();
                    } else {
                        char yn = respuesta.trim().charAt(0);
                        if (yn == 's') {
                            ñ = false;
                        } else if (yn == 'n') {
                            System.out.println("\033[31mSaliendo...\033[0m");
                            ñ = false;
                            d = false;
                        } else {
                            System.out.println("\033[31mIntroduce una respuesta válida.\033[0m");
                            System.out.println("         (\033[38;5;27mS\033[0m\033[32m/\033[0m\033[31mN\033[0m)");
                            respuesta = scanner.nextLine().toLowerCase();
                        }
                    }
                }

            } else {
                System.out.println("\033[38;5;88mNo tienes suficientes cartas para jugar.\033[0m");
                d = false;
            }
        }
    }
}
