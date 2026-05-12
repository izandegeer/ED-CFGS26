# Parte 2 - Detección del error

Al ejecutar los tests fallan 2 tests, lo que significa que hay 2 errores en el código.

## Error 1

### 1. ¿Qué test falla?

Falla el test testLimite6_9, que comprueba que obtenerResultado(6.9) devuelve "Notable" (como dice CP04 de la tabla).

### 2. ¿Por qué falla?

El test esperaba "Notable" pero el método devuelve "Aprobado". Esto pasa porque 6.9 lo redondea 6, y en el switch el case 6 está dentro del bloque que devuelve "Aprobado".

### 3. ¿En qué línea está el problema?

En la línea 27, donde está el case 6 metido en el grupo del "Aprobado":

case 5:
case 6:
    return "Aprobado";

### 4. ¿Cómo se podría corregir?

Mover el case 6 al bloque del "Notable":

case 5:
    return "Aprobado";

case 6:
case 7:
case 8:
    return "Notable";

## Error 2

### 1. ¿Qué test falla?

Falla el test testCalcularNotaFinalCasoCorrecto, que comprueba que calcularNotaFinal(6, 7, 8) devuelve 6.9 (como dice CP01 de la tabla).

### 2. ¿Por qué falla?

El test esperaba 6.9 pero el método devuelve 6.7. El cálculo del código es 6 * 0.5 + 7 * 0.3 + 8 * 0.2 = 6.7, pero para que dé 6.9 los pesos tendrían que ser 0.4, 0.3 y 0.3.

### 3. ¿En qué línea está el problema?

En la línea 10:

return examen * 0.5 + practicas * 0.3 + proyecto * 0.2;

### 4. ¿Cómo se podría corregir?

Cambiar los pesos:

return examen * 0.4 + practicas * 0.3 + proyecto * 0.3;

# Parte 3 - Casos de prueba

| ID   | Método            | Entrada | Resultado esperado | Resultado obtenido | ¿Correcto? |
|------|-------------------|---------|--------------------|--------------------|------------|
| CP01 | calcularNotaFinal | 6,7,8   | 6.9                | 6.7                | No         |
| CP02 | obtenerResultado  | 4.9     | Suspenso           | Suspenso           | Sí         |
| CP03 | obtenerResultado  | 5.0     | Aprobado           | Aprobado           | Sí         |
| CP04 | obtenerResultado  | 6.9     | Notable            | Aprobado           | No         |
| CP05 | obtenerResultado  | 7.0     | Notable            | Notable            | Sí         |
| CP06 | obtenerResultado  | 8.9     | Notable            | Notable            | Sí         |
| CP07 | obtenerResultado  | 9.0     | Sobresaliente      | Sobresaliente      | Sí         |

# Parte 4 - Análisis de trazas

### Caso 1: precio = 10, cantidad = 5, socio = false

Inicio de compra
Total inicial: 50.0
Total final: 50.0

Devuelve 50.0.

### Caso 2: precio = 20, cantidad = 10, socio = true

Inicio de compra
Total inicial: 200.0
Aplicado descuento de socio
Aplicado descuento por compra alta
Total final: 171.0

Devuelve 171.0 (200 * 0.9 = 180, y 180 * 0.95 = 171).

### Caso 3: precio = 50, cantidad = 3, socio = true

Inicio de compra
Total inicial: 150.0
Aplicado descuento de socio
Aplicado descuento por compra alta
Total final: 128.25

Devuelve 128.25 (150 * 0.9 = 135, y 135 * 0.95 = 128.25).

### Caso 4: precio = 10, cantidad = 0, socio = false

Inicio de compra
Total inicial: 0.0
Error: cantidad inválida

Lanza IllegalArgumentException ("Cantidad inválida") y no llega a imprimir "Total final".

## Preguntas de análisis

### 1. ¿Se calcula el total antes de validar la cantidad?

Sí. El total se calcula en la línea `double total = precio * cantidad;` y los descuentos se aplican antes de comprobar si la cantidad es válida.

### 2. ¿Es correcto ese orden? Justifica.

No. Si la cantidad es 0 o negativa, no tiene sentido calcular el total ni aplicar descuentos porque al final se lanza una excepción. Se hace trabajo de más y se imprimen mensajes que pueden confundir.

### 3. ¿Qué problema puede provocar ese diseño?

Se imprimen por consola mensajes como "Total inicial: 0.0" o "Aplicado descuento..." antes de saber si los datos son válidos, lo que da información engañosa. Además, si hubiera operaciones más caras (escribir en base de datos, llamar a otro servicio...), se ejecutarían para nada antes de fallar.

### 4. ¿Dónde debería hacerse la validación?

Al principio del método, justo después del "Inicio de compra" y antes de calcular nada.

### 5. ¿Qué técnica de testing ayuda a detectar este tipo de errores?

Las pruebas de caja blanca, en concreto el análisis de trazas, porque permiten seguir el flujo del programa paso a paso y ver que la validación se hace en el sitio equivocado. También ayudan las pruebas unitarias con casos límite (cantidad = 0 o negativa).
