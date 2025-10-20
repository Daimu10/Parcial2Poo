
package com.uao.parcial2poo.Modelo;


public class Profesor extends Persona {
    private final String cedula;
    private final String area;
    private final double salarioPorHora;
    private int horasDictadas;

    public Profesor(String nombre, String direccion, String telefono,
            String fechaNacimiento, String cedula, String area,
            double salarioPorHora, int horasDictadas) {
        super(nombre, direccion, telefono, fechaNacimiento);
        this.cedula = cedula;
        this.area = area;
        this.salarioPorHora = salarioPorHora;
        this.horasDictadas = horasDictadas;
    }

    /**
     * Constructor sobrecargado - POLIMORFISMO POR SOBRECARGA
     * Constructor simplificado sin horas dictadas (inician en 0)
     */
    public Profesor(String nombre, String direccion, String telefono,
            String fechaNacimiento, String cedula, String area,
            double salarioPorHora) {
        this(nombre, direccion, telefono, fechaNacimiento, cedula, area,
                salarioPorHora, 0);
    }

    /**
     * Calcula el salario mensual del profesor
     * Salario = (salarioPorHora * horasDictadas) + 20% por preparación
     * 
     * @return Salario total del mes
     */
    public double calcularSalario() {
        double salarioBase = salarioPorHora * horasDictadas;
        double bonificacionPreparacion = salarioBase * 0.20; // 20% por preparación
        return salarioBase + bonificacionPreparacion;
    }

    /**
     * Calcula las prestaciones sociales que el colegio debe cubrir
     * Prestaciones = 17% del salario mensual
     * 
     * @return Valor de las prestaciones sociales
     */
    public double calcularPrestaciones() {
        return calcularSalario() * 0.17; // 17% del salario
    }

    @Override
    public String mostrarInformacion() {
        return "\n--- INFORMACION DEL PROFESOR ---\n" +
                super.toString() +
                "\nCedula: " + cedula +
                "\nArea: " + area +
                "\nSalario por hora: $" + salarioPorHora +
                "\nHoras dictadas: " + horasDictadas +
                "\nSalario mensual: $" + calcularSalario() +
                "\nPrestaciones: $" + calcularPrestaciones() +
                "\n--------------------------------";
    }

    public String getCedula() {
        return cedula;
    }

    public String getArea() {
        return area;
    }

    public double getSalarioPorHora() {
        return salarioPorHora;
    }

    public int getHorasDictadas() {
        return horasDictadas;
    }

    public void setHorasDictadas(int horasDictadas) {
        this.horasDictadas = horasDictadas;
    }
}
