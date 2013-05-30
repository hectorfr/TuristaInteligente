/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.facade;

import com.turistainteligente.model.TipoPaqueteInt;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HectorFlechaRoja
 */
@Local
public interface TipoPaqueteIntFacadeLocal {

    void create(TipoPaqueteInt tipoPaqueteInt);

    void edit(TipoPaqueteInt tipoPaqueteInt);

    void remove(TipoPaqueteInt tipoPaqueteInt);

    TipoPaqueteInt find(Object id);

    List<TipoPaqueteInt> findAll();

    List<TipoPaqueteInt> findRange(int[] range);

    int count();
    
}
