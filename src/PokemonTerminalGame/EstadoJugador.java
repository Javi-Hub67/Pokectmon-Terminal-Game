package PokemonTerminalGame;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class EstadoJugador {

    public static HashMap<String, Integer> estadoJugador = new HashMap<>();

    public static  void inicializarEstado() {

        File jugador_data = new File("src/PokemonTerminalGame/Datos/jugador_data.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(jugador_data))) {

            String texto;

            if ((texto = br.readLine()) != null) {

                texto = texto.replace("{", "").replace("}", "");

                String[] linea = texto.split("\\s*,\\s*");

                for (int i = 0; i < linea.length; i++) {

                        String[] pkmn = linea[i].split("=");
                            estadoJugador.put(pkmn[0], Integer.valueOf(pkmn[1]));
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void guardarEstado() {

        File jugador_guardar = new File("src/PokemonTerminalGame/Datos/jugador_data.txt");

        try (BufferedWriter bw = new BufferedWriter( new FileWriter(jugador_guardar))) {

            String[] keys = estadoJugador.keySet().toArray(new String[0]);
            Integer[] values = estadoJugador.values().toArray(new Integer[0]);

            bw.write("{");

            for (int i = 0; i < estadoJugador.size(); i++) {
                bw.write(keys[i] + "=" + values[i]);
                if (i == (estadoJugador.size()-1)) {
                    bw.write("}");
                } else {
                    bw.write(", ");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static  void nuevaPartida() {

        System.out.println("      ¿Seguro que quieres borrar los datos (S/N)?");

        Scanner scanner = new Scanner(System.in);

        String respuesta = scanner.nextLine().toLowerCase();

        boolean f = true;

        if (respuesta.isEmpty()) {
            f = false;
        } else {
            char yn = respuesta.trim().charAt(0);
            if (yn == 's') {
                System.out.println("      ¿Seguro (S/N)?");
                respuesta = scanner.nextLine().toLowerCase();
                if (respuesta.isEmpty()) {
                    f = false;
                } else {
                    yn = respuesta.trim().charAt(0);
                    if (yn == 's') {
                        f = true;
                    } else {
                        f = false;
                    }
                }
            } else {
                f = false;
            }

            if (f) {

                File jugador_data0 = new File("src/PokemonTerminalGame/Datos/jugador_data0.txt");

                try (BufferedReader br = new BufferedReader(new FileReader(jugador_data0))) {

                    String texto;

                    if ((texto = br.readLine()) != null) {

                        texto = texto.replace("{", "").replace("}", "");

                        String[] linea = texto.split("\\s*,\\s*");

                        for (int i = 0; i < linea.length; i++) {

                            String[] pkmn = linea[i].split("=");
                            estadoJugador.put(pkmn[0], Integer.valueOf(pkmn[1]));
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("\033[31m.......Borrando datos.......\033[0m");
            } else {
                System.out.println("\033[32m.......Cancelando el borrado de datos.......\033[0m");
            }
        }
    }
}
