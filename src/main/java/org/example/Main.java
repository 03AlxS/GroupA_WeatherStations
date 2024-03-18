package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String filepath = "weather_stations.csv";
        HashMap<String, Double> ciudades = new HashMap<>();

        BufferedReader br = new BufferedReader(new FileReader(filepath));
        String line;
        while ((line = br.readLine()) != null) {
            // Ignorar las líneas que comienzan con "#"
            if (line.startsWith("#")) {
                continue;
            }
            // Dividir la linea leida en un arreglo
            String[] parts = line.split(";");
            String nombre = parts[0];
            double temperatura = Double.parseDouble(parts[1]);
            ciudades.put(nombre, temperatura);
        }
        br.close();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Mostrar todas las ciudades");
            System.out.println("2. Temperatura por ciudad");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    mostrarTodasLasCiudades(ciudades);
                    break;
                case 2:
                    temperaturaPorCiudad(ciudades, scanner);
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private static void mostrarTodasLasCiudades(HashMap<String, Double> ciudades) {
        System.out.println("\nTodas las ciudades:");
        for (String ciudad : ciudades.keySet()) {
            System.out.println(ciudad + ": " + ciudades.get(ciudad) + "°C");
        }
    }

    private static void temperaturaPorCiudad(HashMap<String, Double> ciudades, Scanner scanner) {
        System.out.print("Ingrese el nombre de la ciudad: ");
        String nombreCiudad = scanner.nextLine();

        List<String> ciudadesEncontradas = new ArrayList<>();
        for (String ciudad : ciudades.keySet()) {
            // Pasar los String a minusculas para comparar todas las similitudes
            if (ciudad.toLowerCase().contains(nombreCiudad.toLowerCase())) {
                ciudadesEncontradas.add(ciudad);
            }
        }

        if (ciudadesEncontradas.isEmpty()) {
            System.out.println("No se encontraron ciudades similares.");
        } else {
            System.out.println("\nCiudades similares encontradas:");
            for (String ciudad : ciudadesEncontradas) {
                System.out.println(ciudad + ": " + ciudades.get(ciudad) + "°C");
            }
        }
    }
}