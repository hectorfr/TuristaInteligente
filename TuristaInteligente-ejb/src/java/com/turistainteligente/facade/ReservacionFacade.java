/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.facade;

import com.turistainteligente.model.Reservacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HectorFlechaRoja
 */
@Stateless
public class ReservacionFacade extends AbstractFacade<Reservacion> implements ReservacionFacadeLocal {
    @PersistenceContext(unitName = "TuristaInteligente-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReservacionFacade() {
        super(Reservacion.class);
    }
    
}
