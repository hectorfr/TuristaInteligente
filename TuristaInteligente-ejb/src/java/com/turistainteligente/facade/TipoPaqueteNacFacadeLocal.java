/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.facade;

import com.turistainteligente.model.TipoPaqueteNac;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HectorFlechaRoja
 */
@Local
public interface TipoPaqueteNacFacadeLocal {

    void create(TipoPaqueteNac tipoPaqueteNac);

    void edit(TipoPaqueteNac tipoPaqueteNac);

    void remove(TipoPaqueteNac tipoPaqueteNac);

    TipoPaqueteNac find(Object id);

    List<TipoPaqueteNac> findAll();

    List<TipoPaqueteNac> findRange(int[] range);

    int count();
    
}
