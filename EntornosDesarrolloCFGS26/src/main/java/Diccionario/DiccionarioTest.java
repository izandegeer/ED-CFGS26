package Diccionario;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

public class DiccionarioTest {

    // Inserción correcta de pares
    @Test
    void testInsercionCorrecta() {
        // Usamos un Scanner que lee directamente de un String
        Scanner teclado = new Scanner("mesa-table");

        Diccionario.nuevoPar(teclado);

        assertEquals("table", Diccionario.diccionario.get("mesa"));
    }

    // Traducción de palabras existentes
    @Test
    public void testTraduccionExistente() {
        Diccionario.diccionario.put("perro", "dog");
        assertEquals("dog", Diccionario.traduce("perro"));
    }

    // Traducción de palabras NO existentes
    @Test
    public void testTraduccionInexistente() {
        assertNull(Diccionario.traduce("avion"));
    }

    // Obtención de una palabra aleatoria
    @Test
    public void testPalabraAleatoria() {
        Diccionario.diccionario.put("rojo", "red");
        Diccionario.diccionario.put("azul", "blue");

        String resultado = Diccionario.palabraAleatoria();
        assertTrue(Diccionario.diccionario.containsKey(resultado));
    }

    // Primera letra de la traducción
    @Test
    void testPrimeraLetraTraduccion() {
        Diccionario.diccionario.put("manzana", "apple");

        String input = "manzana";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

        Diccionario.teclado = new java.util.Scanner(System.in);

        assertDoesNotThrow(Diccionario::primeraLetraTraduccion);
    }

    // Comportamiento con diccionario vacío
    @Test
    public void testDiccionarioVacio() {
        assertTrue(Diccionario.diccionario.isEmpty());
    }
}