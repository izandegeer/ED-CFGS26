package spacex.simulacion;

/**
 * Representa una nave espacial de SpaceX, ofreciendo las funciones
 * principales para gestionar su despegue, aterrizaje, repostaje y
 * el consumo de combustible durante una misión.
 *
 * Modela el funcionamiento de una nave no tripulada que dispone
 * de un motor para impulsarse.
 *
 * @author Equipo de simulación SpaceX
 * @version 1.0
 * @since 2026-04-29
 */
public class NaveSpaceX {

    /** Nombre con el que se identifica la nave. */
    protected String nombre;

    /** Combustible que la nave tiene en este momento. */
    protected double combustible;

    /** Motor con el que está equipada la nave. */
    protected Motor motor;

    /** Bandera que señala si la nave se encuentra volando. */
    protected boolean enVuelo;

    /**
     * Crea una nave indicando su nombre y la cantidad de combustible
     * con la que parte. Por defecto se le instala un motor Merlin
     * de potencia 845.
     *
     * @param nombre Identificador de la nave.
     * @param combustible Combustible inicial con el que parte la nave.
     */
    public NaveSpaceX(String nombre, double combustible) {
        this.nombre = nombre;
        this.combustible = combustible;
        this.motor = new Motor("Merlin", 845);
        this.enVuelo = false;
    }

    /**
     * Realiza el despegue de la nave hacia el espacio.
     *
     * Tras la operación, la nave queda marcada como en vuelo.
     *
     * @throws IllegalArgumentException Cuando no queda combustible disponible.
     */
    public void lanzar() {
        if (combustible <= 0) {
            throw new IllegalArgumentException("No hay combustible para lanzar");
        }
        enVuelo = true;
        System.out.println("Lanzando nave " + nombre);
    }

    /**
     * Hace que la nave aterrice.
     *
     * Tras esta operación, la nave deja de estar en vuelo.
     *
     * @throws IllegalArgumentException Cuando la nave todavía no está volando.
     */
    public void aterrizar() {
        if (!enVuelo) {
            throw new IllegalArgumentException("La nave no está en vuelo");
        }
        enVuelo = false;
        System.out.println("Aterrizando nave " + nombre);
    }

    /**
     * Suma combustible al depósito de la nave.
     *
     * @param cantidad Litros de combustible que se quieren añadir.
     * @throws IllegalArgumentException Si la cantidad recibida no es válida o
     *         si la nave se encuentra en pleno vuelo.
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
     * Reduce el combustible disponible de la nave en una cantidad concreta.
     *
     * @param cantidad Cantidad de combustible que se desea consumir.
     * @throws IllegalArgumentException Si la cantidad no es válida o
     *         si excede al combustible disponible.
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
     * Obtiene la cantidad de combustible que la nave tiene en este momento.
     *
     * @return Combustible disponible en la nave.
     */
    public double consultarCombustible() {
        return combustible;
    }

    /**
     * Indica si la nave se encuentra actualmente volando.
     *
     * @return {@code true} si la nave está en vuelo y {@code false} si no lo está.
     */
    public boolean isEnVuelo() {
        return enVuelo;
    }
}

/**
 * Versión tripulada de la nave SpaceX. Hereda toda la funcionalidad
 * básica de {@link NaveSpaceX} y añade la gestión de astronautas
 * a bordo, así como la maniobra de acoplamiento orbital.
 *
 * @author Equipo de simulación SpaceX
 * @version 1.0
 * @since 2026-04-29
 */
class NaveTripulada extends NaveSpaceX {

    /** Cantidad de astronautas que viajan actualmente en la nave. */
    private int numeroAstronautas;

    /** Tope máximo de astronautas que admite la nave. */
    private int capacidadMaxima;

    /**
     * Crea una nave tripulada indicando los astronautas iniciales y
     * la capacidad total que soporta.
     *
     * @param nombre Identificador de la nave.
     * @param combustible Combustible inicial.
     * @param numeroAstronautas Astronautas que viajan al iniciar.
     * @param capacidadMaxima Tope máximo de tripulación admitido.
     */
    public NaveTripulada(String nombre, double combustible, int numeroAstronautas, int capacidadMaxima) {
        super(nombre, combustible);
        this.numeroAstronautas = numeroAstronautas;
        this.capacidadMaxima = capacidadMaxima;
    }

    /**
     * Indica cuántos astronautas viajan en la nave en este momento.
     *
     * @return Número de astronautas a bordo.
     */
    public int getNumeroAstronautas() {
        return numeroAstronautas;
    }

    /**
     * Modifica el número de astronautas a bordo.
     *
     * @param numeroAstronautas Nueva cantidad de astronautas.
     * @throws IllegalArgumentException Si el valor es negativo o pasa de la capacidad.
     */
    public void setNumeroAstronautas(int numeroAstronautas) {
        if (numeroAstronautas < 0 || numeroAstronautas > capacidadMaxima) {
            throw new IllegalArgumentException("Número de astronautas inválido");
        }
        this.numeroAstronautas = numeroAstronautas;
    }

    /**
     * Devuelve el número máximo de astronautas que puede llevar la nave.
     *
     * @return Capacidad máxima de la tripulación.
     */
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    /**
     * Hace subir a la nave una cantidad determinada de astronautas.
     *
     * @param cantidad Cantidad de astronautas a embarcar.
     * @throws IllegalArgumentException Si la cantidad no es válida o si
     *         se sobrepasa la capacidad máxima permitida.
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
     * Hace bajar de la nave una cantidad determinada de astronautas.
     *
     * @param cantidad Cantidad de astronautas a desembarcar.
     * @throws IllegalArgumentException Si la cantidad no es válida o si
     *         supera al total de astronautas a bordo.
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
     * Lleva a cabo la maniobra de acoplamiento en órbita.
     *
     * @throws IllegalArgumentException Cuando la nave no está volando.
     */
    public void acoplar() {
        if (!enVuelo) {
            throw new IllegalArgumentException("La nave debe estar en vuelo para acoplarse");
        }
        System.out.println("La nave " + nombre + " se está acoplando en órbita.");
    }
}

/**
 * Modela el motor que impulsa una nave espacial. Está definido por
 * un tipo (modelo) y la potencia que ofrece.
 *
 * @author Equipo de simulación SpaceX
 * @version 1.0
 * @since 2026-04-29
 */
class Motor {

    /** Modelo o denominación del motor. */
    private String tipo;

    /** Potencia que produce el motor. */
    private int potencia;

    /**
     * Construye un motor a partir de su modelo y la potencia que entrega.
     *
     * @param tipo Modelo del motor.
     * @param potencia Potencia entregada por el motor.
     */
    public Motor(String tipo, int potencia) {
        this.tipo = tipo;
        this.potencia = potencia;
    }

    /**
     * Recupera el modelo del motor.
     *
     * @return Modelo del motor.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Recupera la potencia que entrega el motor.
     *
     * @return Potencia del motor.
     */
    public int getPotencia() {
        return potencia;
    }

    /**
     * Pone en marcha el motor mostrando por consola un mensaje
     * con su tipo y la potencia que ofrece.
     */
    public void encender() {
        System.out.println("Motor " + tipo + " encendido con potencia " + potencia);
    }

    /**
     * Detiene el motor e imprime un mensaje informando del apagado.
     */
    public void apagar() {
        System.out.println("Motor apagado");
    }
}
