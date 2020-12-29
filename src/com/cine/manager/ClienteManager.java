/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cine.manager;

import com.cine.entities.Cliente;
import com.cine.managementDAO.ManagerDAO;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author alexs
 */
public class ClienteManager {
 private final ManagerDAO managerDAO = new ManagerDAO();
    
    public void insertarCliente(Cliente cliente) throws Exception{     
        managerDAO.insertar(cliente);
    }
    
    public List<Cliente> obtenerClientes(){
        return  managerDAO.findAll(Cliente.class, "o.apellidos DESC");
    }
    
    public Cliente buscarByID(BigDecimal id) throws Exception{
        return (Cliente) managerDAO.findById(Cliente.class, id);
    }
    
    public void actualizarCliente(Object objeto) throws Exception{
        managerDAO.updateObject(objeto);
    }
    
    public void eliminarCliente(String id) throws Exception{
        managerDAO.deleteObject(Cliente.class, id);
    }
    
    
}
