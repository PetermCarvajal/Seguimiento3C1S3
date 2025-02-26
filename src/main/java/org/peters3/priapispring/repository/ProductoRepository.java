package org.peters3.priapispring.repository;

import org.peters3.priapispring.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto,
Long> {

// info para buscar productos por nombre (contiene)
List<Producto> findByNombreContainingIgnoreCase(String nombre);

// info para buscar productos con stock mayor a cierto valor
List<Producto> findByStockGreaterThan(Integer stockMinimo);

// info Metodo Para Buscar Según el provedor
//List<Producto> findByProveedorContainingIgnoreCase(String proveedor);
}

