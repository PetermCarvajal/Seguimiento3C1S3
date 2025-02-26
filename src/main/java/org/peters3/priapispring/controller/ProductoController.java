package org.peters3.priapispring.controller;

import jakarta.persistence.EntityNotFoundException;
import org.peters3.priapispring.model.Producto;
import org.peters3.priapispring.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@RestController // ! Controller y @ResponseBody
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
    Producto nuevoProducto = productoService.guardarProducto(producto);
    return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Producto>> obtenerTodosLosProductos() {
    return new ResponseEntity<>(productoService.obtenerTodosLosProductos(),
    HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id) {
    return productoService.obtenerProductoPorId(id)
    .map(producto -> new ResponseEntity<>(producto, HttpStatus.OK))
    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(
    @PathVariable Long id,
    @RequestBody Producto producto) {
    try {
    Producto actualizado = productoService.actualizarProducto(id, producto);
    return new ResponseEntity<>(actualizado, HttpStatus.OK);
    } catch (EntityNotFoundException e) {
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarProducto(@PathVariable Long id) {
    try {
    productoService.eliminarProducto(id);
    return new ResponseEntity<>(Map.of("eliminado", true), HttpStatus.OK);
    } catch (EntityNotFoundException e) {
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Producto>> buscarProductos(
    @RequestParam String nombre) {
    return new ResponseEntity<>(
    productoService.buscarProductosPorNombre(nombre),
    HttpStatus.OK
    );

    }

    @GetMapping("/con-stock")
    public ResponseEntity<List<Producto>> obtenerProductosConStock(
    @RequestParam(defaultValue = "0") Integer stockMinimo) {
    return new ResponseEntity<>(
    productoService.obtenerProductosConStock(stockMinimo),
    HttpStatus.OK
    );

    }

}
