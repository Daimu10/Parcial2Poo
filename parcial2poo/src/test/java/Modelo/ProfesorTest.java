package Modelo;

import com.uao.parcial2poo.Modelo.Profesor;
import com.uao.parcial2pooModelo.ProfesorMedioTiempo;
import com.uao.parcial2poo.Modelo.ProfesorTiempoCompleto;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ProfesorTest {

    /**
     * Test 1: Verificar que el constructor crea correctamente un profesor
     */
    @Test
    public void testCreacionProfesor() {
        System.out.println("Test: Creación de Profesor");

        Profesor profesor = new Profesor(
                "María García",
                "Calle 123",
                "3001234567",
                "15/03/1985",
                "52123456",
                "Matemáticas",
                25000,
                160);

        assertNotNull("El profesor no debe ser null", profesor);
        assertEquals("María García", profesor.getNombre());
        assertEquals("52123456", profesor.getCedula());
        assertEquals("Matemáticas", profesor.getArea());
        assertEquals(25000, profesor.getSalarioPorHora(), 0.01);
        assertEquals(160, profesor.getHorasDictadas());
    }

    /**
     * Test 2: Verificar el cálculo del salario
     * Salario = (salarioPorHora * horas) + 20% preparación
     */
    @Test
    public void testCalcularSalario() {
        System.out.println("Test: Cálculo de Salario");

        Profesor profesor = new Profesor(
                "Carlos Rodríguez",
                "Carrera 45",
                "3109876543",
                "22/07/1980",
                "79876543",
                "Física",
                30000,
                100
        );

        double salarioEsperado = 3600000.0;
        double salarioCalculado = profesor.calcularSalario();

        assertEquals(salarioEsperado, salarioCalculado, 0.01);
    }

    /**
     * Test 3: Verificar el cálculo de prestaciones sociales
     * Prestaciones = 17% del salario mensual
     */
    @Test
    public void testCalcularPrestaciones() {
        System.out.println("Test: Cálculo de Prestaciones");

        Profesor profesor = new Profesor(
                "Ana Martínez",
                "Avenida 68",
                "3156789012",
                "10/11/1988",
                "1023456789",
                "Química",
                25000,
                120);

        double prestacionesEsperadas = profesor.calcularSalario() * 0.17;
        double prestacionesCalculadas = profesor.calcularPrestaciones();

        assertEquals(prestacionesEsperadas, prestacionesCalculadas, 0.01);
    }

    /**
     * Test 4: Verificar constructor sobrecargado (polimorfismo)
     */
    @Test
    public void testConstructorSobrecargado() {
        System.out.println("Test: Constructor Sobrecargado");

        Profesor profesor = new Profesor(
                "Luis Gómez",
                "Calle 80",
                "3201234567",
                "05/05/1990",
                "1098765432",
                "Inglés",
                22000);

        assertNotNull(profesor);
        assertEquals(0, profesor.getHorasDictadas());
        assertEquals("Luis Gómez", profesor.getNombre());
    }

    /**
     * Test 5: Verificar que un profesor es mayor de edad
     */
    @Test
    public void testProfesorMayorEdad() {
        System.out.println("Test: Profesor Mayor de Edad");

        Profesor profesor = new Profesor(
                "Pedro Sánchez",
                "Carrera 100",
                "3187654321",
                "01/01/1990",
                "1234567890",
                "Historia",
                20000,
                100);

        int edad = profesor.calcularEdad();
        assertTrue("El profesor debe ser mayor de edad", edad >= 18);
    }

    /**
     * Test 6: Verificar método mostrarInformacion
     */
    @Test
    public void testMostrarInformacion() {
        System.out.println("Test: Mostrar Información");

        Profesor profesor = new Profesor(
                "Diana Torres",
                "Avenida 50",
                "3123456789",
                "20/06/1985",
                "9876543210",
                "Biología",
                28000,
                140);

        String info = profesor.mostrarInformacion();

        assertNotNull(info);
        assertTrue(info.contains("Diana Torres"));
        assertTrue(info.contains("9876543210"));
        assertTrue(info.contains("Biología"));
    }
}