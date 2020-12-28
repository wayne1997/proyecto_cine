
package com.cine.managementDAO;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ManagerDAO {
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public ManagerDAO(){
        crearEntityManager();
    }
    
    private EntityManager crearEntityManager() {
        emf = Persistence.createEntityManagerFactory("ProyectoCinePU");//nombre de la persistencia a utilizar
        em = emf.createEntityManager();
        return em;
    }
    public void insertar(Object pObjeto) throws Exception {
        if (pObjeto == null) {
            throw new Exception("No se puede insertar un objeto null.");
        }
        try {
            EntityManager em = crearEntityManager();
            EntityTransaction etx = em.getTransaction();
            etx.begin();
            em.persist(pObjeto);
            etx.commit();
            System.out.println("Dato insertado");
        } catch (Exception e) {
            throw new Exception("No se pudo insertar el objeto especificado: " + e.getMessage());
        }
    }
    
    public List findAll(Class clase, String orderBy){
           Query q;
           List listado;
           String sentenciaSQL;
           if(orderBy == null || orderBy.length() == 0){
               sentenciaSQL = "SELECT o FROM " + clase.getSimpleName() + " o";
           }else{
               sentenciaSQL = "SELECT o FROM " + clase.getSimpleName() + " o ORDER BY "+ orderBy;
           }
           q = em.createQuery(sentenciaSQL);
           listado = q.getResultList();
           return listado;
    }
    
    public Object findById(Class clase, Object objID) throws Exception{
    
        if(objID == null) throw new Exception("Id de usuario nulo");
        Object o;
        
        try{
         o = em.find(clase, objID);
        }
        catch(Exception e){
            throw new Exception("Error al buscar la información especificada ("+objID+") : "+e.getMessage());
        }
       
        return o;
    }
    
    public void updateObject(Object obj) throws Exception{
        if(obj == null) throw new Exception("No se pueden insertar datos nulos");
        try{
           em.getTransaction().begin();
           em.merge(obj);
           em.getTransaction().commit();
            System.out.println("Usuario actualizado");
        }catch(Exception e){
            throw new Exception("No se puede actualizar el campo: " + e.getMessage());
        }
    }
    
    public void deleteObject(Class clase, Object id) throws Exception{
        if(id == null) throw new Exception("No se puede eleminar con un id nulo");
        Object o = findById(clase, id);
        try{
            em.getTransaction().begin();
            em.remove(o);
            em.getTransaction().commit();
            System.out.println("Dato eliminado");
        }catch(Exception e){
            throw new Exception("No se puede eleminar el objeto por: " + e.getMessage());
        }
    }
}
