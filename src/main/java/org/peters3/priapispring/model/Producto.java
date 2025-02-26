package org.peters3.priapispring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String nombre;

    @Column(nullable = false,length = 100)
    private String codigo;

    @Column(nullable = false,length = 100)
    private  String proveedor;

    @Column(length = 500)
    private String descripcion;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(nullable = false)
    private Integer stock;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;


    // info Constructor vacío requerido por JPA
    public Producto() {
    }
    // info Constructor con parámetros

    public Producto(Long id, String nombre, String codigo, String proveedor, String descripcion, BigDecimal precio, Integer stock, LocalDateTime fechaCreacion, LocalDateTime fechaActualizacion) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.proveedor = proveedor;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    // Getters y Setters (no uso Lombok como solicitado)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public BigDecimal getPrecio() {
        return precio;
    }
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }
    public void setFechaActualizacion(LocalDateTime
                                              fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getProvedor() {
        return proveedor;
    }

    public void setProvedor(String proveedor) {
        this.proveedor = proveedor;
    }

    // info Obtiene la Fecha Actual del Sistema

    //@Override
    //public String toString() {
//
    //    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    //    LocalDateTime now = LocalDateTime.now();
//
    //    return String.format("""
    //            Producto:
    //    Codigo:  %s
    //    Nombre: %s
    //    Provedor: %s
    //    Descripcion: %s
    //    Precio: %d
    //    Stock: %d
    //    Fecha de Creación: %s
    //    Fecha de Actualización: %s
    //    """,codigo, nombre, proveedor, descripcion, precio, stock,
    //            fechaCreacion != null ? fechaCreacion.format(formatter) : now.format(formatter),
    //            fechaActualizacion != null ? fechaActualizacion.format(formatter) : now.format(formatter));
    //}
}
