/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.facade;

import com.turistainteligente.model.Hotel;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HectorFlechaRoja
 */
@Local
public interface HotelFacadeLocal {

    void create(Hotel hotel);

    void edit(Hotel hotel);

    void remove(Hotel hotel);

    Hotel find(Object id);

    List<Hotel> findAll();

    List<Hotel> findRange(int[] range);

    int count();
    
}
