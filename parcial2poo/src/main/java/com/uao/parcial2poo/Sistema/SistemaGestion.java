package com.uao.parcial2poo.Sistema;

import java.util.ArrayList;
import java.util.List;

import com.uao.parcial2poo.Modelo.Estudiante;
import com.uao.parcial2poo.Modelo.Profesor;
import com.uao.parcial2poo.Modelo.Profesor;

public class SistemaGestion {
    private final List<Profesor> profesores;
    private final List<Estudiante> estudiantes;

    public SistemaGestion() {
        this.profesores = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
    }

    // ============ MÉTODOS PARA PROFESORES ============

    /**
     * Agrega un profesor al sistema
     * @param profesor
     */
    public void agregarProfesor(Profesor profesor) {
        profesores.add(profesor);
        System.out.println("Profesor agregado: " + profesor.getNombre());
    }

    /**
     * Agrega varios profesores al sistema
     * @param listaProfesores
     */
    public void agregarProfesor(List<Profesor> listaProfesores) {
        profesores.addAll(listaProfesores);
        System.out.println("Se agregaron " + listaProfesores.size() + " profesores");
    }

    /**
     * Genera reporte de profesores ordenados por salario
     */
    public void reporteProfesoresPorSalario() {
        System.out.println("========================================");
        System.out.println("  PROFESORES ORDENADOS POR SALARIO");
        System.out.println("========================================");
        System.out.println();

        if (profesores.isEmpty()) {
            System.out.println("No hay profesores registrados en el sistema.");
            return;
        }

        // Ordenar profesores por salario de menor a mayor
        List<Profesor> profesoresOrdenados = new ArrayList<>(profesores);

        // Algoritmo de ordenamiento burbuja (bubble sort)
        // Recorre la lista varias veces e intercambia elementos si están en orden
        // incorrecto
        for (int i = 0; i < profesoresOrdenados.size() - 1; i++) {
            for (int j = 0; j < profesoresOrdenados.size() - 1 - i; j++) {
                // Comparar salarios de profesores consecutivos
                double salarioActual = profesoresOrdenados.get(j).calcularSalario();
                double salarioSiguiente = profesoresOrdenados.get(j + 1).calcularSalario();

                // Si el actual es mayor que el siguiente, intercambiarlos
                if (salarioActual > salarioSiguiente) {
                    Profesor temp = profesoresOrdenados.get(j);
                    profesoresOrdenados.set(j, profesoresOrdenados.get(j + 1));
                    profesoresOrdenados.set(j + 1, temp);
                }
            }
        }

        double totalSalarios = 0;
        double totalPrestaciones = 0;
        int contador = 1;

        for (Profesor profesor : profesoresOrdenados) {
            double salario = profesor.calcularSalario();
            double prestaciones = profesor.calcularPrestaciones();

            System.out.println(contador + ". " + profesor.getNombre());
            System.out.println("   Cedula: " + profesor.getCedula());
            System.out.println("   Area: " + profesor.getArea());
            System.out.println("   Horas dictadas: " + profesor.getHorasDictadas());
            System.out.println("   Salario mensual: $" + salario);
            System.out.println("   Prestaciones: $" + prestaciones);
            System.out.println("   --------------------------------");

            totalSalarios += salario;
            totalPrestaciones += prestaciones;
            contador++;
        }

        System.out.println();
        System.out.println("TOTALES:");
        System.out.println("Total en salarios: $" + totalSalarios);
        System.out.println("Total en prestaciones: $" + totalPrestaciones);
    }

    // ============ MÉTODOS PARA ESTUDIANTES ============

    /**
     * Agrega un estudiante al sistema
     * @param estudiante
     */
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
        System.out.println("Estudiante agregado: " + estudiante.getNombre());
    }

    /**
     * Genera reporte de estudiantes
     */
    public void reporteEstudiantes() {
        System.out.println("========================================");
        System.out.println("        LISTA DE ESTUDIANTES");
        System.out.println("========================================");
        System.out.println();

        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados en el sistema.");
            return;
        }

        int contador = 1;
        double sumaPromedios = 0;

        for (Estudiante estudiante : estudiantes) {
            System.out.println(contador + ". " + estudiante.getNombre());
            System.out.println("   Codigo: " + estudiante.getCodigo());
            System.out.println("   Grado: " + estudiante.getGrado());
            System.out.println("   Edad: " + estudiante.calcularEdad() + " años");
            System.out.println("   Promedio: " + String.format("%.2f", estudiante.getPromedio()));
            System.out.println("   Rendimiento: " + estudiante.obtenerRendimiento());
            System.out.println("   --------------------------------");

            sumaPromedios += estudiante.getPromedio();
            contador++;
        }

        double promedioGeneral = sumaPromedios / estudiantes.size();

        System.out.println();
        System.out.println("ESTADISTICAS:");
        System.out.println("Total de estudiantes: " + estudiantes.size());
        System.out.println("Promedio general: " + String.format("%.2f", promedioGeneral));
    }

    /**
     * Muestra resumen del sistema
     */
    public void reporteGeneral() {
        System.out.println("========================================");
        System.out.println("       REPORTE GENERAL");
        System.out.println("========================================");
        System.out.println();
        System.out.println("Total de profesores: " + profesores.size());
        System.out.println("Total de estudiantes: " + estudiantes.size());
        System.out.println("Total de personas: " + (profesores.size() + estudiantes.size()));
    }

    // Getters
    public List<Profesor> getProfesores() {
        return profesores;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
}