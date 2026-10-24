# 🛒🤖 VISIOCART - Backend API

> API RESTful desarrollada con **Spring Boot** y **MySQL** para el sistema de carrito de compras inteligente **VISIOCART**. Gestiona el catálogo de productos y procesa ventas mediante un flujo transaccional Maestro-Detalle.

---

## 🛠️ Tecnologías y Herramientas

| Tecnología | Descripción |
| :--- | :--- |
| **Java 17+** | Lenguaje de programación principal |
| **Spring Boot 3** | Framework backend (Spring Web, Spring Data JPA) |
| **MySQL 8.0** | Base de datos relacional |
| **Hibernate / ORM** | Mapeo objeto-relacional |
| **Maven** | Gestor de dependencias y construcción |
| **Tomcat** | Servidor web embebido (Puerto `8081`) |
| **Postman** | Cliente de pruebas de arquitectura API |

---

## 🗄️ Modelo de Datos (3 Tablas)

El diseño del backend sigue un enfoque simplificado de **3 tablas clave** para el control de inventario y facturación:

1. **`PRODUCTO`**: Catálogo de ítems disponibles (precio de catálogo, peso esperado en gramos e ID de categoría).
2. **`TRANSACCION`**: Cabecera de venta (asociada a cliente y cajero, almacena fecha/hora y total neto).
3. **`DETALLE_TRANSACCION`**: Tabla intermedia con clave compuesta (`@Embeddable`) que vincula ítems a transacciones con su cantidad y precio histórico.

---

## ⚙️ Configuración del Proyecto

### 1. Preparación de la Base de Datos
Ejecuta la creación del esquema en **MySQL Workbench**:
```sql
CREATE DATABASE visiocart_db;
```

### 2. Variables de Entorno (`application.properties`)
Verifica la configuración en `src/main/resources/application.properties`:

```properties
server.port=8081

spring.datasource.url=jdbc:mysql://localhost:3306/visiocart_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=TU_CONTRASEÑA_AQUI

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## 🚀 Endpoints de la API

### 📦 Módulo de Productos (`/api/productos`)

| Método | Ruta | Descripción |
| :---: | :--- | :--- |
| `GET` | `/api/productos` | Obtener catálogo completo de productos |
| `GET` | `/api/productos/{id}` | Buscar producto por ID |
| `POST` | `/api/productos` | Crear un nuevo producto en catálogo |
| `PUT` | `/api/productos/{id}` | Actualizar datos de un producto |
| `DELETE` | `/api/productos/{id}` | Eliminar producto por ID |

### 💳 Módulo Transaccional (`/api/transacciones`)

| Método | Ruta | Descripción |
| :---: | :--- | :--- |
| `POST` | `/api/transacciones` | Procesar compra multi-producto y calcular `totalNeto` |

---

## 🧪 Estructura de Peticiones en Postman

> ⚠️ **Importante:** Asegúrate de incluir el encabezado `Content-Type: application/json` y tener habilitado el header `Host` en Postman.

### 1. Registrar Producto (`POST /api/productos`)
```json
{
  "nombre": "Leche Entera 1L",
  "precioCatalogo": 4200.00,
  "pesoEsperado": 1030.5,
  "idCategoria": 1
}
```

### 2. Actualizar Producto (`PUT /api/productos/1`)
```json
{
  "nombre": "Leche Entera 1L (Oferta)",
  "precioCatalogo": 3900.00,
  "pesoEsperado": 1030.5,
  "idCategoria": 1
}
```

### 3. Registrar Compra Multi-Producto (`POST /api/transacciones`)
```json
{
  "idCliente": 1,
  "idEmpleado": 1,
  "items": [
    {
      "idProducto": 1,
      "cantidad": 2
    },
    {
      "idProducto": 5,
      "cantidad": 3
    }
  ]
}
```

---

## 👤 Autor

* **Ramsés Arnald Meneses**
* **Proyecto Académico:** VISIOCART 2026
