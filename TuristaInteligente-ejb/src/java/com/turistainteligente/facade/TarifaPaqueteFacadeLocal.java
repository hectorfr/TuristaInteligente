/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.facade;

import com.turistainteligente.model.TarifaPaquete;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HectorFlechaRoja
 */
@Local
public interface TarifaPaqueteFacadeLocal {

    void create(TarifaPaquete tarifaPaquete);

    void edit(TarifaPaquete tarifaPaquete);

    void remove(TarifaPaquete tarifaPaquete);

    TarifaPaquete find(Object id);

    List<TarifaPaquete> findAll();

    List<TarifaPaquete> findRange(int[] range);

    int count();
    
}
