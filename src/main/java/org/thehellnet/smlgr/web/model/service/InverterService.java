package org.thehellnet.smlgr.web.model.service;

import org.thehellnet.smlgr.web.model.Inverter;
import org.thehellnet.smlgr.web.model.dao.IDAO;

/**
 * Created by sardylan on 16/05/15.
 */
public interface InverterService extends IDAO<Inverter> {
    public Inverter findByIdAndToken(long inverterId, String token);
}
