/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cine.manager;

import com.cine.entities.Actor;
import com.cine.managementDAO.ManagerDAO;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author alexs
 */
public class ActorManager {
    ManagerDAO managerDAO = new ManagerDAO();
    
    public void guardarActor(Actor actor) throws Exception{
        
        managerDAO.insertar(actor);
    }
    
    public List<Actor> getListaActores(){
       return managerDAO.findAll(Actor.class, "o.apellido DESC");    
    }
    
    public Actor buscarPorID(BigDecimal id) throws Exception{
        return (Actor) managerDAO.findById(Actor.class, id);
    }
    
    public void actualizarActor(Actor actor) throws Exception{
        managerDAO.updateObject(actor);
    }
    public void eliminarActor(BigDecimal id) throws Exception{
        managerDAO.deleteObject(Actor.class, id);
    }
}
