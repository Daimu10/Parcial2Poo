package Modelo;

import com.uao.parcial2poo.Modelo.Estudiante;
import com.uao.parcial2poo.Modelo.Profesor;
import com.uao.parcial2poo.Modelo.ProfesorMedioTiempo;
import com.uao.parcial2poo.Modelo.ProfesorTiempoCompleto;
import com.uao.parcial2poo.Sistema.SistemaGestion;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;


public class SistemaGestionTest {

    private SistemaGestion sistema;

    @Before
    public void setUp() {
        System.out.println("\n=== Iniciando nuevo test ===");
        sistema = new SistemaGestion();
    }

    /**
     * Test 1: Verificar creación del sistema
     */
    @Test
    public void testCreacionSistema() {
        System.out.println("Test: Creación del Sistema");

        assertNotNull("El sistema no debe ser null", sistema);
        assertNotNull("La lista de profesores no debe ser null", sistema.getProfesores());
        assertNotNull("La lista de estudiantes no debe ser null", sistema.getEstudiantes());
        assertEquals(0, sistema.getProfesores().size());
        assertEquals(0, sistema.getEstudiantes().size());
    }

    /**
     * Test 2: Agregar un profesor al sistema
     */
    @Test
    public void testAgregarProfesor() {
        System.out.println("Test: Agregar Profesor");

        Profesor profesor = new Profesor(
                "María García",
                "Calle 123",
                "3001234567",
                "15/03/1985",
                "52123456",
                "Matemáticas",
                25000,
                160);

        sistema.agregarProfesor(profesor);

        assertEquals(1, sistema.getProfesores().size());
        assertEquals("María García", sistema.getProfesores().get(0).getNombre());
    }

    /**
     * Test 3: Agregar múltiples profesores
     */
    @Test
    public void testAgregarMultiplesProfesores() {
        System.out.println("Test: Agregar Múltiples Profesores");

        Profesor prof1 = new Profesor("Profesor 1", "Dir 1", "300111", "01/01/1980", "111", "Matemáticas", 25000, 100);
        Profesor prof2 = new Profesor("Profesor 2", "Dir 2", "300222", "01/01/1985", "222", "Física", 28000, 120);
        Profesor prof3 = new Profesor("Profesor 3", "Dir 3", "300333", "01/01/1990", "333", "Química", 30000, 140);

        sistema.agregarProfesor(prof1);
        sistema.agregarProfesor(prof2);
        sistema.agregarProfesor(prof3);

        assertEquals(3, sistema.getProfesores().size());
    }

    /**
     * Test 4: Agregar un estudiante al sistema
     */
    @Test
    public void testAgregarEstudiante() {
        System.out.println("Test: Agregar Estudiante");

        Estudiante estudiante = new Estudiante(
                "Juan Herrera",
                "Calle 50",
                "3187654321",
                "12/08/2008",
                "EST001",
                "10 GRADO",
                4.5);

        sistema.agregarEstudiante(estudiante);

        assertEquals(1, sistema.getEstudiantes().size());
        assertEquals("Juan Herrera", sistema.getEstudiantes().get(0).getNombre());
    }

    /**
     * Test 5: Agregar múltiples estudiantes
     */
    @Test
    public void testAgregarMultiplesEstudiantes() {
        System.out.println("Test: Agregar Múltiples Estudiantes");

        Estudiante est1 = new Estudiante("Estudiante 1", "Dir 1", "318111", "01/01/2008", "EST001", "10 GRADO", 4.5);
        Estudiante est2 = new Estudiante("Estudiante 2", "Dir 2", "318222", "01/01/2007", "EST002", "11 GRADO", 4.2);
        Estudiante est3 = new Estudiante("Estudiante 3", "Dir 3", "318333", "01/01/2009", "EST003", "9 GRADO", 3.8);

        sistema.agregarEstudiante(est1);
        sistema.agregarEstudiante(est2);
        sistema.agregarEstudiante(est3);

        assertEquals(3, sistema.getEstudiantes().size());
    }

    /**
     * Test 6: Verificar ordenamiento de profesores por salario
     */
    @Test
    public void testOrdenamientoProfesoresPorSalario() {
        System.out.println("Test: Ordenamiento de Profesores por Salario");

        Profesor prof1 = new Profesor("Prof Alto", "Dir", "300", "01/01/1980", "111", "Matemáticas", 50000, 100);
        Profesor prof2 = new Profesor("Prof Bajo", "Dir", "300", "01/01/1985", "222", "Física", 20000, 100);
        Profesor prof3 = new Profesor("Prof Medio", "Dir", "300", "01/01/1990", "333", "Química", 35000, 100);

        sistema.agregarProfesor(prof1);
        sistema.agregarProfesor(prof2);
        sistema.agregarProfesor(prof3);

        assertTrue(prof2.calcularSalario() < prof3.calcularSalario());
        assertTrue(prof3.calcularSalario() < prof1.calcularSalario());

        System.out.println("\nGenerando reporte ordenado:");
        sistema.reporteProfesoresPorSalario();
    }

    /**
     * Test 7: Verificar reporte de estudiantes
     */
    @Test
    public void testReporteEstudiantes() {
        System.out.println("Test: Reporte de Estudiantes");

        Estudiante est1 = new Estudiante("Ana", "Dir", "318", "01/01/2008", "EST001", "10 GRADO", 4.5);
        Estudiante est2 = new Estudiante("Luis", "Dir", "318", "01/01/2007", "EST002", "11 GRADO", 4.2);

        sistema.agregarEstudiante(est1);
        sistema.agregarEstudiante(est2);

        System.out.println("\nGenerando reporte de estudiantes:");
        sistema.reporteEstudiantes();

        assertEquals(2, sistema.getEstudiantes().size());
    }

    /**
     * Test 8: Verificar cálculo de prestaciones totales
     */
    @Test
    public void testCalculoPrestacionesTotales() {
        System.out.println("Test: Cálculo de Prestaciones Totales");

        Profesor prof1 = new Profesor("Prof 1", "Dir", "300", "01/01/1980", "111", "Matemáticas", 30000, 100);
        Profesor prof2 = new Profesor("Prof 2", "Dir", "300", "01/01/1985", "222", "Física", 25000, 120);

        sistema.agregarProfesor(prof1);
        sistema.agregarProfesor(prof2);

        double totalPrestaciones = 0;
        for (Profesor p : sistema.getProfesores()) {
            totalPrestaciones += p.calcularPrestaciones();
        }

        assertTrue("Las prestaciones deben ser mayores a 0", totalPrestaciones > 0);
        System.out.println("Total de prestaciones calculado: $" + totalPrestaciones);
    }

    /**
     * Test 9: Verificar polimorfismo con diferentes tipos de profesores
     */
    @Test
    public void testPolimorfismoProfesores() {
        System.out.println("Test: Polimorfismo con Diferentes Tipos de Profesores");

        ProfesorTiempoCompleto profTC = new ProfesorTiempoCompleto(
                "Profesor TC", "Dir", "300", "01/01/1980", "111", "Matemáticas",
                30000, 180, 500000);

        ProfesorMedioTiempo profMT = new ProfesorMedioTiempo(
                "Profesor MT", "Dir", "300", "01/01/1985", "222", "Física",
                25000, 80, 100);

        sistema.agregarProfesor(profTC);
        sistema.agregarProfesor(profMT);

        assertEquals(2, sistema.getProfesores().size());

        assertTrue(profTC.calcularSalario() > profMT.calcularSalario());
    }

    /**
     * Test 10: Test de integración completo
     */
    @Test
    public void testIntegracionCompleta() {
        System.out.println("Test: Integración Completa del Sistema");

        sistema.agregarProfesor(new Profesor("Prof 1", "Dir", "300", "01/01/1980", "111", "Matemáticas", 25000, 100));
        sistema.agregarProfesor(new Profesor("Prof 2", "Dir", "300", "01/01/1985", "222", "Física", 28000, 120));

        sistema.agregarEstudiante(new Estudiante("Est 1", "Dir", "318", "01/01/2008", "EST001", "10 GRADO", 4.5));
        sistema.agregarEstudiante(new Estudiante("Est 2", "Dir", "318", "01/01/2007", "EST002", "11 GRADO", 4.2));
        sistema.agregarEstudiante(new Estudiante("Est 3", "Dir", "318", "01/01/2009", "EST003", "9 GRADO", 3.8));

        assertEquals(2, sistema.getProfesores().size());
        assertEquals(3, sistema.getEstudiantes().size());

        System.out.println("\n--- Reporte General ---");
        sistema.reporteGeneral();

        System.out.println("\n--- Reporte de Estudiantes ---");
        sistema.reporteEstudiantes();

        System.out.println("\n--- Reporte de Profesores ---");
        sistema.reporteProfesoresPorSalario();
    }
}