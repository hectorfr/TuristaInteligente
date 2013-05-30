/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.facade;

import com.turistainteligente.model.TarifaHabitacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HectorFlechaRoja
 */
@Local
public interface TarifaHabitacionFacadeLocal {

    void create(TarifaHabitacion tarifaHabitacion);

    void edit(TarifaHabitacion tarifaHabitacion);

    void remove(TarifaHabitacion tarifaHabitacion);

    TarifaHabitacion find(Object id);

    List<TarifaHabitacion> findAll();

    List<TarifaHabitacion> findRange(int[] range);

    int count();
    
}
