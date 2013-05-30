/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.facade;

import com.turistainteligente.model.TipoPaqueteInt;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HectorFlechaRoja
 */
@Stateless
public class TipoPaqueteIntFacade extends AbstractFacade<TipoPaqueteInt> implements TipoPaqueteIntFacadeLocal {
    @PersistenceContext(unitName = "TuristaInteligente-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoPaqueteIntFacade() {
        super(TipoPaqueteInt.class);
    }
    
}
