
package com.uao.parcial2poo.Modelo;

public class ProfesorTiempoCompleto extends Profesor {
    private final double bonificacionTiempoCompleto;

    public ProfesorTiempoCompleto(String nombre, String direccion, String telefono,
            String fechaNacimiento, String cedula, String area,
            double salarioPorHora, int horasDictadas,
            double bonificacionTiempoCompleto) {
        super(nombre, direccion, telefono, fechaNacimiento, cedula, area,
                salarioPorHora, horasDictadas);
        this.bonificacionTiempoCompleto = bonificacionTiempoCompleto;
    }

    /**
     * POLIMORFISMO POR SOBREESCRITURA
     * Calcula el salario incluyendo la bonificación de tiempo completo
     */
    @Override
    public double calcularSalario() {
        return super.calcularSalario() + bonificacionTiempoCompleto;
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() +
                "\nTipo: TIEMPO COMPLETO" +
                "\nBonificación adicional: $" + bonificacionTiempoCompleto;
    }

    public double getBonificacionTiempoCompleto() {
        return bonificacionTiempoCompleto;
    }
}
