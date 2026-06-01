import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AddressBook agenda = new AddressBook();

        agenda.load();

        int opcion;

        do {

            System.out.println("\n------ AGENDA ------");
            System.out.println("1. List");
            System.out.println("2. Create");
            System.out.println("3. Delete");
            System.out.println("4. Save");
            System.out.println("5. Salir");

            System.out.print("Opcion: ");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {

                case 1:

                    agenda.list();

                    break;

                case 2:

                    System.out.print("Numero: ");
                    String numero = sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    agenda.create(numero, nombre);

                    break;

                case 3:

                    System.out.print("Numero a eliminar: ");

                    String borrar = sc.nextLine();

                    agenda.delete(borrar);

                    break;

                case 4:

                    agenda.save();

                    break;

                case 5:

                    agenda.save();

                    System.out.println("Programa finalizado.");

                    break;

                default:

                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 5);

        sc.close();
    }
}