/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.facade;

import com.turistainteligente.model.TarifaNeta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HectorFlechaRoja
 */
@Local
public interface TarifaNetaFacadeLocal {

    void create(TarifaNeta tarifaNeta);

    void edit(TarifaNeta tarifaNeta);

    void remove(TarifaNeta tarifaNeta);

    TarifaNeta find(Object id);

    List<TarifaNeta> findAll();

    List<TarifaNeta> findRange(int[] range);

    int count();
    
}
