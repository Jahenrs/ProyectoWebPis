/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entidades.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author henry
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "ProyectPsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public Usuario iniSesion(Usuario user){
        Usuario usuario = null;
        String consulta;
        
        try {
            consulta = "FROM Usuario u WHERE u.usuario =?1 and u.password =?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, user.getUsuario());
            query.setParameter(2, user.getPassword());
            List<Usuario> lista = query.getResultList();
            if (!lista.isEmpty()) {
                usuario = lista.get(0);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return usuario;
    }
    
    public UsuarioFacade() {
        super(Usuario.class);
    }
    
}
