/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.UTS;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author DarkDragon
 */
@Stateless
public class UTSEJB implements UTSLocal {
    
    @PersistenceContext(unitName = "ServiciosSocialesPU")
    private EntityManager em;
    
    @Override
    public boolean insertar(UTS uts) {
        if (uts == null) return false;
        try {
            em.persist(uts);
        } catch (Exception e){
            return false;
        }
        return true;
    }
    
    @Override
    public boolean eliminar(UTS uts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UTS> getUTSs() {
         return em.createQuery("SELECT a FROM UTS a", UTS.class).getResultList();
    }
}