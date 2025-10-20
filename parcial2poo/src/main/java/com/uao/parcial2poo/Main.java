
package com.uao.parcial2poo;
import java.util.Scanner;

import com.uao.parcial2poo.Modelo.Estudiante;
import com.uao.parcial2poo.Modelo.Persona;
import com.uao.parcial2poo.Modelo.Profesor;
import com.uao.parcial2poo.Modelo.ProfesorMedioTiempo;
import com.uao.parcial2poo.Modelo.ProfesorTiempoCompleto;
import com.uao.parcial2poo.Sistema.SistemaGestion;

public class Main {

    private static final SistemaGestion sistema = new SistemaGestion();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarBienvenida();

        boolean continuar = true;
        while (continuar) {
            mostrarMenuPrincipal();
            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    menuAgregar();
                    break;
                case 2:
                    menuMostrar();
                    break;
                case 3:
                    cargarDatosPrueba();
                    break;
                case 4:
                    demostrarPolimorfismo();
                    break;
                case 0:
                    continuar = false;
                    mostrarDespedida();
                    break;
                default:
                    System.out.println("\n[ERROR] Opcion invalida. Por favor, intente de nuevo.\n");
            }

            if (continuar) {
                pausar();
            }
        }

        scanner.close();
    }

    // ========================================
    // MÉTODOS DE INTERFAZ Y MENÚS
    // ========================================

    private static void mostrarBienvenida() {
        limpiarPantalla();
        System.out.println("===========================================");
        System.out.println("                                           ");
        System.out.println("   SISTEMA DE GESTION DE COLEGIO UAO      ");
        System.out.println("                                           ");
        System.out.println("   Sistema de Administracion Academica    ");
        System.out.println("                                           ");
        System.out.println("===========================================");
        System.out.println();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n===========================================");
        System.out.println("            MENU PRINCIPAL                 ");
        System.out.println("===========================================");
        System.out.println("  1. Agregar Personas                      ");
        System.out.println("  2. Mostrar Informacion                   ");
        System.out.println("  3. Cargar Datos de Prueba                ");
        System.out.println("  4. Demostrar Polimorfismo                ");
        System.out.println("  0. Salir                                 ");
        System.out.println("===========================================");
        System.out.print("\nSeleccione una opcion: ");
    }

    private static void menuAgregar() {
        limpiarPantalla();
        System.out.println("\n===========================================");
        System.out.println("           MENU DE AGREGAR                 ");
        System.out.println("===========================================");
        System.out.println("  1. Agregar Estudiante                    ");
        System.out.println("  2. Agregar Profesor Normal               ");
        System.out.println("  3. Agregar Profesor Tiempo Completo      ");
        System.out.println("  4. Agregar Profesor Medio Tiempo         ");
        System.out.println("  0. Volver al Menu Principal              ");
        System.out.println("===========================================");
        System.out.print("\nSeleccione una opcion: ");

        int opcion = leerOpcion();

        switch (opcion) {
            case 1:
                agregarEstudiante();
                break;
            case 2:
                agregarProfesorNormal();
                break;
            case 3:
                agregarProfesorTiempoCompleto();
                break;
            case 4:
                agregarProfesorMedioTiempo();
                break;
            case 0:
                // Volver al menú principal
                break;
            default:
                System.out.println("\nOpcion invalida.");
        }
    }

    private static void menuMostrar() {
        limpiarPantalla();
        System.out.println("\n===========================================");
        System.out.println("           MENU DE REPORTES                ");
        System.out.println("===========================================");
        System.out.println("  1. Mostrar Estudiantes                   ");
        System.out.println("  2. Mostrar Profesores                    ");
        System.out.println("  3. Profesores por Salario                ");
        System.out.println("  4. Reporte General                       ");
        System.out.println("  0. Volver al Menu Principal              ");
        System.out.println("===========================================");
        System.out.print("\nSeleccione una opcion: ");

        int opcion = leerOpcion();
        System.out.println();

        switch (opcion) {
            case 1:
                sistema.reporteEstudiantes();
                break;
            case 2:
                mostrarProfesores();
                break;
            case 3:
                sistema.reporteProfesoresPorSalario();
                break;
            case 4:
                sistema.reporteGeneral();
                break;
            case 0:
                // Volver al menú principal
                break;
            default:
                System.out.println("\nOpcion invalida.");
        }
    }

    // ========================================
    // MÉTODOS PARA AGREGAR PERSONAS
    // ========================================

    private static void agregarEstudiante() {
        System.out.println("\n===========================================");
        System.out.println("         AGREGAR NUEVO ESTUDIANTE          ");
        System.out.println("===========================================\n");

        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();

        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Fecha de nacimiento (dd/mm/aaaa): ");
        String fechaNacimiento = scanner.nextLine();

        System.out.print("Código de estudiante: ");
        String codigo = scanner.nextLine();

        System.out.print("Grado: ");
        String grado = scanner.nextLine();

        System.out.print("Promedio (0.0 - 5.0): ");
        double promedio = leerDouble();

        Estudiante estudiante = new Estudiante(
                nombre, direccion, telefono, fechaNacimiento,
                codigo, grado, promedio);

        sistema.agregarEstudiante(estudiante);
        System.out.println("\n[OK] Estudiante agregado exitosamente!");
    }

    private static void agregarProfesorNormal() {
        System.out.println("\n===========================================");
        System.out.println("         AGREGAR PROFESOR NORMAL           ");
        System.out.println("===========================================\n");

        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();

        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Fecha de nacimiento (dd/mm/aaaa): ");
        String fechaNacimiento = scanner.nextLine();

        System.out.print("Cédula: ");
        String cedula = scanner.nextLine();

        System.out.print("Materia que dicta: ");
        String materia = scanner.nextLine();

        System.out.print("Salario por hora: $");
        double salarioPorHora = leerDouble();

        System.out.print("Horas dictadas al mes: ");
        int horasDictadas = leerInt();

        Profesor profesor = new Profesor(
                nombre, direccion, telefono, fechaNacimiento,
                cedula, materia, salarioPorHora, horasDictadas);

        sistema.agregarProfesor(profesor);
        System.out.println("\n[OK] Profesor agregado exitosamente!");
    }

    private static void agregarProfesorTiempoCompleto() {
        System.out.println("\n===========================================");
        System.out.println("     AGREGAR PROFESOR TIEMPO COMPLETO      ");
        System.out.println("===========================================\n");

        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();

        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Fecha de nacimiento (dd/mm/aaaa): ");
        String fechaNacimiento = scanner.nextLine();

        System.out.print("Cédula: ");
        String cedula = scanner.nextLine();

        System.out.print("Materia que dicta: ");
        String materia = scanner.nextLine();

        System.out.print("Salario por hora: $");
        double salarioPorHora = leerDouble();

        System.out.print("Horas dictadas al mes: ");
        int horasDictadas = leerInt();

        System.out.print("Bonificación tiempo completo: $");
        double bonificacion = leerDouble();

        ProfesorTiempoCompleto profesor = new ProfesorTiempoCompleto(
                nombre, direccion, telefono, fechaNacimiento,
                cedula, materia, salarioPorHora, horasDictadas, bonificacion);

        sistema.agregarProfesor(profesor);
        System.out.println("\n[OK] Profesor de Tiempo Completo agregado exitosamente!");
    }

    private static void agregarProfesorMedioTiempo() {
        System.out.println("\n===========================================");
        System.out.println("      AGREGAR PROFESOR MEDIO TIEMPO        ");
        System.out.println("===========================================\n");

        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();

        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Fecha de nacimiento (dd/mm/aaaa): ");
        String fechaNacimiento = scanner.nextLine();

        System.out.print("Cédula: ");
        String cedula = scanner.nextLine();

        System.out.print("Materia que dicta: ");
        String materia = scanner.nextLine();

        System.out.print("Salario por hora: $");
        double salarioPorHora = leerDouble();

        System.out.print("Horas dictadas al mes: ");
        int horasDictadas = leerInt();

        System.out.print("Máximo de horas permitidas: ");
        int maximoHoras = leerInt();

        ProfesorMedioTiempo profesor = new ProfesorMedioTiempo(
                nombre, direccion, telefono, fechaNacimiento,
                cedula, materia, salarioPorHora, horasDictadas, maximoHoras);

        sistema.agregarProfesor(profesor);
        System.out.println("\n[OK] Profesor de Medio Tiempo agregado exitosamente!");
    }

    // ========================================
    // MÉTODOS PARA MOSTRAR INFORMACIÓN
    // ========================================

    private static void mostrarProfesores() {
        System.out.println("===========================================");
        System.out.println("           LISTA DE PROFESORES             ");
        System.out.println("===========================================\n");

        if (sistema.getProfesores().isEmpty()) {
            System.out.println("[AVISO] No hay profesores registrados en el sistema.");
            return;
        }

        for (Profesor profesor : sistema.getProfesores()) {
            System.out.println(profesor.mostrarInformacion());
            System.out.println("-------------------------------------------");
        }
    }

    // ========================================
    // MÉTODO PARA CARGAR DATOS DE PRUEBA
    // ========================================

    private static void cargarDatosPrueba() {
        limpiarPantalla();
        System.out.println("\n===========================================");
        System.out.println("         CARGANDO DATOS DE PRUEBA          ");
        System.out.println("===========================================\n");

        // AGREGAR PROFESORES
        System.out.println(">> Agregando profesores...");

        Profesor prof1 = new Profesor(
                "María García López",
                "Calle 123 #45-67",
                "3001234567",
                "15/03/1985",
                "52123456",
                "Matemáticas",
                25000,
                160);
        sistema.agregarProfesor(prof1);

        Profesor prof2 = new Profesor(
                "Carlos Rodríguez Pérez",
                "Carrera 45 #23-12",
                "3109876543",
                "22/07/1980",
                "79876543",
                "Física",
                28000);
        prof2.setHorasDictadas(120);
        sistema.agregarProfesor(prof2);

        ProfesorTiempoCompleto prof3 = new ProfesorTiempoCompleto(
                "Ana Martínez Sánchez",
                "Avenida 68 #34-56",
                "3156789012",
                "10/11/1988",
                "1023456789",
                "Química",
                30000,
                180,
                500000);
        sistema.agregarProfesor(prof3);

        ProfesorMedioTiempo prof4 = new ProfesorMedioTiempo(
                "Luis Fernando Gómez",
                "Calle 80 #12-34",
                "3201234567",
                "05/05/1990",
                "1098765432",
                "Inglés",
                22000,
                80,
                100);
        sistema.agregarProfesor(prof4);

        System.out.println("[OK] 4 profesores agregados");

        // AGREGAR ESTUDIANTES
        System.out.println("\n>> Agregando estudiantes...");

        Estudiante est1 = new Estudiante(
                "Juan Camilo Herrera",
                "Calle 50 #20-30",
                "3187654321",
                "12/08/2008",
                "EST001",
                "10 GRADO",
                4.5);
        sistema.agregarEstudiante(est1);

        Estudiante est2 = new Estudiante(
                "Laura Valentina Moreno",
                "Carrera 30 #40-50",
                "3123456789",
                "25/03/2007",
                "EST002",
                "11 GRADO",
                4.8);
        sistema.agregarEstudiante(est2);

        Estudiante est3 = new Estudiante(
                "Andrés Felipe Torres",
                "Avenida 15 #25-35",
                "3209876543",
                "18/11/2009",
                "EST003",
                "9 GRADO",
                3.8);
        sistema.agregarEstudiante(est3);

        Estudiante est4 = new Estudiante(
                "Sofia Isabella Castro",
                "Calle 100 #50-60",
                "3156781234",
                "30/06/2008",
                "EST004",
                "10 GRADO",
                4.2);
        sistema.agregarEstudiante(est4);

        Estudiante est5 = new Estudiante(
                "Santiago Alejandro Ruiz",
                "Carrera 70 #80-90",
                "3134567890",
                "14/09/2007",
                "EST005",
                "11 GRADO",
                4.6);
        sistema.agregarEstudiante(est5);

        System.out.println("[OK] 5 estudiantes agregados");

        System.out.println("\n[EXITO] Datos de prueba cargados exitosamente!");
        System.out.println("   Total: 4 profesores y 5 estudiantes");
    }

    // ========================================
    // MÉTODO PARA DEMOSTRAR POLIMORFISMO
    // ========================================

    private static void demostrarPolimorfismo() {
        limpiarPantalla();
        System.out.println("\n===========================================");
        System.out.println("      DEMOSTRACION DE POLIMORFISMO         ");
        System.out.println("===========================================\n");

        if (sistema.getProfesores().isEmpty() || sistema.getEstudiantes().isEmpty()) {
            System.out.println("[AVISO] Para demostrar polimorfismo necesita al menos:");
            System.out.println("   - 1 profesor registrado");
            System.out.println("   - 1 estudiante registrado");
            System.out.println("\n[SUGERENCIA] Use la opcion 3 para cargar datos de prueba.");
            return;
        }

        System.out.println("El polimorfismo permite que una variable de tipo");
        System.out.println("Persona pueda guardar tanto Profesores como Estudiantes,");
        System.out.println("y que cada uno ejecute su propia versión del método.\n");

        Profesor primerProfesor = sistema.getProfesores().get(0);
        Estudiante primerEstudiante = sistema.getEstudiantes().get(0);

        // Polimorfismo: una variable Persona puede guardar un Profesor o Estudiante
        Persona persona1 = primerProfesor;
        Persona persona2 = primerEstudiante;

        System.out.println("-------------------------------------------");
        System.out.println("Variable tipo Persona apuntando a un Profesor:");
        System.out.println("-------------------------------------------");
        System.out.println(persona1.mostrarInformacion());

        System.out.println("\n-------------------------------------------");
        System.out.println("Variable tipo Persona apuntando a un Estudiante:");
        System.out.println("-------------------------------------------");
        System.out.println(persona2.mostrarInformacion());

        System.out.println("\n[NOTA] Ambas variables son de tipo Persona, pero cada una");
        System.out.println("   ejecuta el metodo mostrarInformacion() de su clase real.");
    }

    // ========================================
    // MÉTODOS DE UTILIDAD
    // ========================================

    private static int leerOpcion() {
        try {
            String input = scanner.nextLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static int leerInt() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("[ERROR] Valor invalido. Ingrese un numero entero: ");
            }
        }
    }

    private static double leerDouble() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.print("[ERROR] Valor invalido. Ingrese un numero decimal: ");
            }
        }
    }

    private static void pausar() {
        System.out.println("\n-------------------------------------------");
        System.out.print("Presione ENTER para continuar...");
        scanner.nextLine();
    }

    private static void limpiarPantalla() {
        for (int i = 0; i < 2; i++) {
            System.out.println();
        }
    }

    private static void mostrarDespedida() {
        limpiarPantalla();
        System.out.println("\n===========================================");
        System.out.println("                                           ");
        System.out.println("       GRACIAS POR USAR EL SISTEMA!       ");
        System.out.println("                                           ");
        System.out.println("      Sistema de Gestion de Colegio UAO   ");
        System.out.println("                                           ");
        System.out.println("===========================================\n");
    }
}
