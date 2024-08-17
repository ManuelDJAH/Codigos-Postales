package mx.unison;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EncontrarCodigo {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Recuerda poner los codigos postales en program arguments.");
            return;
        }

        String archivoRuta = "codigos_postales.csv";
        Map<String, String> codigoAsentamientos = new HashMap<>();

        try (BufferedReader archivo2 = new BufferedReader(new FileReader(archivoRuta))) {
            String registro;
            archivoL.readLine();

            while ((registro = archivo2.readLine()) != null) {
                String[] campos = registro.split(",");

                if (campos.length >= 3) {
                    String codigoPostal = campos[0];
                    String nombreAsentamiento = campos[1] + " (" + campos[2] + ")";
                    codigoAsentamientos.put(codigoPostal, nombreAsentamiento);
                }
            }

            for (String codigo : args) {
                String asentamiento = codigoAsentamientos.get(codigo);
                if (asentamiento != null) {
                    System.out.println("Codigo Postal: " + codigo + " - Asentamiento: " + asentamiento);
                } else {
                    System.out.println("Codigo Postal: " + codigo + " - No encontrado");
                }
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
