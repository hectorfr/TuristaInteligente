/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.facade;

import com.turistainteligente.model.ReservacionProveedor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HectorFlechaRoja
 */
@Local
public interface ReservacionProveedorFacadeLocal {

    void create(ReservacionProveedor reservacionProveedor);

    void edit(ReservacionProveedor reservacionProveedor);

    void remove(ReservacionProveedor reservacionProveedor);

    ReservacionProveedor find(Object id);

    List<ReservacionProveedor> findAll();

    List<ReservacionProveedor> findRange(int[] range);

    int count();
    
}
