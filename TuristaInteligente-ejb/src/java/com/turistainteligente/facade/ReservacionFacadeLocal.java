/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.facade;

import com.turistainteligente.model.Reservacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HectorFlechaRoja
 */
@Local
public interface ReservacionFacadeLocal {

    void create(Reservacion reservacion);

    void edit(Reservacion reservacion);

    void remove(Reservacion reservacion);

    Reservacion find(Object id);

    List<Reservacion> findAll();

    List<Reservacion> findRange(int[] range);

    int count();
    
}
