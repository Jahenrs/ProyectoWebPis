/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Entidades.Producto;
import Entidades.Proveedor;
import Sessions.ProveedorFacadeLocal;
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
@Named(value = "mbProveedor")
@SessionScoped
public class mbProveedor implements Serializable {

    @EJB
    private ProveedorFacadeLocal proveedorFacade;
    
    private BigDecimal idProveedor;
    private String empresa;
    private String vendedor;
    private String telefono;
    private String email;
    private List<Producto> productoList;
    /**
     * Creates a new instance of mbProveedor
     */
    public mbProveedor() {
    }
    
     public List<Proveedor> getLstProveedor(){
        return proveedorFacade.findAll();
    }

    public BigDecimal getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(BigDecimal idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }
    
    
    
}
