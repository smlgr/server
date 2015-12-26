package org.thehellnet.smlgr.web.controller.api.dto.request;

import org.joda.time.DateTime;

/**
 * Created by sardylan on 25/12/15.
 */
public class InverterPayloadRequestDTOApi extends AbstractApiRequestDTO {
    public DateTime timestamp;
    public String tag;
    public String token;
    public int ac_power;
    public int ac_voltage;
    public int ac_current;
    public int ac_frequency;
    public int dc1_voltage;
    public int dc1_current;
    public int dc2_voltage;
    public int dc2_current;
    public int temperature;
    public int production;
}
