/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.facade;

import com.turistainteligente.model.ReservacionTarifaPaq;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HectorFlechaRoja
 */
@Stateless
public class ReservacionTarifaPaqFacade extends AbstractFacade<ReservacionTarifaPaq> implements ReservacionTarifaPaqFacadeLocal {
    @PersistenceContext(unitName = "TuristaInteligente-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReservacionTarifaPaqFacade() {
        super(ReservacionTarifaPaq.class);
    }
    
}
