package ui;

import java.util.Scanner;

import model.Computer;
import model.Incident;
import model.SchoolController;



public class SchoolApp {
    private Scanner input;
    private SchoolController controller;
    

    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Agregue los atributos (relaciones) necesarios para conectar esta clase con el
     * modelo.
     */

    public static void main(String[] args) {

        SchoolApp ui = new SchoolApp();
        ui.menu();

    }

    // Constructor
    public SchoolApp() {
        input = new Scanner(System.in);
        controller = new SchoolController();
    }

    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * El siguiente metodo esta incompleto.
     * Agregue la logica necesaria (instrucciones) para satisfacer los
     * requerimientos
     */

    public void menu() {

        System.out.println("Bienvenido a Computaricemos");

        int option = 0;
        do {
            System.out.println("\nMenu Principal");
            System.out.println("--------------------------------------------------------");
            System.out.println("Digite alguna de las siguientes opciones");
            System.out.println("1) Registrar computador");
            System.out.println("2) Registrar incidente en computador");
            System.out.println("3) Consultar el computador con más incidentes");
            System.out.println("0) Salir del sistema");
            option = input.nextInt();

            switch (option) {
                case 1:
                    registrarComputador();
                    break;
                case 2:
                    registrarIncidenteEnComputador();
                    break;
                case 3:
                    consultarComputadorConMasIncidentes();
                    break;
                case 0:
                    System.out.println("\nGracias por usar nuestros servicios. Adios!");
                    break;
                default:
                    System.out.println("\nOpcion invalida. Intente nuevamente.");
                    break;
            }

        } while (option != 0);

    }

    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Los siguientes metodos estan incompletos.
     * Agregue la logica necesaria (instrucciones) para satisfacer los
     * requerimientos
     */

    public void registrarComputador() {
        input.nextLine();
        System.out.println("indique el serial del computador");
        String serialnumber = input.nextLine();
        System.out.println("Indique el piso donde se ubica (0-4):");
        int floor = input.nextInt();
        boolean agregado = controller.agregarComputador(serialnumber, floor);
        if (agregado){
            System.out.println("Computador registrado exitosamente.");
        } else {
            System.out.println("No se pudo registrar el computador.");
        }


    }

    public void registrarIncidenteEnComputador() {
        input.nextLine();
        System.out.println("indique el serial del computador");
        String serial = input.nextLine();
        System.out.println("Describa el incidente:");
        String description = input.nextLine();

        Incident inc = new Incident (java.time.LocalDate.now(), description);
        boolean ok = controller.agregarIncidenteEnComputador(serial, inc);
        if (ok){
            System.out.println("Incidente registrado exitosamente.");
        } else {
            System.out.println("No se pudo registrar el incidente.");
        }

    }

    public void consultarComputadorConMasIncidentes() {
        Computer comp = controller.consultarComputadorConMasIncidentes();

        if (comp==null){
            System.out.println("No hay computadores registrados.");
        } else {
            System.out.println("El computador con mas incidentes es:");
            System.out.println(comp.toString());

        }

    }


}
