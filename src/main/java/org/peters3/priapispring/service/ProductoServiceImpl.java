package org.peters3.priapispring.service;

import jakarta.transaction.Transactional;
import org.peters3.priapispring.model.Producto;
import org.peters3.priapispring.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import jakarta.persistence.EntityNotFoundException;


@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // info Crear producto
    @Override
    @Transactional
    public Producto guardarProducto(Producto producto) {
        if (producto.getFechaCreacion() == null) {
            producto.setFechaCreacion(LocalDateTime.now());
        }
        producto.setFechaActualizacion(LocalDateTime.now());
        return productoRepository.save(producto);
    }

    // info Obtener producto por ID
    @Override
    @Transactional
    public Optional<Producto> obtenerProductoPorId(Long id) {
        return productoRepository.findById(id);
    }

    // info Actualizar producto
    @Override
    @Transactional
    public Producto actualizarProducto(Long id, Producto productoActualizado) {
        return productoRepository.findById(id)
                .map(productoExistente -> {
                    // Actualiza los campos necesarios aquí
                    productoExistente.setNombre(productoActualizado.getNombre());
                    productoExistente.setDescripcion(productoActualizado.getDescripcion());
                    productoExistente.setPrecio(productoActualizado.getPrecio());
                    productoExistente.setStock(productoActualizado.getStock());
                    productoExistente.setFechaActualizacion(LocalDateTime.now());
                    return productoRepository.save(productoExistente);
                })
                .orElseThrow(EntityNotFoundException::new);
    }

    // info Eliminar producto
    @Override
    @Transactional
    public void eliminarProducto(Long id) {
        if (!productoRepository.existsById(id)) {
            throw new EntityNotFoundException();
        }
        productoRepository.deleteById(id);
    }

    // info Buscar productos por nombre
    @Override
    @Transactional
    public List<Producto> buscarProductosPorNombre(String nombre) {
        return productoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    // info Obtener productos con stock mínimo
    @Override
    @Transactional
    public List<Producto> obtenerProductosConStock(Integer stockMinimo) {
        return productoRepository.findByStockGreaterThan(stockMinimo);
    }

    @Override
    @Transactional
    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }
}