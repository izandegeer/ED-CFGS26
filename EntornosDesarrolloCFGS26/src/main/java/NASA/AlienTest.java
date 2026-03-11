package NASA;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlienTest {

    @Test // El constructor debe guardar correctamente el nombre
    void testConstructorNombre() {
        Alien a = new Alien("Zorg", "MARS01");
        assertNotNull(a.getName());
        assertEquals("Zorg", a.getName());
    }

    @Test // El constructor debe guardar correctamente el planetId
    void testConstructorPlanetId() {
        Alien a = new Alien("Zorg", "MARS01");
        assertNotNull(a.getPlanetId());
        assertEquals("MARS01", a.getPlanetId());
    }

    @Test // El metodo toString() devuelve el resultado esperado
    void testToString() {
        Alien a = new Alien("Xenomorph", "LV426");
        String esperado = "Xenomorph LV426";
        assertEquals(esperado, a.toString());
    }

    @Test // Dos Aliens con el mismo planetId se consideran iguales
    void testEqualsMismoId() {
        Alien a1 = new Alien("Zorg", "MARS01");
        Alien a2 = new Alien("OtroNombre", "MARS01");
        Alien a3 = new Alien("Zorg", "VENUS02");

        assertEquals(a1, a2);
        assertNotEquals(a1, a3);
    }

    @Test // Cambiar el nombre con setName() y comprobar con getName()
    void testSetName() {
        Alien a = new Alien("Zorg", "MARS01");
        a.setName("Ripley");
        assertEquals("Ripley", a.getName());
    }

    @Test // Cambiar el planetId con setPlanetId() y comprobar con getPlanetId()
    void testSetPlanetId() {
        Alien a = new Alien("Zorg", "MARS01");
        a.setPlanetId("SATURN05");
        assertEquals("SATURN05", a.getPlanetId());
    }

    @Test // Test que falla intencionadamente para analizar el error
    void testFalloIntencionado() {
        Alien alien = new Alien("Zorg", "MARS01");
        // Esto fallará porque el nombre real es "Zorg"
        assertEquals("Xenomorph", alien.getName());
    }
}