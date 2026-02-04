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
        this.horas = horas;
        this.consumo = consumo;
        this.temperaturaMax = temperaturaMax;
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

    public String toString() {
        // Input: ---
        // Output: Devuelve un string con los atributos de una sesión.

        // El String.format es lo que usaba tu profesor para ajustar las cifras
        // decimales. La sintaxis es una cadena que empieza por %, el punto seguido de
        // un número le dice que redondees a ese número de decimales y la "f" indica que
        // el dato que vas a formatear es número en coma flotante, como los float o los
        // double.
        String output = "Horas: " + String.format("%.2f", this.horas)
                + "Consumo: " + String.format("%.2f", this.consumo) + "%"
                + "Temperatura máxima: " + String.format("%.2f", this.temperaturaMax) + "ºC";

        return output;

    }

}
