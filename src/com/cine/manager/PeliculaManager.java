/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cine.manager;

import com.cine.entities.Peliculas;
import com.cine.managementDAO.ManagerDAO;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexs
 */
public class PeliculaManager {
    private final ManagerDAO managerDAO = new ManagerDAO();
    
    public void insertarPelicula(Peliculas pelis) throws Exception{
        managerDAO.insertar(pelis);
    }
    
    public List<Peliculas> listarPeliculas(){
        return managerDAO.findAll(Peliculas.class, "o.nombre DESC");
    }
    
    public void buscarPeliculaById(BigDecimal id){
        try {
            managerDAO.findById(Peliculas.class, id);
        } catch (Exception ex) {
            Logger.getLogger(PeliculaManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void actualizarPeliculas(Peliculas pelis) throws Exception{
        managerDAO.updateObject(pelis);
    }
    
    public void eliminarPelicula(BigDecimal id) throws Exception{
        managerDAO.deleteObject(Peliculas.class, id);
    }
    
}
