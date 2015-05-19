package org.thehellnet.smlgr.web.model.dao;

import org.springframework.stereotype.Repository;
import org.thehellnet.smlgr.web.model.DataPayload;
import org.thehellnet.smlgr.web.model.Inverter;

/**
 * Created by sardylan on 16/05/15.
 */
@Repository
public class InverterDAO extends AbstractDAO<Inverter> {
    public InverterDAO() {
        setClazz(Inverter.class);
    }

}
