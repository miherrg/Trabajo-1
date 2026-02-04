package Default;

import java.util.ArrayList;

public class Dispositivo {
    // Atributos:
    private String codigo;
    private String nombre;
    private String tipo;

    private ArrayList<SesionUso> sesiones;

    // Constructor:
    Dispositivo(String codigo, String nombre, String tipo) {
        // TODO: Implementar (importante inicializar "sesiones")
    }

    // Métodos que exige el guión:

    public void registrarSesion(SesionUso sesion) {
        // Añade la SesionUso "sesion" a la lista "sesiones"
        // Input: sesion - Instancia de SesionUso.
        // Output: ---
    }

    public double mediaConsumo() {
        // Input: ---
        // Output: Media del consumo de las sesiones o 0 si no hay sesiones.
    }

    public double mediaTemperatura() {
        // Input: ---
        // Output: Media de la temperatura máxima de las sesiones o 0 si no hay
        // sesiones.
    }

    public double totalHorasUso() {
        // Input: ---
        // Output: Suma total de horas en todas las sesiones.
    }

    public SesionUso sesionMayorConsumo() {
        // Input: ---
        // Output: Devuelve la sesión con mayor consumo o "null" si sesiones está vacía.
    }

    public String toString() {
        // Input: ---
        // Output: Devuelve un String con el código, nombre, tipo, total de horas, media
        // de consumo y media de temperatura.

    }

    public void mostrarSesiones() {
        // Input: ---
        // Output: ---
        // Muestra por pantalla cada sesión registrada, una por cada línea.
    }
}
