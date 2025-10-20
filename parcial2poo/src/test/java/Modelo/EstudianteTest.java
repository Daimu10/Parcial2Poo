package Modelo;
 
import com.uao.parcial2poo.Modelo.Estudiante;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class EstudianteTest {

    /**
     * Test 1: Verificar que el constructor crea correctamente un estudiante
     */
    @Test
    public void testCreacionEstudiante() {
        System.out.println("Test: Creación de Estudiante");

        Estudiante estudiante = new Estudiante(
                "Juan Herrera",
                "Calle 50",
                "3187654321",
                "12/08/2008",
                "EST001",
                "10 GRADO",
                4.5);

        assertNotNull("El estudiante no debe ser null", estudiante);
        assertEquals("Juan Herrera", estudiante.getNombre());
        assertEquals("EST001", estudiante.getCodigo());
        assertEquals("10 GRADO", estudiante.getGrado());
        assertEquals(4.5, estudiante.getPromedio(), 0.01);
    }

    /**
     * Test 2: Verificar atributos heredados de Persona
     */
    @Test
    public void testAtributosHeredados() {
        System.out.println("Test: Atributos Heredados de Persona");

        Estudiante estudiante = new Estudiante(
                "Laura Moreno",
                "Carrera 30 #40-50",
                "3123456789",
                "25/03/2007",
                "EST002",
                "11 GRADO",
                4.8);

        assertEquals("Laura Moreno", estudiante.getNombre());
        assertEquals("Carrera 30 #40-50", estudiante.getDireccion());
        assertEquals("3123456789", estudiante.getTelefono());
        assertEquals("25/03/2007", estudiante.getFechaNacimiento());
    }

    /**
     * Test 3: Verificar cálculo de edad del estudiante
     */
    @Test
    public void testCalcularEdad() {
        System.out.println("Test: Calcular Edad del Estudiante");

        Estudiante estudiante = new Estudiante(
                "Andrés Torres",
                "Avenida 15",
                "3209876543",
                "18/11/2009",
                "EST003",
                "9 GRADO",
                3.8);

        int edad = estudiante.calcularEdad();

        assertTrue("La edad debe ser mayor a 0", edad > 0);
        assertTrue("La edad debe ser menor a 20", edad < 20);
    }

    /**
     * Test 4: Verificar método obtenerRendimiento con promedio excelente
     */
    @Test
    public void testRendimientoExcelente() {
        System.out.println("Test: Rendimiento Excelente");

        Estudiante estudiante = new Estudiante(
                "Sofia Castro",
                "Calle 100",
                "3156781234",
                "30/06/2008",
                "EST004",
                "10 GRADO",
                4.7);

        assertEquals("Excelente", estudiante.obtenerRendimiento());
    }

    /**
     * Test 5: Verificar método obtenerRendimiento con promedio bueno
     */
    @Test
    public void testRendimientoBueno() {
        System.out.println("Test: Rendimiento Bueno");

        Estudiante estudiante = new Estudiante(
                "Santiago Ruiz",
                "Carrera 70",
                "3134567890",
                "14/09/2007",
                "EST005",
                "11 GRADO",
                4.2);

        assertEquals("Bueno", estudiante.obtenerRendimiento());
    }

    /**
     * Test 6: Verificar método obtenerRendimiento con promedio aceptable
     */
    @Test
    public void testRendimientoAceptable() {
        System.out.println("Test: Rendimiento Aceptable");

        Estudiante estudiante = new Estudiante(
                "María López",
                "Calle 20",
                "3198765432",
                "05/02/2009",
                "EST006",
                "9 GRADO",
                3.5);

        assertEquals("Aceptable", estudiante.obtenerRendimiento());
    }

    /**
     * Test 7: Verificar método obtenerRendimiento con promedio bajo
     */
    @Test
    public void testRendimientoBajo() {
        System.out.println("Test: Rendimiento Bajo");

        Estudiante estudiante = new Estudiante(
                "Carlos Díaz",
                "Avenida 40",
                "3176543210",
                "22/12/2008",
                "EST007",
                "10 GRADO",
                2.8);

        assertEquals("Bajo", estudiante.obtenerRendimiento());
    }

    /**
     * Test 8: Verificar método mostrarInformacion
     */
    @Test
    public void testMostrarInformacion() {
        System.out.println("Test: Mostrar Información del Estudiante");

        Estudiante estudiante = new Estudiante(
                "Valentina Gómez",
                "Carrera 15",
                "3145678901",
                "10/04/2008",
                "EST008",
                "10 GRADO",
                4.4);

        String info = estudiante.mostrarInformacion();

        assertNotNull(info);
        assertTrue(info.contains("Valentina Gómez"));
        assertTrue(info.contains("EST008"));
        assertTrue(info.contains("10 GRADO"));
    }

    /**
     * Test 9: Verificar modificación de promedio
     */
    @Test
    public void testModificarPromedio() {
        System.out.println("Test: Modificar Promedio");

        Estudiante estudiante = new Estudiante(
                "Felipe Ramírez",
                "Calle 60",
                "3167890123",
                "15/09/2007",
                "EST009",
                "11 GRADO",
                3.9);

        assertEquals(3.9, estudiante.getPromedio(), 0.01);

        estudiante.setPromedio(4.5);

        assertEquals(4.5, estudiante.getPromedio(), 0.01);
        assertEquals("Excelente", estudiante.obtenerRendimiento());
    }
}
