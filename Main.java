import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static final String coma = ",";

    public static void main(String[] args) {

        BufferedReader bufferLectura = null;
        try {
            bufferLectura = new BufferedReader(new FileReader("src/codigos_postales_hmo.csv"));
            String bl = bufferLectura.readLine();

            HashMap<String, Integer> contador = new HashMap<>();

            while (bl != null) {

                String[] campos = bl.split(coma);

                for (String s : campos) {

                    String codigos = s.substring(0, Math.min(6, s.length()));
                    contador.put(codigos, contador.getOrDefault(codigos, 0) + 1);
                }
                bl = bufferLectura.readLine();
            }
            for (String s : contador.keySet()) {

                int numAsentamientos = contador.get(s);
                if (numAsentamientos > 1) {
                    System.out.println("Código Postal: " + s + " Numero de asentamientos por código postal: " + numAsentamientos);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}




