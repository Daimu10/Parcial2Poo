
package com.uao.parcial2poo.Modelo;

public class Estudiante extends Persona {
    private final String codigo;
    private final String grado;
    private double promedio;

    public Estudiante(String nombre, String direccion, String telefono,
            String fechaNacimiento, String codigo, String grado,
            double promedio) {
        super(nombre, direccion, telefono, fechaNacimiento);
        this.codigo = codigo;
        this.grado = grado;
        this.promedio = promedio;
    }

    @Override
    public String mostrarInformacion() {
        return "\n--- INFORMACION DEL ESTUDIANTE ---\n" +
                super.toString() +
                "\nCodigo: " + codigo +
                "\nGrado: " + grado +
                "\nPromedio: " + promedio +
                "\n----------------------------------";
    }

    /**
     * Determina el estado académico del estudiante
     * 
     * @return Estado académico (Excelente, Bueno, Aceptable, Bajo)
     */
    public String obtenerRendimiento() {
        if (promedio >= 4.5)
            return "Excelente";
        else if (promedio >= 4.0)
            return "Bueno";
        else if (promedio >= 3.0)
            return "Aceptable";
        else
            return "Bajo";
    }

    public String getCodigo() {
        return codigo;
    }

    public String getGrado() {
        return grado;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
}