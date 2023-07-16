/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Nowll
 */
public class EspacoDAO {

    private EntityManager em;

    private EntityManager getEntityManager() {
        EntityManagerFactory fac = null;
        EntityManager em = null;
        try {
            fac = Persistence.createEntityManagerFactory("");
            em = fac.createEntityManager();
        } finally {
            fac.close();
        }
        return em;
    }

    public Espaco cadastroEspaco(Espaco e) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            if (e.getId() == null) {
                em.persist(e);
            }
            em.getTransaction().commit();

        } finally {
            em.close();
        }
        return e;
    }
    
    public void removeEspaco(Long id){
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Espaco e = consultaEspaco(id);
            em.remove(e);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }

    public Espaco consultaEspaco(Long id) {
        EntityManager em = getEntityManager();
        Espaco e = null;
        try {
            e = em.find(Espaco.class, id);
        } finally {
            em.close();
        }
        return e;
    }
           
    public void editEspaco(Espaco e) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(e);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
}
