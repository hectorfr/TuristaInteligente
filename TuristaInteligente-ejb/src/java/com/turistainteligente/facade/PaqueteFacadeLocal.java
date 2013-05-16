/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.facade;

import com.turistainteligente.model.Paquete;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HectorFlechaRoja
 */
@Local
public interface PaqueteFacadeLocal {

    void create(Paquete paquete);

    void edit(Paquete paquete);

    void remove(Paquete paquete);

    Paquete find(Object id);

    List<Paquete> findAll();

    List<Paquete> findRange(int[] range);

    int count();
    
}
