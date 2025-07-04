# Currency-Converter

¡Bienvenido a Currency-Converter!  
Este proyecto es una aplicación de consola en Java que permite consultar tasas de cambio y convertir montos entre distintas monedas utilizando datos actualizados en tiempo real.

## 🚀 Funcionalidades principales

- **Consulta de tasas de conversión actualizadas**  
  Obtén el valor actualizado de más de 160 monedas distintas usando una API pública.
- **Conversión entre distintas divisas**  
  Calcula cuánto obtendrías al convertir un monto específico de una moneda a otra.
- **Interfaz interactiva por consola**  
  La aplicación guía al usuario con menús y preguntas para realizar las operaciones de manera sencilla.

## 🖥️ ¿Cómo funciona?

Al iniciar la aplicación, verás un menú con las siguientes opciones:

1. **Consultar tasas de una divisa frente a todas las demás:**  
   Ingresa el código de la moneda base (por ejemplo, USD, EUR, COP) y obtendrás una lista de tasas de cambio frente a todas las monedas soportadas.

2. **Convertir un monto entre dos divisas:**  
   Ingresa la moneda de origen y destino, introduce la cantidad a convertir, y la aplicación te mostrará el monto equivalente usando la tasa actual.

3. **Salir:**  
   Cierra la aplicación.

## ⚙️ Tecnologías utilizadas

- **Java** (consola)
- **API pública [ExchangeRate-API](https://www.exchangerate-api.com/)** para obtener tasas de cambio en tiempo real
- **Gson** para parsear las respuestas JSON

## 📦 Estructura del proyecto

```
src/
└── com/alura_challenge_2/
    ├── main/
    │   └── Main.java        // Lógica principal e interacción con el usuario
    └── modulo/
        ├── API.java        // Lógica para consumir la API de tasas de cambio
        └── Dates.java      // Modelo para mapear datos de la API
```

## 🛠️ Ejecución

1. Clona este repositorio:
   ```bash
   git clone https://github.com/YmidOrtega/Currency-Converter.git
   ```
2. Compila el código:
   ```bash
   javac -cp ".:ruta/a/gson.jar" src/com/alura_challenge_2/main/Main.java
   ```
3. Ejecuta la aplicación:
   ```bash
   java -cp ".:ruta/a/gson.jar:src" com.alura_challenge_2.main.Main
   ```

## 💡 Ejemplo de uso

```
¡Bienvenido a tu convertidor de divisas de confianza!
1. Conocer el valor de las tasas de conversión de una divisa frente a todas los demás.
2. Conocer el valor de cambio de una divisa frente a otra divisa.
3. Salir
```

## 📝 Notas

- Es necesario tener acceso a internet para consultar las tasas de cambio.
- El proyecto puede ser extendido fácilmente para agregar nuevas funcionalidades, como guardar históricos de conversiones, soportar más idiomas, o agregar una interfaz gráfica.

---

Desarrollado por [YmidOrtega](https://github.com/YmidOrtega).
