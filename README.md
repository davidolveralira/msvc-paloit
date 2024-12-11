
# Technology API

Este proyecto es una API RESTful desarrollada en Java 21 utilizando Spring Boot. La API permite gestionar tecnologías mediante un CRUD (Create, Read, Update, Delete) y está documentada con Swagger para facilitar su uso.

##  Swagger UI
http://localhost:8001/swagger-ui.html

http://localhost:8001/swagger-ui/index.html



## **Tecnologías Usadas**
- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database**
- **Spring Security**
- **Swagger**

---

## **Configuración del Proyecto**

### **Pre-requisitos**
- Java 21
- Maven o Gradle
- IDE como IntelliJ IDEA, Eclipse o STS
- Postman (opcional para pruebas)

### **Instalación**
1. Clona el repositorio:
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd <NOMBRE_DEL_PROYECTO>
   ```

2. Configura la base de datos H2 en `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:h2:mem:testdb
   spring.datasource.driverClassName=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=password
   spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
   spring.h2.console.enabled=true
   ```

3. Compila y ejecuta el proyecto:
   ```bash
   ./mvnw spring-boot:run
   # o si usas Gradle
   ./gradlew bootRun
   ```

---

## **Endpoints Disponibles**

| Método HTTP | Endpoint                 | Descripción                     |
|-------------|--------------------------|---------------------------------|
| `GET`       | `/api/technologies`      | Obtener todas las tecnologías   |
| `GET`       | `/api/technologies/{id}` | Obtener tecnología por ID       |
| `POST`      | `/api/technologies`      | Crear una nueva tecnología      |
| `PUT`       | `/api/technologies/{id}` | Actualizar una tecnología       |
| `DELETE`    | `/api/technologies/{id}` | Eliminar una tecnología         |

---

## **Autenticación**
Esta API usa autenticación básica con Spring Security. Para acceder a los endpoints protegidos, utiliza las siguientes credenciales:

- **Usuario:** `user`
- **Contraseña:** `password`

---

## **Documentación con Swagger**
La API está documentada con Swagger para facilitar su exploración e interacción.

### **Acceder a la Documentación**
1. Inicia la aplicación.
2. Abre un navegador y ve a la URL:
   ```
   http://localhost:8080/swagger-ui/index.html
   ```

### **Ejemplo de Swagger Configuración**
```java
package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
```

---

## **Base de Datos H2**
Puedes acceder a la consola de la base de datos H2 para inspeccionar los datos:

- **URL:** `http://localhost:8080/h2-console`
- **Credenciales:**
  - JDBC URL: `jdbc:h2:mem:testdb`
  - Usuario: `sa`
  - Contraseña: `password`

---

## **Pruebas**
Puedes usar Postman o cualquier otra herramienta para interactuar con la API. Consulta la sección de Endpoints para más detalles.

---

## **Contribución**
Siéntete libre de enviar pull requests o abrir issues para mejorar este proyecto.
