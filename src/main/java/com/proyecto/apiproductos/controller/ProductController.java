package com.proyecto.apiproductos.controller;

import com.proyecto.apiproductos.model.Producto;
import com.proyecto.apiproductos.repository.ProductRepository;
import com.proyecto.apiproductos.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Producto> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Producto getById(@PathVariable Long id) {
        return repository.findById(id)
        		.orElseThrow(() -> new ProductNotFoundException(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> create(@RequestBody Producto producto) {
        Producto saved = repository.save(producto);

        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "Producto creado exitosamente");
        response.put("producto", saved);

        return response;
    }

    @PutMapping("/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody Producto producto) {
        Producto existing = repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        existing.setName(producto.getName());
        existing.setPrice(producto.getPrice());
        existing.setStock(producto.getStock());

        Producto updated = repository.save(existing);

        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "Producto actualizado correctamente");
        response.put("producto", updated);

        return response;
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }

        repository.deleteById(id);

        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "Producto eliminado exitosamente");

        return response;
    }
}
