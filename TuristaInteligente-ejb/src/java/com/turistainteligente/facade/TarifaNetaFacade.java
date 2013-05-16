/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.facade;

import com.turistainteligente.model.TarifaNeta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HectorFlechaRoja
 */
@Stateless
public class TarifaNetaFacade extends AbstractFacade<TarifaNeta> implements TarifaNetaFacadeLocal {
    @PersistenceContext(unitName = "TuristaInteligente-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TarifaNetaFacade() {
        super(TarifaNeta.class);
    }
    
}
