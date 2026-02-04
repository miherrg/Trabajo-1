package Default;

import java.util.HashMap;

public class AlmacenDispositivos {

    // Atributos:
    private Dispositivo[] inventario;
    private int contador;

    // La idea de las tablas Hash es que son estructuras MUY rápidas y eficientes
    // que funcionan como un diccionario. El primer tipo (en este caso String) es la
    // clave por la que buscas y el segundo (en este caso Dispositivo) es el
    // contenido que buscas.
    private HashMap<String, Dispositivo> indicePorCodigo;

    // Constructor:
    AlmacenDispositivos() {

    }

    // Métodos exigidos por el guión:
    public boolean altaDispositivo(Dispositivo dispositivoCandidato) {
        // Input: Instancia de Dispositivo
        // Output: "true" si se da de alta correctamente y "false" en cualquier otro
        // caso.
        // Añade un nuevo Dispositivo a Inventario si no está el código duplicado y no
        // está lleno el array, en cuyo caso aumenta "contador" y devuelve true.

    }

    public Dispositivo buscarPorCodigo(String codigo) {
        // Input: String con el código de dispositivo a buscar.
        // Output: Devuelve el dispositivo con dicho código o null si no existe.

    }

    public void listarDispositivos() {
        // Input: ---
        // Output: ---
        // Muestra por pantalla todos los Dispositivo en inventario.
    }

    public double mediaGlobalConsumo() {
        // Input: ---
        // Output: Media de consumo de todos los dispositivos en inventario.

    }

    public Dispositivo dispositivoMasUsado() {
        // Input: ---
        // Output: Dispositivo con mayor totalHorasUso() o null si el array está vacío.
    }
}
