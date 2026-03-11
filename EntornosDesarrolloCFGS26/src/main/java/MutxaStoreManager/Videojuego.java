package MutxaStoreManager;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter
public class Videojuego {

    // Lista que almacena los videojuegos gestionados
    private ArrayList<Videojuego> videojuegos = new ArrayList<>();

    // Atributos del videojuego
    private String titulo;
    private String plataforma;
    private String genero;
    private int anyoLanzamiento;
    private int precio;
    private int stockDisponible;

    // Constructor que inicializa todos los atributos del videojuego
    public Videojuego(String titulo, String plataforma, String genero, int anyoLanzamiento, int precio, int stockDisponible) {
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.genero = genero;
        this.anyoLanzamiento = anyoLanzamiento;
        this.precio = precio;
        this.stockDisponible = stockDisponible;
    }

    // Añade un videojuego a la lista
    public void anyadirVideojuego(Videojuego videojuego) {
        videojuegos.add(videojuego);
    }

    // Busca un videojuego por título y lo elimina de la lista
    // Usa un for con índice porque no se puede hacer remove con un for-each mientras se itera
    public void eliminarVideojuego(String titulo) {
        for (int i = 0; i < videojuegos.size(); i++) {
            if (videojuegos.get(i).getTitulo().equals(titulo)) {
                videojuegos.remove(i);
                return; // Sale del método tras eliminar el primero que coincida
            }
        }
    }

    // Busca un videojuego por título y modifica todos sus campos
    public void modificarVideojuego(String titulo, String plataforma, String genero, int anyoLanzamiento, int precio, int stockDisponible) {
        for (Videojuego videojuego : videojuegos) {
            if (videojuego.getTitulo().equals(titulo)) {
                videojuego.setPlataforma(plataforma);
                videojuego.setGenero(genero);
                videojuego.setAnyoLanzamiento(anyoLanzamiento);
                videojuego.setPrecio(precio);
                videojuego.setStockDisponible(stockDisponible);
                return; // Sale tras modificar el primero que coincida
            }
        }
    }

    // Devuelve una lista con todos los videojuegos que coincidan con la plataforma indicada
    public ArrayList<Videojuego> consultarPorPlataforma(String plataforma) {
        ArrayList<Videojuego> resultado = new ArrayList<>();
        for (Videojuego videojuego : videojuegos) {
            if (videojuego.getPlataforma().equals(plataforma)) {
                resultado.add(videojuego);
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        // Creamos un gestor para controlar la lista de videojuegos
        Videojuego gestor = new Videojuego("", "", "", 0, 0, 0);

        // Añadir videojuegos
        gestor.anyadirVideojuego(new Videojuego("The Legend of Zelda", "Nintendo Switch", "Aventura", 2023, 60, 10));
        gestor.anyadirVideojuego(new Videojuego("God of War", "PS5", "Accion", 2022, 70, 5));
        gestor.anyadirVideojuego(new Videojuego("Mario Kart 8", "Nintendo Switch", "Carreras", 2017, 50, 15));

        System.out.println("=== Añadir videojuego ===");
        for (Videojuego videojuego : gestor.getVideojuegos()) {
            System.out.println(videojuego.getTitulo() + " - " + videojuego.getPlataforma() + " - " + videojuego.getPrecio() + "€");
        }

        // Modificar un videojuego
        gestor.modificarVideojuego("God of War", "PS5", "Accion-Aventura", 2022, 50, 8);
        System.out.println("=== Modificar videojuego ===");
        for (Videojuego videojuego : gestor.getVideojuegos()) {
            System.out.println(videojuego.getTitulo() + " - " + videojuego.getGenero() + " - " + videojuego.getPrecio() + "€");
        }

        // Eliminar un videojuego
        gestor.eliminarVideojuego("Mario Kart 8");
        System.out.println("=== Eliminar videojuego ===");
        for (Videojuego videojuego : gestor.getVideojuegos()) {
            System.out.println(videojuego.getTitulo());
        }

        // Consultar por plataforma
        gestor.anyadirVideojuego(new Videojuego("Mario Kart 8", "Nintendo Switch", "Carreras", 2017, 50, 15));
        System.out.println("\n=== Consultar videojuegos de Nintendo Switch ===");
        for (Videojuego videojuego : gestor.consultarPorPlataforma("Nintendo Switch")) {
            System.out.println(videojuego.getTitulo() + " - " + videojuego.getGenero());
        }
    }
}
