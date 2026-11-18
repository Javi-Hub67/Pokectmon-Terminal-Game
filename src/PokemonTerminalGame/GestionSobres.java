package PokemonTerminalGame;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class GestionSobres {

    public static void contarEnterParaSobre() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Pulsa enter 100 veces para conseguir un sobre (q para cancelar):");

        boolean b = false;
        boolean a = true;
        int i = 1;

        while (a) {
            String enter = scanner.nextLine();
            if ((enter.isEmpty()) && (i == 100)) {
                b = true;
                a = false;
            } else if (enter.trim().equals("123")) {
                System.out.println("Codigo secreto activado, +1 Sobre");
                b = true;
                a = false;
            } else if ((enter.isEmpty())) {
                System.out.println("\033[34mProgreso:\033[0m " + "\033[31m " + i + "\033[0m" + "\033[32m/\033[0m" + "\033[31m100\033[0m");
                i++;

            } else if (enter.toLowerCase().charAt(0) == 'q') {
                System.out.println("Cancelaste el conseguir sobre.");
                break;

            } else {
                System.out.println("Cancelaste el conseguir sobre.");
                break;
            }
        }
        if (b) {
            System.out.println("\033[34mProgreso:\033[0m " + "\033[31m" + i + "\033[0m" + "\033[32m/\033[0m" + "\033[31m100\033[0m");
            System.out.println();
            System.out.println("\033[32mConseguiste\033[0m \033[34m1\033[0m \033[32msobre.\033[0m");
            EstadoJugador.estadoJugador.put("sobres", EstadoJugador.estadoJugador.get("sobres") + 1);
        }
    }

    public static void abrirSobre() {

        Scanner scanner = new Scanner(System.in);

        if (EstadoJugador.estadoJugador.get("sobres") == 0) {
            System.out.println();
            System.out.println("No hay sobres disponibles.");
        } else {
            EstadoJugador.estadoJugador.put("sobres", EstadoJugador.estadoJugador.get("sobres") - 1);
            for (int i = 0; i < 5; i++) {

                HashMap<String, String> aleatoriaCarta = seleccionarCartaAleatoria();

                EstadoJugador.estadoJugador.put(aleatoriaCarta.get("NOMBRE").toLowerCase(), (EstadoJugador.estadoJugador.get(aleatoriaCarta.get("NOMBRE").toLowerCase()) + 1));
                System.out.println(Utilidades.cargarAsciiArt(aleatoriaCarta.get("IMAGEN_ASCII")));
                System.out.println("\033[32m=\033[0m".repeat(133));
                System.out.println(" ".repeat(50) + aleatoriaCarta.get("NOMBRE") + "  " + aleatoriaCarta.get("RAREZA"));
                System.out.println("\033[32m=\033[0m".repeat(133));
                System.out.println("");
                System.out.println("\033[32m(Presiona ´´Enter`` para seguir.)\033[0m");
                scanner.nextLine();
            }
        }

    }

    public static HashMap<String, String> seleccionarCartaAleatoria() {

        Random random = new Random();

        double numeroRandom = random.nextDouble();

        HashMap<String, String> pokemonAleatorio = new HashMap<>();

        double probabilidadAcumulada = 0.00;

        for (int i = 0; i < Utilidades.cargarPokemonData("src/PokemonTerminalGame/Datos/pokemon_data.txt").size(); i++) {

            double rareza = Double.parseDouble(Utilidades.cargarPokemonData("src/PokemonTerminalGame/Datos/pokemon_data.txt").get(i).get("PROBABILIDAD"));

            probabilidadAcumulada = probabilidadAcumulada + rareza;

            if (probabilidadAcumulada >= numeroRandom) {
                pokemonAleatorio = Utilidades.cargarPokemonData("src/PokemonTerminalGame/Datos/pokemon_data.txt").get(i);
                break;
            }
        }
        if (pokemonAleatorio.isEmpty()) {

            Random random2 = new Random();

            int salida = random2.nextInt(0, 5);

            switch (salida) {
                case 0:
                    pokemonAleatorio = Utilidades.cargarPokemonData("src/PokemonTerminalGame/Datos/pokemon_data.txt").get(151);
                    break;
                case 1:
                    pokemonAleatorio = Utilidades.cargarPokemonData("src/PokemonTerminalGame/Datos/pokemon_data.txt").get(150);
                    break;
                case 2:
                    pokemonAleatorio = Utilidades.cargarPokemonData("src/PokemonTerminalGame/Datos/pokemon_data.txt").get(146);
                    break;
                case 3:
                    pokemonAleatorio = Utilidades.cargarPokemonData("src/PokemonTerminalGame/Datos/pokemon_data.txt").get(145);
                    break;
                case 4:
                    pokemonAleatorio = Utilidades.cargarPokemonData("src/PokemonTerminalGame/Datos/pokemon_data.txt").get(144);
                    break;
            }
        }
        return pokemonAleatorio;
    }
}