package spacex;

/**
 * Clase que representa una nave SpaceX tripulada, ampliando la funcionalidad
 * de {@link NaveSpaceX} con la gestión de astronautas y operaciones de
 * acoplamiento en órbita.
 *
 * @author Izan de Geer
 * @version 1.0
 * @since 2026-04-29
 */
class NaveTripulada extends NaveSpaceX {

    /**
     * Número actual de astronautas a bordo.
     */
    private int numeroAstronautas;

    /**
     * Capacidad máxima de astronautas que admite la nave.
     */
    private int capacidadMaxima;

    /**
     * Constructor para crear una nave tripulada con su tripulación inicial
     * y capacidad máxima.
     *
     * @param nombre            Nombre identificativo de la nave.
     * @param combustible       Cantidad inicial de combustible.
     * @param numeroAstronautas Número inicial de astronautas a bordo.
     * @param capacidadMaxima   Capacidad máxima de astronautas.
     */
    public NaveTripulada(String nombre, double combustible, int numeroAstronautas, int capacidadMaxima) {
        super(nombre, combustible);
        this.numeroAstronautas = numeroAstronautas;
        this.capacidadMaxima = capacidadMaxima;
    }

    /**
     * Devuelve el número actual de astronautas a bordo.
     *
     * @return Número de astronautas a bordo.
     */
    public int getNumeroAstronautas() {
        return numeroAstronautas;
    }

    /**
     * Establece el número de astronautas a bordo.
     *
     * @param numeroAstronautas Nuevo número de astronautas.
     * @throws IllegalArgumentException Si el valor es negativo o supera la capacidad máxima.
     */
    public void setNumeroAstronautas(int numeroAstronautas) {
        if (numeroAstronautas < 0 || numeroAstronautas > capacidadMaxima) {
            throw new IllegalArgumentException("Número de astronautas inválido");
        }
        this.numeroAstronautas = numeroAstronautas;
    }

    /**
     * Devuelve la capacidad máxima de astronautas de la nave.
     *
     * @return Capacidad máxima de astronautas.
     */
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    /**
     * Embarca una cantidad determinada de astronautas en la nave.
     *
     * @param cantidad Número de astronautas a embarcar.
     * @throws IllegalArgumentException Si la cantidad es inválida o se
     *                                  supera la capacidad máxima.
     */
    public void embarcar(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad inválida");
        }
        if (numeroAstronautas + cantidad > capacidadMaxima) {
            throw new IllegalArgumentException("Capacidad excedida");
        }
        numeroAstronautas += cantidad;
    }

    /**
     * Desembarca una cantidad determinada de astronautas de la nave.
     *
     * @param cantidad Número de astronautas a desembarcar.
     * @throws IllegalArgumentException Si la cantidad es inválida o
     *                                  supera el número de astronautas a bordo.
     */
    public void desembarcar(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad inválida");
        }
        if (cantidad > numeroAstronautas) {
            throw new IllegalArgumentException("No hay suficientes astronautas");
        }
        numeroAstronautas -= cantidad;
    }

    /**
     * Realiza una maniobra de acoplamiento en órbita.
     *
     * @throws IllegalArgumentException Si la nave no se encuentra en vuelo.
     */
    public void acoplar() {
        if (!enVuelo) {
            throw new IllegalArgumentException("La nave debe estar en vuelo para acoplarse");
        }
        System.out.println("La nave " + nombre + " se está acoplando en órbita.");
    }
}
