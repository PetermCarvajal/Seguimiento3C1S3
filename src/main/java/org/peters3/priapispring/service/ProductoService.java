package org.peters3.priapispring.service;

import org.peters3.priapispring.model.Producto;
import java.util.List;
import java.util.Optional;

public interface ProductoService {

// obs Crear un producto
Producto guardarProducto(Producto producto);

// obs Actualizar un producto existente
Producto actualizarProducto(Long id, Producto producto);

// obs Obtener todos los productos
List<Producto> obtenerTodosLosProductos();

// obs Obtener un producto por su ID
Optional<Producto> obtenerProductoPorId(Long id);

// obs Eliminar un producto
void eliminarProducto(Long id);

// obs Buscar productos por nombre
List<Producto> buscarProductosPorNombre(String nombre);

// obs Buscar productos con stock disponible (mayor a cero)
List<Producto> obtenerProductosConStock(Integer stockMinimo);

}

