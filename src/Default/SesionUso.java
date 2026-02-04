package Default;

public class SesionUso {

    // Bueno pues voy a ir poniendote aquí un poco comentarios también sobre mi
    // línea de pensamiento a la hora de programar todo. Por lo pronto voy a empezar
    // creando todas las clases con los atributos y métodos que exige el guión sin
    // implementar nada, dejando la implementación para después, cuando entienda
    // mejor cómo funciona cada clase y como interactúan entre ellas.

    // Atributos:
    private double horas;
    private double consumo;
    private double temperaturaMax;

    // Constructores:
    SesionUso(Double horas, Double consumo, Double temperaturaMax) {
        // TODO: implementar
    }

    // Métodos que exige el guión:
    public double getHoras() {
        return horas;
    }

    public double getConsumo() {
        return consumo;
    }

    public double getTemperaturaMax() {
        return temperaturaMax;
    }

    // Métodos extra:

    public String toString() {
        // Input: ---
        // Output: Devuelve un string con los atributos de una sesión.

        // Motivo: He decidido implementar esto porque la clase Dispositivo tiene un
        // método que tiene que mostrar por pantalla la info de cada sesión y, así a
        // priori, he pensado que la forma más fácil de hacerlo va a ser iterando sobre
        // la ArrayList "sesiones" y llamando al método toString() de cada SesionUso
    }

}
