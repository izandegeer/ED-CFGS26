package spacex;

/**
 * Clase que representa una nave espacial de SpaceX con operaciones
 * básicas como lanzar, aterrizar, repostar y consumir combustible.
 *
 * Esta clase simula el comportamiento básico de una nave espacial
 * no tripulada equipada con un motor.
 *
 * @author Izan de Geer
 * @version 1.0
 * @since 2026-04-29
 */
public class NaveSpaceX {

    /** Nombre identificativo de la nave. */
    protected String nombre;

    /** Cantidad actual de combustible disponible en la nave. */
    protected double combustible;

    /** Motor que equipa la nave. */
    protected Motor motor;

    /** Indica si la nave se encuentra actualmente en vuelo. */
    protected boolean enVuelo;

    /**
     * Constructor para crear una nave con nombre y combustible inicial.
     * Asigna por defecto un motor Merlin con potencia 845.
     *
     * @param nombre Nombre identificativo de la nave.
     * @param combustible Cantidad inicial de combustible.
     */
    public NaveSpaceX(String nombre, double combustible) {
        this.nombre = nombre;
        this.combustible = combustible;
        this.motor = new Motor("Merlin", 845);
        this.enVuelo = false;
    }

    /**
     * Metodo para lanzar la nave al espacio.
     *
     * Cambia el estado de la nave a "en vuelo".
     *
     * @throws IllegalArgumentException Si la nave no tiene combustible.
     */
    public void lanzar() {
        if (combustible <= 0) {
            throw new IllegalArgumentException("No hay combustible para lanzar");
        }
        enVuelo = true;
        System.out.println("Lanzando nave " + nombre);
    }

    /**
     * Metodo para aterrizar la nave.
     *
     * Cambia el estado de la nave a "fuera de vuelo".
     *
     * @throws IllegalArgumentException Si la nave no está en vuelo.
     */
    public void aterrizar() {
        if (!enVuelo) {
            throw new IllegalArgumentException("La nave no está en vuelo");
        }
        enVuelo = false;
        System.out.println("Aterrizando nave " + nombre);
    }

    /**
     * Metodo para añadir combustible a la nave.
     *
     * @param cantidad Cantidad de combustible a añadir.
     * @throws IllegalArgumentException Si la cantidad es inválida o
     *         si la nave está en vuelo.
     */
    public void repostar(double cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad inválida");
        }
        if (enVuelo) {
            throw new IllegalArgumentException("No se puede repostar en vuelo");
        }
        this.combustible += cantidad;
    }

    /**
     * Metodo para consumir combustible de la nave.
     *
     * @param cantidad Cantidad de combustible a consumir.
     * @throws IllegalArgumentException Si la cantidad es inválida o
     *         si supera el combustible disponible.
     */
    public void consumirCombustible(double cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad inválida");
        }
        if (cantidad > combustible) {
            throw new IllegalArgumentException("Combustible insuficiente");
        }
        this.combustible -= cantidad;
    }

    /**
     * Metodo que devuelve el combustible actual de la nave.
     *
     * @return Cantidad de combustible disponible.
     */
    public double consultarCombustible() {
        return combustible;
    }

    /**
     * Metodo que indica si la nave está en vuelo.
     *
     * @return {@code true} si la nave está en vuelo, {@code false} en caso contrario.
     */
    public boolean isEnVuelo() {
        return enVuelo;
    }
}

