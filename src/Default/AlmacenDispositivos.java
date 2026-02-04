package Default;

import java.util.HashMap;

public class AlmacenDispositivos {

    // Atributos:
    private Dispositivo[] inventario;
    private int contador;

    // La idea de las tablas Hash es que son estructuras MUY rápidas y eficientes
    // que funcionan como un diccionario. El primer tipo (en este caso String) es la
    // clave (key) por la que buscas y el segundo (en este caso Dispositivo) es el
    // contenido (value) que buscas.
    private HashMap<String, Dispositivo> indicePorCodigo;

    // Constructor:
    AlmacenDispositivos() {

        // Como he dicho en otros constructores es importante inicializar todos los
        // atributos aunque estén vacíos.

        inventario = new Dispositivo[30];

        // En este caso es importante llevar un contador de cuántos dispositivos hay en
        // el array "inventario", porque al ser de tamaño fijo, inventario.length va a
        // ser siempre 30 (y en este caso no tiene parentesis al final por technical
        // mumbo jumbo que si quieres me preguntas y te explico pero ñeh, tampoco es
        // demasiaaado relevante).
        contador = 0;

        indicePorCodigo = new HashMap<String, Dispositivo>();

    }

    // Métodos exigidos por el guión:
    public boolean altaDispositivo(Dispositivo dispositivoCandidato) {
        // Input: Instancia de Dispositivo
        // Output: "true" si se da de alta correctamente y "false" en cualquier otro
        // caso.
        // Añade un nuevo Dispositivo a Inventario si no está el código duplicado y no
        // está lleno el array, en cuyo caso aumenta "contador" y devuelve true.

        // Empezamos comprobando que el dispositivo no está en el sistema y que hay
        // espacio en el array. Para comprobar si un dispositivo está en el sistema ya o
        // no usamos el método "containsKey()" que nos permite comprobar si la clave
        // especificada está en el HashMap.

        if (indicePorCodigo.containsKey(dispositivoCandidato.getCodigo()) || contador == 30) {
            return false;
        }

        // Como sabemos que podemos añadir el dispositivo, usamos el método put(K key, V
        // value) para añadir el dispositivo a la HashTable, añadimos el dispositivo al
        // array en la posición que marque el contador e incrementamos el contador en 1.

        indicePorCodigo.put(dispositivoCandidato.getCodigo(), dispositivoCandidato);
        inventario[contador] = dispositivoCandidato;
        contador = contador + 1;

        // Por último, como hemos podido añadir el dispositivo, devolvemos true;
        return true;

    }

    public Dispositivo buscarPorCodigo(String codigo) {
        // Input: String con el código de dispositivo a buscar.
        // Output: Devuelve el dispositivo con dicho código o null si no existe.

        // I mean, se podría hacer de forma manual, pero el método get(K key) hace
        // exactamente esto asi que...

        return indicePorCodigo.get(codigo);
    }

    public void listarDispositivos() {
        // Input: ---
        // Output: ---
        // Muestra por pantalla todos los Dispositivo en inventario.

        // Aquí no se puede hacer el "para cada elemento del array haz x" así que toca
        // hacerlo de forma un poco manual.

        for (int i = 0; i < contador; i++) {
            // Recuerda esto que significa "desde i = 0, incrementando de 1 en 1, mientras i
            // sea menor que contador haz: ..."
            System.out.println(inventario[i].toString());
        }
    }

    public double mediaGlobalConsumo() {
        // Input: ---
        // Output: Media de consumo de todos los dispositivos en inventario.

        // Misma idea que en Dispositivo, pero iterando de forma manual como en el
        // método anterior. Ahora bien, no sé muy bien cómo de bruta ser a la hora de
        // calcular la media, porque no sé si hacer la aritmética simple o la correcta.
        // El quid de la cuestión es que la forma técnicamente correcta de hacerlo sería
        // la siguiente:
        // Creamos variables auxiliares para contar el consumo total de todas las
        // sesiones con todos los dispositivos y el número total de sesiones de cada
        // dispositivo.

        double sumaConsumoGlobal = 0;
        int numeroSesionesGlobal = 0;

        // Iteramos sobre todos los dispositivos.

        for (int i = 0; i < contador; i++) {
            Dispositivo dispositivoAEstudiar = inventario[i];

            int numeroSesionesDispositivo = dispositivoAEstudiar.getNumeroSesiones();

            // Como la medida de consumo de un dispositivo era la suma total de consumos
            // entre el número de sesiones, para obtener la suma total basta con multiplicar
            // la media por el número de sesiones en el dispositivo.

            double sumaConsumoDispositivo = dispositivoAEstudiar.mediaConsumo() * numeroSesionesDispositivo;

            // Por último sumamos estos dos valores a los valores globales definidos
            // anteriormente.

            sumaConsumoGlobal = sumaConsumoGlobal + sumaConsumoDispositivo;
            numeroSesionesGlobal = numeroSesionesGlobal + numeroSesionesDispositivo;
        }

        // Con estos dos valores ya podemos calcular la media global y la devolvemos.
        double mediaGlobal = sumaConsumoGlobal / numeroSesionesGlobal;
        return mediaGlobal;

        // Ahora bien, me fío cero de los conocimientos de tu profesor y solo quiere que
        // pilles la media de cada dispositivo y hagas una media aritmética simple entre
        // ellas, de la siguiente manera (comentado):

        // double sumaMedias = 0;
        // for (int i = 0; i < contador; i++) {
        // Dispositivo dispositivoAEstudiar = inventario[i];
        // sumaMedias = sumaMedias + dispositivoAEstudiar.mediaConsumo();
        // }
        // double mediaMalCalculada = sumaMedias / contador;
        // return mediaMalCalculada;

    }

    public Dispositivo dispositivoMasUsado() {
        // Input: ---
        // Output: Dispositivo con mayor totalHorasUso() o null si el array está vacío.

        // Empezamos comprobando que el array no esté vacío.

        if (contador == 0) {
            return null;
        }

        // Si no está vacío, creamos dos variables auxiliares, una para calcular el
        // máximo de horas y otra para calcular el índice del dispositivo que alcance el
        // máximo.

        double maxHoras = inventario[0].totalHorasUso();
        int maxIndice = 0;

        // Iteramos y vamos actualizando los valores con el máximo que encontremos.

        for (int i = 0; i < contador; i++) {
            Dispositivo dispositivoAEstudiar = inventario[i];
            if (dispositivoAEstudiar.totalHorasUso() > maxHoras) {
                maxHoras = dispositivoAEstudiar.totalHorasUso();
                maxIndice = i;
            }
        }

        // Al salir del bucle nos hemos asegurado que en maxIndice está el índice con la
        // primera instancia del array que tiene el total de horas más alto, por tanto
        // devolvemos esa instancia.
        return inventario[maxIndice];

    }
}
