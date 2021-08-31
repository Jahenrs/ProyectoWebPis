/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Entidades.Categoria;
import Entidades.Producto;
import Entidades.Proveedor;
import Sessions.ProductoFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author henry
 */
@Named(value = "mbProductos")
@SessionScoped
public class mbProductos implements Serializable {

    @EJB
    private ProductoFacadeLocal productoFacade;
    
    private BigDecimal idProducto;
    private String nombre;
    private BigInteger cantidad;
    private BigInteger precio;
    private BigInteger estado;
    private String descripcion;
    private BigInteger iva;
    private Categoria idCategoria;
    private Proveedor idProveedor;
    private Producto producto;
    /**
     * Creates a new instance of mbProductos
     */
    public mbProductos() {
    }
    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public void crearProducto(){
        try {
            productoFacade.create(producto);
        } catch (Exception ex) {
            System.out.println("el error es:" + ex.getMessage());
        }
    }
    
    @PostConstruct
    public void init() {
        producto = new Producto();
    }

    
    public BigDecimal getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(BigDecimal idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public BigInteger getPrecio() {
        return precio;
    }

    public void setPrecio(BigInteger precio) {
        this.precio = precio;
    }

    public BigInteger getEstado() {
        return estado;
    }

    public void setEstado(BigInteger estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigInteger getIva() {
        return iva;
    }

    public void setIva(BigInteger iva) {
        this.iva = iva;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    
}
