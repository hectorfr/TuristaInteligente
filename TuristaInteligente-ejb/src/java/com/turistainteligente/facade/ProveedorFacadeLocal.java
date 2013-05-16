/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.facade;

import com.turistainteligente.model.Proveedor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HectorFlechaRoja
 */
@Local
public interface ProveedorFacadeLocal {

    void create(Proveedor proveedor);

    void edit(Proveedor proveedor);

    void remove(Proveedor proveedor);

    Proveedor find(Object id);

    List<Proveedor> findAll();

    List<Proveedor> findRange(int[] range);

    int count();
    
}
