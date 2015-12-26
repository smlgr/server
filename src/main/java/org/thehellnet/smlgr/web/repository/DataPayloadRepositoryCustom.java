package org.thehellnet.smlgr.web.repository;

import org.joda.time.DateTime;
import org.thehellnet.smlgr.web.model.Inverter;

/**
 * Created by sardylan on 26/12/15.
 */
public interface DataPayloadRepositoryCustom {

    public DateTime findFirstDateTimeByInverter(Inverter inverter);

    public DateTime findLastDateTimeByInverter(Inverter inverter);
}
