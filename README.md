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
