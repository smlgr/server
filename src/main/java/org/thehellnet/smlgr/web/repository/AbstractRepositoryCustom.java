package org.thehellnet.smlgr.web.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * Created by sardylan on 26/12/15.
 */
@Transactional
public abstract class AbstractRepositoryCustom {

    protected EntityManager entityManager;

    @Autowired
    public void setEntityManager(EntityManager em) {
        entityManager = em;
    }
}
