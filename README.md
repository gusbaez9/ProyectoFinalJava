# Product API (Spring Boot)

API REST simple para gestionar **Productos** (CRUD) usando Spring Boot, JPA y H2 en memoria.

## Requisitos
- Java 17+
- Maven

## Ejecutar
1. Compilar y ejecutar:
```bash
mvn spring-boot:run
```
2. La API quedará disponible en `http://localhost:8080/api/products`

## Endpoints
- `GET /api/products` - Listar todos
- `GET /api/products/{id}` - Obtener por id
- `POST /api/products` - Crear (body JSON)
- `PUT /api/products/{id}` - Actualizar (body JSON)
- `DELETE /api/products/{id}` - Eliminar

## Ejemplo JSON (crear/actualizar)
```json
{
  "name": "Notebook Lenovo",
  "price": 1500.0,
  "stock": 10
}
```

## H2 Console
La consola H2 está habilitada en `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- Usuario: `sa`
- Contraseña: (vacía)

## Subir a Git
1. Inicializá el repo:
```bash
git init
git add .
git commit -m "Initial product-api project"
```
2. Crear repo en GitHub y subir:
```bash
git remote add origin <url-del-repo>
git branch -M main
git push -u origin main
```

Listo — si querés, te genero un README más formal o agrego Dockerfile / GitHub Actions.
