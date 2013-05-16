/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.facade;

import com.turistainteligente.model.ReservacionTarifaPaq;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HectorFlechaRoja
 */
@Local
public interface ReservacionTarifaPaqFacadeLocal {

    void create(ReservacionTarifaPaq reservacionTarifaPaq);

    void edit(ReservacionTarifaPaq reservacionTarifaPaq);

    void remove(ReservacionTarifaPaq reservacionTarifaPaq);

    ReservacionTarifaPaq find(Object id);

    List<ReservacionTarifaPaq> findAll();

    List<ReservacionTarifaPaq> findRange(int[] range);

    int count();
    
}
