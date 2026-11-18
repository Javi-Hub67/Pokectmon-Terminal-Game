package PokemonTerminalGame;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;


public class Utilidades {


    public static ArrayList<HashMap<String, String>> cargarPokemonData(String ruta) {

        ArrayList<HashMap<String, String>> listaPokemon = new ArrayList<>();

        File pokemon_data = new File(ruta);


        try (BufferedReader br = new BufferedReader(new FileReader(pokemon_data))) {

            String linea;

            String[] filaUno = br.readLine().split("\\s*,\\s*");

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split("\\s*,\\s*");

                HashMap<String, String> mapaPokemon = new HashMap<>();

                for (int i = 0; i < filaUno.length; i++) {
                    mapaPokemon.put(filaUno[i], datos[i]);
                }
                listaPokemon.add(mapaPokemon);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listaPokemon;
    }


    public static String cargarAsciiArt(String ruta) {

        File artePokemon = new File(ruta);

        String arteAscii = "";

        try (BufferedReader br = new BufferedReader(new FileReader(artePokemon))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                arteAscii = arteAscii + linea + "\n";

            }
            arteAscii = arteAscii.replace("\\033", "\033");
            arteAscii = arteAscii + "\033[0m";
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return arteAscii;

        }
}
