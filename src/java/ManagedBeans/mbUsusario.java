/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Entidades.Usuario;
import Sessions.UsuarioFacadeLocal;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author henry
 */
@Named(value = "mbUsusario")
@SessionScoped
public class mbUsusario implements Serializable{
    
    @EJB
    private UsuarioFacadeLocal usuarioFacade;
    private BigDecimal idUsuario;
    private String nombres;
    private String apellidos;
    private String cedula;
    private String celular;
    private String email;
    private String usuario;
    private String password;
    private BigInteger tipoCuenta;
    private Usuario user;
    
    /**
     * Creates a new instance of mbUsusario
     */
    public mbUsusario() {
    }
    
    public void registrarse(){
        try {
            usuarioFacade.create(user);
        } catch (Exception ex) {
            System.out.println("el error es:" + ex.getMessage());
        }
    }
    @PostConstruct
    public void init() {
        user = new Usuario();
    }
    
    public String iniciar(){
        Usuario user;
        String redirec = null;
        try {
            Usuario userc = new Usuario();
            userc.setUsuario(this.getUsuario());
            userc.setPassword(this.getPassword());
            user = usuarioFacade.iniSesion(userc);
            if (user != null) {
                if (user.getUsuario().equals("antonio") && user.getPassword().equals("123")) {
                    redirec = "Facturacion.xhtml";
                } else{
                    redirec = "Catalogo.xhtml";
                }
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Aviso","Error"));
            }
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error"));
        }
        
        return redirec;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    

    public BigDecimal getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigInteger getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(BigInteger tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
    
    
    
}
