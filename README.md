# VISIOCART - Backend API 🛒🤖

API RESTful desarrollada en **Spring Boot** para el sistema de carrito de compras inteligente **VISIOCART**. El sistema permite la gestión del catálogo de productos y el procesamiento de ventas en tiempo real mediante un flujo transaccional Maestro-Detalle.

---

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java 17+
* **Framework:** Spring Boot (Spring Web, Spring Data JPA)
* **Base de Datos:** MySQL 8.0
* **Gestor de Dependencias:** Maven
* **Servidor de Aplicaciones:** Apache Tomcat integrado (Puerto `8081`)
* **Herramienta de Pruebas:** Postman

---

## 🗄️ Modelo de Base de Datos

El núcleo transaccional del sistema está estructurado en 3 tablas principales:

1. **`PRODUCTO`**: Almacena el catálogo de artículos disponibles (nombre, precio, peso esperado, categoría).
2. **`TRANSACCION`**: Registra la cabecera de la compra (cliente, empleado/cajero, fecha/hora y total neto calculado).
3. **`DETALLE_TRANSACCION`**: Tabla intermedia con clave primaria compuesta (`@Embeddable`) que vincula los productos comprados con su respectiva transacción, guardando cantidad y precio unitario al momento de la venta.

---

## ⚙️ Configuración del Entorno

### 1. Base de Datos
Asegúrate de tener creada la base de datos en MySQL Workbench:
```sql
CREATE DATABASE visiocart_db;

🚀 Endpoints de la API📦 Gestión de Productos (/api/productos)MétodoEndpointDescripciónGET/api/productosObtener la lista completa de productosGET/api/productos/{id}Consultar un producto específico por su IDPOST/api/productosRegistrar un nuevo producto en el catálogoPUT/api/productos/{id}Actualizar un producto existenteDELETE/api/productos/{id}Eliminar un producto del catálogo💳 Flujo Transaccional de Compra (/api/transacciones)MétodoEndpointDescripciónPOST/api/transaccionesProcesar una compra multi-producto y calcular el total automáticamente🧪 Ejemplos de Peticiones (Postman)Nota: Todas las peticiones POST y PUT requieren el encabezado Content-Type: application/json y el encabezado Host: localhost:8081 activo.1. Crear Producto (POST /api/productos)JSON{
  "nombre": "Leche Entera 1L",
  "precioCatalogo": 4200.00,
  "pesoEsperado": 1030.5,
  "idCategoria": 1
}
2. Actualizar Producto (PUT /api/productos/1)JSON{
  "nombre": "Leche Entera 1L (Oferta)",
  "precioCatalogo": 3900.00,
  "pesoEsperado": 1030.5,
  "idCategoria": 1
}
3. Registrar Transacción Multi-Producto (POST /api/transacciones)JSON{
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
👥 AutorRamsés Arnold Meneses Proyecto Académico - VISIOCART 2026
