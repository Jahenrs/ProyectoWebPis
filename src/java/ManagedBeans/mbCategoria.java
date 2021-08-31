/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Entidades.Categoria;
import Entidades.Producto;
import Sessions.CategoriaFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author henry
 */
@Named(value = "mbCategoria")
@SessionScoped
public class mbCategoria implements Serializable {

    @EJB
    private CategoriaFacadeLocal categoriaFacade;
    
    private BigDecimal idCategoria;
    private String nombre;
    private List<Producto> productoList;
    /**
     * Creates a new instance of mbCategoria
     */
    public mbCategoria() {
    }
    
    public List<Categoria> getLstCategoria(){
        return categoriaFacade.findAll();
    }

    public BigDecimal getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(BigDecimal idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }
    
    
    
}
