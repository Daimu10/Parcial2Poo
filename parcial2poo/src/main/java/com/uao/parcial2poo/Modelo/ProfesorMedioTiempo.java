
package com.uao.parcial2poo.Modelo;

public class ProfesorMedioTiempo extends Profesor {
    private final int horasMaximas;

    public ProfesorMedioTiempo(String nombre, String direccion, String telefono,
            String fechaNacimiento, String cedula, String area,
            double salarioPorHora, int horasDictadas,
            int horasMaximas) {
        super(nombre, direccion, telefono, fechaNacimiento, cedula, area,
                salarioPorHora, horasDictadas);
        this.horasMaximas = horasMaximas;
    }

    /**
     * POLIMORFISMO POR SOBREESCRITURA
     * Calcula el salario verificando que no exceda las horas máximas
     */
    @Override
    public double calcularSalario() {
        // Verificar que no exceda las horas máximas
        int horasValidas = getHorasDictadas();
        if (horasValidas > horasMaximas) {
            horasValidas = horasMaximas;
        }
        double salarioBase = getSalarioPorHora() * horasValidas;
        double bonificacionPreparacion = salarioBase * 0.20;
        return salarioBase + bonificacionPreparacion;
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() +
                "\nTipo: MEDIO TIEMPO" +
                "\nHoras máximas permitidas: " + horasMaximas;
    }

    public int getHorasMaximas() {
        return horasMaximas;
    }
}
