package spacex;

/**
 * Clase que representa el motor de una nave espacial, con un tipo
 * y una potencia determinados.
 *
 * @author Izan de Geer
 * @version 1.0
 * @since 2026-04-29
 */
class Motor {

    /**
     * Tipo o modelo del motor.
     */
    private String tipo;

    /**
     * Potencia del motor.
     */
    private int potencia;

    /**
     * Constructor para crear un motor con un tipo y una potencia dados.
     *
     * @param tipo     Tipo o modelo del motor.
     * @param potencia Potencia del motor.
     */
    public Motor(String tipo, int potencia) {
        this.tipo = tipo;
        this.potencia = potencia;
    }

    /**
     * Devuelve el tipo del motor.
     *
     * @return Tipo del motor.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Devuelve la potencia del motor.
     *
     * @return Potencia del motor.
     */
    public int getPotencia() {
        return potencia;
    }

    /**
     * Enciende el motor mostrando por consola su tipo y potencia.
     */
    public void encender() {
        System.out.println("Motor " + tipo + " encendido con potencia " + potencia);
    }

    /**
     * Apaga el motor mostrando un mensaje por consola.
     */
    public void apagar() {
        System.out.println("Motor apagado");
    }
}
