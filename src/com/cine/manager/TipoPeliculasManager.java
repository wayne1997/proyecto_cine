/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cine.manager;

import com.cine.entities.TipoPelicula;
import com.cine.managementDAO.ManagerDAO;
import java.util.List;

/**
 *
 * @author alexs
 */
public class TipoPeliculasManager {
    
    private final ManagerDAO manager = new ManagerDAO();
    
    public List<TipoPelicula> listarTipos(){
        return manager.findAll(TipoPelicula.class, "o.tipo DESC");
    }
}
