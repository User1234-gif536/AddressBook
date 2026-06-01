import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AddressBook {

    private HashMap<String, String> contactos;

    public AddressBook() {
        contactos = new HashMap<>();
    }

    public void load() {

        try {

            File archivo = new File("contactos.csv");

            if (!archivo.exists()) {
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(archivo));

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");

                if (datos.length == 2) {
                    contactos.put(datos[0], datos[1]);
                }
            }

            br.close();

            System.out.println("Contactos cargados.");

        } catch (Exception e) {

            System.out.println("Error al cargar archivo.");
        }
    }

    public void save() {

        try {

            BufferedWriter bw =
                    new BufferedWriter(
                            new FileWriter("contactos.csv"));

            for (Map.Entry<String, String> contacto : contactos.entrySet()) {

                bw.write(
                        contacto.getKey() + "," +
                                contacto.getValue());

                bw.newLine();
            }

            bw.close();

            System.out.println("Contactos guardados.");

        } catch (Exception e) {

            System.out.println("Error al guardar archivo.");
        }
    }

    public void list() {

        System.out.println("\nContactos:");

        if (contactos.isEmpty()) {

            System.out.println("No hay contactos.");
            return;
        }

        for (Map.Entry<String, String> contacto : contactos.entrySet()) {

            System.out.println(
                    contacto.getKey()
                            + " : "
                            + contacto.getValue());
        }
    }

    public void create(String numero, String nombre) {

        contactos.put(numero, nombre);

        System.out.println("Contacto agregado.");
    }

    public void delete(String numero) {

        if (contactos.containsKey(numero)) {

            contactos.remove(numero);

            System.out.println("Contacto eliminado.");

        } else {

            System.out.println("No existe ese contacto.");
        }
    }
}