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
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;

        // ArrayList nos permite hacer listas "dinámicas", es decir, sin un tamaño
        // prefijado y tienen acceso aleatorio, es decir, puedes acceder a cualquier
        // posición de la lista. Ventajas, mayor facilidad de trabajar con ellas, pues
        // puedes ir añadiendo elementos conforme los vayas necesitando, a diferencia de
        // los arrays que necesitas fijar su tamaño al declararlos; y puedes acceder a
        // cualquier elemento de la lista, a diferencia de las pilas o las colas, a las
        // que solo puedes acceder al último o al primer elemento añadido,
        // respectivamente. Sin embargo, en general van a ser menos eficientes que las
        // otras tres colecciones mencionadas.
        this.sesiones = new ArrayList<SesionUso>();

        // Es importante cuando estás trabajando con clases y objetos inicializar
        // *todas* las variables que vas a usar en el constructor, incluso si empiezan
        // vacías, como "sesiones" en este caso.
    }

    // Métodos que exige el guión:

    public void registrarSesion(SesionUso sesion) {
        // Añade la SesionUso "sesion" a la lista "sesiones"
        // Input: sesion - Instancia de SesionUso.
        // Output: ---

        // add nos permite añadir un elemento en la última posición de la lista. También
        // podríamos usar sesiones.add(int pos, SesionUso sesion) para insertar el
        // elemento en la posición "pos".
        sesiones.add(sesion);
    }

    public double mediaConsumo() {
        // Input: ---
        // Output: Media del consumo de las sesiones o 0 si no hay sesiones.

        int numeroSesiones = sesiones.size();

        // Empezamos comprobando si hay sesiones o no midiendo la longitud de
        // "sesiones". En caso afirmativo devolvemos 0.
        if (numeroSesiones == 0) {
            return 0;
        }

        // Si no hemos entrado en la condición anterior es que hay varias sesiones, en
        // cuyo caso calculamos la media. Para ello empezamos creando una variable
        // auxiliar en la que vamos a almacenar la suma total del consumo.

        double sumaTotal = 0;

        // A continuación iteramos sobre la lista y vamos sumando el valor de cada
        // consumo a nuestra variable auxiliar. Se puede iterar de varias formas sobre
        // una lista, la más sencilla es la siguiente.

        for (SesionUso sesion : sesiones) {
            // La forma de leer esto es "para cada [OBJETO] en [LISTA] hacer lo que diga el
            // bucle" y el propio compilador se encarga de gestionar los iteradores.
            // Evidentemente, el objeto sobre el que vas a iterar tiene que ser del mismo
            // tipo que los objetos de la lista.

            sumaTotal = sumaTotal + sesion.getConsumo();
        }

        // Por último la media será la suma total del consumo entre el número de
        // sesiones abiertas.

        double media = sumaTotal / numeroSesiones;
        return media;

    }

    // Para la media de la temperatura se razona de forma similar al método
    // anterior, pero copio también los comentarios para que no tengas que estar
    // cambiando entre ambos métodos para cuando tengas que estudiar.
    public double mediaTemperatura() {
        // Input: ---
        // Output: Media de la temperatura máxima de las sesiones o 0 si no hay
        // sesiones.

        int numeroSesiones = sesiones.size();

        // Empezamos comprobando si hay sesiones o no midiendo la longitud de
        // "sesiones". En caso afirmativo devolvemos 0.
        if (numeroSesiones == 0) {
            return 0;
        }

        // Si no hemos entrado en la condición anterior es que hay varias sesiones, en
        // cuyo caso calculamos la media. Para ello empezamos creando una variable
        // auxiliar en la que vamos a almacenar la suma total de la temperatura.

        double sumaTotal = 0;

        // A continuación iteramos sobre la lista y vamos sumando el valor de cada
        // consumo a nuestra variable auxiliar. Se puede iterar de varias formas sobre
        // una lista, la más sencilla es la siguiente.

        for (SesionUso sesion : sesiones) {
            // La forma de leer esto es "para cada [OBJETO] en [LISTA] hacer lo que diga el
            // bucle" y el propio compilador se encarga de gestionar los iteradores.
            // Evidentemente, el objeto sobre el que vas a iterar tiene que ser del mismo
            // tipo que los objetos de la lista.

            sumaTotal = sumaTotal + sesion.getTemperaturaMax();
        }

        // Por último la media será la suma total del consumo entre el número de
        // sesiones abiertas.

        double media = sumaTotal / numeroSesiones;
        return media;

    }

    // Para el total de horas de uso igual que en ambos casos pero no hay que
    // dividir el número de sesiones.
    public double totalHorasUso() {
        // Input: ---
        // Output: Suma total de horas en todas las sesiones.

        int numeroSesiones = sesiones.size();

        // Empezamos comprobando si hay sesiones o no midiendo la longitud de
        // "sesiones". En caso afirmativo devolvemos 0.
        if (numeroSesiones == 0) {
            return 0;
        }

        // Si no hemos entrado en la condición anterior es que hay varias sesiones, en
        // cuyo caso calculamos la suma. Para ello empezamos creando una variable
        // en la que vamos a almacenar la suma total de las horas de uso.

        double sumaTotal = 0;

        // A continuación iteramos sobre la lista y vamos sumando el valor de cada
        // consumo a nuestra variable auxiliar. Se puede iterar de varias formas sobre
        // una lista, la más sencilla es la siguiente.

        for (SesionUso sesion : sesiones) {
            // La forma de leer esto es "para cada [OBJETO] en [LISTA] hacer lo que diga el
            // bucle" y el propio compilador se encarga de gestionar los iteradores.
            // Evidentemente, el objeto sobre el que vas a iterar tiene que ser del mismo
            // tipo que los objetos de la lista.

            sumaTotal = sumaTotal + sesion.getHoras();
        }

        return sumaTotal;
    }

    public SesionUso sesionMayorConsumo() {
        // Input: ---
        // Output: Devuelve la sesión con mayor consumo o "null" si sesiones está vacía.

        // El inicio de este método es similar a los anteriores, primero vemos a ver si
        // la lista está vacía o no. Si esta vacía devolvemos null y si no lo está
        // iteramos sobre ella.

        int numeroSesiones = sesiones.size();

        if (numeroSesiones == 0) {
            return null;
        }

        // Ahora, nuestra variable auxiliar será una SesionUso, por defecto podemos
        // coger la primera de la lista. Que existe porque sabemos que la lista no está
        // vacía.
        SesionUso sesionMaxConsumo = sesiones.get(0);

        for (SesionUso sesion : sesiones) {
            // Por último en cada paso de la iteración compararemos el consumo con
            // sesionMaxConsumo, si es mayor, actualizamos el valor de sesionMaxConsumo con
            // el valor de la iteración. Si por el contrario es menor o igual, no hacemos
            // nada.
            if (sesion.getConsumo() > sesionMaxConsumo.getConsumo()) {
                sesionMaxConsumo = sesion;
            }

        }

        // Como hemos recorrido todas las sesiones, sabemos que la sesión que esté en
        // "sesionMaxConsumo" será la primera sesión que tenga el consumo máximo, pues
        // en caso contrario la habríamos actualizado dentro del bucle. Por tanto,
        // devolvemos sesionMaxConsumo.

        return sesionMaxConsumo;

    }

    public String toString() {
        // Input: ---
        // Output: Devuelve un String con el código, nombre, tipo, total de horas, media
        // de consumo y media de temperatura.

        String output = "ID: " + this.codigo
                + "Nombre: " + this.nombre
                + "Tipo: " + this.tipo
                + "Total horas: " + String.format("%.2f", this.totalHorasUso())
                + "Consumo medio: " + String.format("%.2f", this.mediaConsumo()) + "%"
                + "Temperatura media: " + String.format("%2.f", this.mediaTemperatura()) + "ºC";

        return output;

    }

    public void mostrarSesiones() {
        // Input: ---
        // Output: ---
        // Muestra por pantalla cada sesión registrada, una por cada línea.

        // Misma idea que antes para iterar sobre la lista y dentro del bucle nos
        // aprovechamos del método toString() que hemos definido en SesionUso.

        if (sesiones.size() == 0) {
            System.out.println("No hay sesiones registradas en este dispositivo.");
        }

        for (SesionUso sesion : sesiones) {
            // Con el método indexOf podemos obtener la posición de un objeto en la lista.
            // Le sumo 1 para que al mostrar por pantalla empiece por 1 en vez de por cero.
            // No es necesario hacer nada de esto pero por un poco el coqueteo y que quede
            // bien el mensaje al mostrarlo por pantalla.

            int posicionSesion = sesiones.indexOf(sesion) + 1;

            String mensajeSesion = "  -Sesión " + posicionSesion + ": " + sesion.toString();

            System.out.println(mensajeSesion);
        }
    }

    // Métodos propios, porque por algún motivo no exige que haya getters y los
    // necesitamos.
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNumeroSesiones() {
        return sesiones.size();
    }

}
