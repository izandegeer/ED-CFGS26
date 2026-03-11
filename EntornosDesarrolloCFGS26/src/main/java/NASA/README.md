# 👽 NASA - Programa

Te han admitido para hacer tu FE como programador/a en la NASA. En tu primer día te
asignan una tarea sencilla: revisar una pequeña parte del software que utilizan para
registrar formas de vida extraterrestre detectadas por las sondas espaciales.
Una persona del equipo de desarrollo ha creado una clase llamada Alien, que guarda
información básica sobre cada especie descubierta. Antes de usar este código en un
sistema real, el equipo quiere asegurarse de que funciona correctamente.
Tu trabajo será comprobarlo utilizando pruebas unitarias con JUnit.

## Añadir JUnit5
Para añadir JUnit5 al proyecto, tras una ardua investigación, he añadido lo siguiente en pom.xml
```
<dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.10.0</version> <!-- O la versión más reciente -->
        <scope>test</scope>
    </dependency>
```

## Estructura de un proyecto Java con Maven
### ¿En qué parte se guarda el código fuente de la aplicación?
El código fuente se guarda dentro de la carpeta src/main/java

### ¿En qué carpeta se guardan las pruebas unitarias?
Las pruebas unitarias son guardadas en src/test/java

## Ejecución de pruebas y análisis
### 1. ¿Qué significa que un test aparezca en verde?
Significa que el test ha resultado éxitoso.
### 2. ¿Qué significa que un test aparezca en rojo?
Significa que el test ha resultado fallido. Puede ser por 2 cosas:
- El valo esperado no coincide con el valor real.
- Se ha lanzado una excepción (error en el código).
### 3. ¿Cómo se puede ejecutar un solo test?
Es fácil, haciendo click en el icono de 'play' que aparece a la izquierda del test.
### 4. ¿Cómo se ejecutan todos los tests del proyecto?
Parecido a hacer un solo test, pero en lugar de darle a ejecutar al 'play' de la izquierda, pulsas al de la barra de herramientas.

## Análisis de un test con error
Para comprender mejor cómo funciona JUnit, vamos a crear un test que falle. Por ejemplo:
```
@Test 
void testFalloIntencionado() {
    Alien alien = new Alien("Zorg", "MARS01");
    assertEquals("Xenomorph", alien.getName());
}
```

### ¿Qué valor aparece como expected?
"Xenomorph"
### ¿Qué valor aparece como actual?
"Zorg"
### ¿Cómo te ayuda ese mensaje a localizar el error?
El mensaje identifica el error: "AssertionFailedError". Indicando el "Expected" y el "Actual", dandote la opción de visualizar la diferencia
### ¿Qué tendrías que cambiar para que el test pasara correctamente?
Con cambiar uno de los valores para que cumpla con el otro sería suficiente

## Cobertura de código
### ¿Qué es la cobertura de código?
Es el dato que narra qué % del código está siendo cubierto por tests.
![Screenshot 2026-03-11 at 19.44.29.png](../../../../../../../../../../var/folders/h8/yxvj_xl5179g3htrxx9dtdh80000gn/T/TemporaryItems/NSIRD_screencaptureui_UdUrWM/Screenshot%202026-03-11%20at%2019.44.29.png)
### ¿Qué significan los colores que aparecen en el editor?
No entiendo esta pregunta
### ¿Qué partes de tu clase Alien han sido ejecutadas por los tests y cuáles no?

**Ejecutadas**
- El constructor con parámetros Alien(String name, String planetId).
- Los métodos getName(), setName(), getPlanetId() y setPlanetId().
- El método toString().
- El método equals(Object a).

**No Ejecutadas**
- Si en tus tests finales quitaste el test del constructor por defecto (public Alien()), esta parte aparecerá en rojo.
- Si no has borrado el constructor vacío en la clase Alien, asegúrate de tener un test que haga new Alien() para que esa sección también se marque en verde.
