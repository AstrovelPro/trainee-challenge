
# Desafío para Trainees de Astrovel

## Introducción

Esta es una aplicación basada en Kotlin que utiliza el framework Spring Boot. La aplicación está estructurada utilizando una arquitectura en capas típica, con paquetes separados para diferentes capas como core y rest.

Si bien el proyecto esta en Kotlin tambien podes agregar el codigo en Java.

## Requisitos Previos

- Java 21
- Gradle
- Docker

## Ejecutar la aplicación

```
./gradlew build
```

```
docker build -t desafio-practicante-astrovel .
```

```
docker run -p 8080:8080 desafio-practicante-astrovel
```

## Información del Desafío

El desafío tiene 3 niveles:

1. **Agregar una nueva entidad Transacción** para guardar transacciones (y agregar datos de prueba).
2. **Agregar un endpoint \`stats\`** que devuelva el siguiente JSON, pero con estadísticas reales:

```json
[{
  "country": "Argentina",
  "market": [{
    "MAE": {
      "percentage": "80.75"
    },
    "ROFEX": {
      "percentage": "2.00"
    }
  }]
}, {
  "country": "Uruguay",
  "market": [{
    "UFEX": {
      "percentage": "17.25"
    }
  }]
}]
```

3. **Desplegar la aplicación** en algún lugar utilizando Docker. Se recomienda usar fly.io por su simplicidad.

### Aspectos que suman puntos

- Pruebas unitarias.
- Código limpio.
