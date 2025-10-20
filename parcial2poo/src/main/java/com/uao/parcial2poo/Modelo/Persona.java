
package com.uao.parcial2poo.Modelo;

public abstract class Persona {
    // Atributos privados (Encapsulamiento)
    private final String nombre;
    private final String direccion;
    private final String telefono;
    private final String fechaNacimiento;

    public Persona(String nombre, String direccion, String telefono, String fechaNacimiento) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Calcula la edad de la persona basandose en su fecha de nacimiento
     * Formato esperado: dd/MM/yyyy
     * 
     * @return Edad en años
     */
    public int calcularEdad() {
        // Extraer año de la fecha (formato: dd/MM/yyyy)
        String[] partes = fechaNacimiento.split("/");
        int anoNacimiento = Integer.parseInt(partes[2]);

        int anoActual = 2025;

        // Calcular edad aproximada
        return anoActual - anoNacimiento;
    }

    public abstract String mostrarInformacion();

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nDireccion: " + direccion +
                "\nTelefono: " + telefono +
                "\nFecha de Nacimiento: " + fechaNacimiento +
                "\nEdad: " + calcularEdad() + " años";
    }
}