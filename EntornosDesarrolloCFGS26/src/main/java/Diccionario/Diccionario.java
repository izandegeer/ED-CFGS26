package Diccionario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Diccionario {
    static HashMap<String, String> diccionario = new HashMap<>();
    static Scanner teclado = new Scanner(System.in);

    static int contadorPreguntas = 0;
    static int contadorBien = 0;
    static int contadorMal = 0;

    public static void main(String[] args) {
        crearDiccionario();
        juego();
    }

    public static void nuevoPar(Scanner teclado) {
        System.out.print("Introduce el nuevo par: [Formato Español-Inglés]: ");

        String[] datos = Diccionario.teclado.nextLine().split("-");
        diccionario.put(datos[0], datos[1]);

        System.out.println("Palabra '" + datos[0] + "' añadida. (Traducción: '" + datos[1] + "')");
    }

    public static String traduce(String palabraRandom) {
        if (diccionario.containsKey(palabraRandom)) {
            diccionario.get(palabraRandom);
        } else {
            System.out.println("Esa palabra no está en nuestro diccionario.");
        }
        return diccionario.get(palabraRandom);
    }

    public static String palabraAleatoria() {
        Random random = new Random();
        int randomN = random.nextInt(diccionario.size());

        ArrayList<String> diccionarioLista = new ArrayList<>(diccionario.keySet());

        String palabraRandom = diccionarioLista.get(randomN);
        String palabraRandomTraducida = traduce(palabraRandom);

        System.out.println(palabraRandom + ": " + palabraRandomTraducida.charAt(0) + "...");

        return palabraRandom;
    }

    public static void primeraLetraTraduccion() {
        System.out.print("Introduce la palabra a traducir: ");
        String palabra = teclado.next();

        if (diccionario.containsKey(palabra)) {
            System.out.println(diccionario.get(palabra).charAt(0) + "...");
        } else {
            System.out.println("Esa palabra no está en nuestro diccionario.");
        }
    }

    public static void juego() {
        System.out.println("\n*** El juego del diccionario ***");

        String palabra;

        do {
            contadorPreguntas++;
            palabra = palabraAleatoria();
            String palabraRandomTraducida = traduce(palabra);
            System.out.print("Indique la respuesta: ");
            palabra = teclado.next();


            if (palabraRandomTraducida.equalsIgnoreCase(palabra)) {
                System.out.println("¡CORRECTO!\n");
                contadorBien++;
            } else {
                System.out.println("¡NO! La respuesta correcta es " + palabraRandomTraducida + "\n");
                contadorMal++;
            }
        } while (!palabra.equalsIgnoreCase("fin"));

        double division = ((double) contadorBien /contadorPreguntas) * 100;

        System.out.println("FIN DEL PROGRAMA");
        System.out.println("Total de preguntas: " + contadorPreguntas);
        System.out.println("Total aciertos: " + contadorBien);
        System.out.println("Total errores: " + contadorMal);
        System.out.println("Aciertos: " + division + "%");
    }

    public static void crearDiccionario() {
        // Sustantivos - Animales
        diccionario.put("perro", "dog");
        diccionario.put("gato", "cat");
        diccionario.put("pajaro", "bird");
        diccionario.put("pez", "fish");
        diccionario.put("caballo", "horse");
        diccionario.put("vaca", "cow");
        diccionario.put("cerdo", "pig");
        diccionario.put("gallina", "chicken");
        diccionario.put("oveja", "sheep");
        diccionario.put("raton", "mouse");
        diccionario.put("conejo", "rabbit");
        diccionario.put("oso", "bear");
        diccionario.put("leon", "lion");
        diccionario.put("mono", "monkey");
        diccionario.put("tortuga", "turtle");

        // Sustantivos - Casa y objetos
        diccionario.put("casa", "house");
        diccionario.put("mesa", "table");
        diccionario.put("silla", "chair");
        diccionario.put("cama", "bed");
        diccionario.put("puerta", "door");
        diccionario.put("ventana", "window");
        diccionario.put("cocina", "kitchen");
        diccionario.put("baño", "bathroom");
        diccionario.put("jardin", "garden");
        diccionario.put("techo", "roof");
        diccionario.put("suelo", "floor");
        diccionario.put("pared", "wall");
        diccionario.put("escalera", "stairs");
        diccionario.put("llave", "key");
        diccionario.put("reloj", "clock");
        diccionario.put("espejo", "mirror");
        diccionario.put("lampara", "lamp");
        diccionario.put("telefono", "phone");
        diccionario.put("ordenador", "computer");
        diccionario.put("television", "television");

        // Sustantivos - Comida y bebida
        diccionario.put("pan", "bread");
        diccionario.put("leche", "milk");
        diccionario.put("agua", "water");
        diccionario.put("queso", "cheese");
        diccionario.put("huevo", "egg");
        diccionario.put("arroz", "rice");
        diccionario.put("pollo", "chicken");
        diccionario.put("carne", "meat");
        diccionario.put("pescado", "fish");
        diccionario.put("manzana", "apple");
        diccionario.put("platano", "banana");
        diccionario.put("naranja", "orange");
        diccionario.put("tomate", "tomato");
        diccionario.put("patata", "potato");
        diccionario.put("zanahoria", "carrot");
        diccionario.put("lechuga", "lettuce");
        diccionario.put("fresa", "strawberry");
        diccionario.put("uva", "grape");
        diccionario.put("azucar", "sugar");
        diccionario.put("sal", "salt");
        diccionario.put("cafe", "coffee");
        diccionario.put("zumo", "juice");
        diccionario.put("sopa", "soup");
        diccionario.put("helado", "ice cream");
        diccionario.put("galleta", "cookie");
        diccionario.put("tarta", "cake");
        diccionario.put("chocolate", "chocolate");
        diccionario.put("comida", "food");
        diccionario.put("fruta", "fruit");
        diccionario.put("verdura", "vegetable");

        // Sustantivos - Familia y personas
        diccionario.put("padre", "father");
        diccionario.put("madre", "mother");
        diccionario.put("hijo", "son");
        diccionario.put("hija", "daughter");
        diccionario.put("hermano", "brother");
        diccionario.put("hermana", "sister");
        diccionario.put("abuelo", "grandfather");
        diccionario.put("abuela", "grandmother");
        diccionario.put("tio", "uncle");
        diccionario.put("tia", "aunt");
        diccionario.put("primo", "cousin");
        diccionario.put("amigo", "friend");
        diccionario.put("familia", "family");
        diccionario.put("hombre", "man");
        diccionario.put("mujer", "woman");
        diccionario.put("niño", "boy");
        diccionario.put("niña", "girl");
        diccionario.put("bebe", "baby");
        diccionario.put("profesor", "teacher");
        diccionario.put("doctor", "doctor");

        // Sustantivos - Cuerpo
        diccionario.put("cabeza", "head");
        diccionario.put("cara", "face");
        diccionario.put("ojo", "eye");
        diccionario.put("nariz", "nose");
        diccionario.put("boca", "mouth");
        diccionario.put("oreja", "ear");
        diccionario.put("pelo", "hair");
        diccionario.put("mano", "hand");
        diccionario.put("dedo", "finger");
        diccionario.put("pie", "foot");
        diccionario.put("brazo", "arm");
        diccionario.put("pierna", "leg");
        diccionario.put("corazon", "heart");
        diccionario.put("espalda", "back");
        diccionario.put("diente", "tooth");

        // Sustantivos - Ropa
        diccionario.put("camisa", "shirt");
        diccionario.put("pantalon", "pants");
        diccionario.put("zapato", "shoe");
        diccionario.put("falda", "skirt");
        diccionario.put("vestido", "dress");
        diccionario.put("abrigo", "coat");
        diccionario.put("gorro", "hat");
        diccionario.put("bufanda", "scarf");
        diccionario.put("guante", "glove");
        diccionario.put("calcetin", "sock");

        // Sustantivos - Naturaleza
        diccionario.put("sol", "sun");
        diccionario.put("luna", "moon");
        diccionario.put("estrella", "star");
        diccionario.put("cielo", "sky");
        diccionario.put("nube", "cloud");
        diccionario.put("lluvia", "rain");
        diccionario.put("nieve", "snow");
        diccionario.put("viento", "wind");
        diccionario.put("arbol", "tree");
        diccionario.put("flor", "flower");
        diccionario.put("hierba", "grass");
        diccionario.put("rio", "river");
        diccionario.put("mar", "sea");
        diccionario.put("playa", "beach");
        diccionario.put("montaña", "mountain");
        diccionario.put("bosque", "forest");
        diccionario.put("lago", "lake");
        diccionario.put("tierra", "earth");
        diccionario.put("piedra", "stone");
        diccionario.put("fuego", "fire");

        // Sustantivos - Lugares
        diccionario.put("escuela", "school");
        diccionario.put("ciudad", "city");
        diccionario.put("pueblo", "town");
        diccionario.put("calle", "street");
        diccionario.put("tienda", "shop");
        diccionario.put("hospital", "hospital");
        diccionario.put("parque", "park");
        diccionario.put("iglesia", "church");
        diccionario.put("biblioteca", "library");
        diccionario.put("restaurante", "restaurant");

        // Sustantivos - Transporte
        diccionario.put("coche", "car");
        diccionario.put("autobus", "bus");
        diccionario.put("tren", "train");
        diccionario.put("avion", "plane");
        diccionario.put("barco", "ship");
        diccionario.put("bicicleta", "bicycle");

        // Sustantivos - Tiempo y medidas
        diccionario.put("dia", "day");
        diccionario.put("noche", "night");
        diccionario.put("semana", "week");
        diccionario.put("mes", "month");
        diccionario.put("año", "year");
        diccionario.put("hora", "hour");
        diccionario.put("minuto", "minute");
        diccionario.put("tiempo", "time");

        // Sustantivos - Otros
        diccionario.put("libro", "book");
        diccionario.put("papel", "paper");
        diccionario.put("lapiz", "pencil");
        diccionario.put("boligrafo", "pen");
        diccionario.put("dinero", "money");
        diccionario.put("trabajo", "work");
        diccionario.put("juego", "game");
        diccionario.put("musica", "music");
        diccionario.put("cancion", "song");
        diccionario.put("foto", "photo");
        diccionario.put("carta", "letter");
        diccionario.put("regalo", "gift");
        diccionario.put("bolsa", "bag");
        diccionario.put("caja", "box");
        diccionario.put("botella", "bottle");
        diccionario.put("plato", "plate");
        diccionario.put("vaso", "glass");
        diccionario.put("cuchara", "spoon");
        diccionario.put("tenedor", "fork");
        diccionario.put("cuchillo", "knife");

        // Colores
        diccionario.put("rojo", "red");
        diccionario.put("azul", "blue");
        diccionario.put("verde", "green");
        diccionario.put("amarillo", "yellow");
        diccionario.put("negro", "black");
        diccionario.put("blanco", "white");
        diccionario.put("gris", "gray");
        diccionario.put("rosa", "pink");
        diccionario.put("marron", "brown");
        diccionario.put("morado", "purple");

        // Adjetivos
        diccionario.put("grande", "big");
        diccionario.put("pequeño", "small");
        diccionario.put("alto", "tall");
        diccionario.put("bajo", "short");
        diccionario.put("largo", "long");
        diccionario.put("nuevo", "new");
        diccionario.put("viejo", "old");
        diccionario.put("joven", "young");
        diccionario.put("bueno", "good");
        diccionario.put("malo", "bad");
        diccionario.put("feliz", "happy");
        diccionario.put("triste", "sad");
        diccionario.put("bonito", "pretty");
        diccionario.put("feo", "ugly");
        diccionario.put("caliente", "hot");
        diccionario.put("frio", "cold");
        diccionario.put("rapido", "fast");
        diccionario.put("lento", "slow");
        diccionario.put("facil", "easy");
        diccionario.put("dificil", "difficult");
        diccionario.put("fuerte", "strong");
        diccionario.put("debil", "weak");
        diccionario.put("limpio", "clean");
        diccionario.put("sucio", "dirty");
        diccionario.put("lleno", "full");
        diccionario.put("vacio", "empty");

        // Verbos comunes
        diccionario.put("ser", "be");
        diccionario.put("tener", "have");
        diccionario.put("hacer", "do");
        diccionario.put("ir", "go");
        diccionario.put("venir", "come");
        diccionario.put("ver", "see");
        diccionario.put("decir", "say");
        diccionario.put("dar", "give");
        diccionario.put("comer", "eat");
        diccionario.put("beber", "drink");
        diccionario.put("dormir", "sleep");
        diccionario.put("hablar", "speak");
        diccionario.put("leer", "read");
        diccionario.put("escribir", "write");
        diccionario.put("correr", "run");
        diccionario.put("caminar", "walk");
        diccionario.put("saltar", "jump");
        diccionario.put("nadar", "swim");
        diccionario.put("jugar", "play");
        diccionario.put("cantar", "sing");
        diccionario.put("bailar", "dance");
        diccionario.put("cocinar", "cook");
        diccionario.put("comprar", "buy");
        diccionario.put("vender", "sell");
        diccionario.put("abrir", "open");
        diccionario.put("cerrar", "close");
        diccionario.put("empezar", "start");
        diccionario.put("terminar", "finish");
        diccionario.put("querer", "want");
        diccionario.put("saber", "know");
        diccionario.put("pensar", "think");
        diccionario.put("sentir", "feel");
        diccionario.put("vivir", "live");
        diccionario.put("trabajar", "work");
        diccionario.put("estudiar", "study");
        diccionario.put("aprender", "learn");
        diccionario.put("ayudar", "help");
        diccionario.put("llamar", "call");
        diccionario.put("escuchar", "listen");
        diccionario.put("mirar", "look");
        diccionario.put("buscar", "search");
        diccionario.put("encontrar", "find");
        diccionario.put("llevar", "carry");
        diccionario.put("traer", "bring");
        diccionario.put("poner", "put");
        diccionario.put("sacar", "take out");
        diccionario.put("subir", "go up");
        diccionario.put("bajar", "go down");
        diccionario.put("entrar", "enter");
        diccionario.put("salir", "exit");
        diccionario.put("volver", "return");
        diccionario.put("esperar", "wait");
        diccionario.put("pagar", "pay");
        diccionario.put("lavar", "wash");
        diccionario.put("limpiar", "clean");
        diccionario.put("conducir", "drive");
        diccionario.put("volar", "fly");
        diccionario.put("reir", "laugh");
        diccionario.put("llorar", "cry");

        // Numeros
        diccionario.put("uno", "one");
        diccionario.put("dos", "two");
        diccionario.put("tres", "three");
        diccionario.put("cuatro", "four");
        diccionario.put("cinco", "five");
        diccionario.put("diez", "ten");
        diccionario.put("cien", "hundred");
        diccionario.put("mil", "thousand");
        System.out.println("Diccionario cargado con " + diccionario.size() + " palabras.");
    }
}