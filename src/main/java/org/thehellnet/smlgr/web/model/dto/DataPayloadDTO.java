package org.thehellnet.smlgr.web.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.joda.time.DateTime;
import org.thehellnet.smlgr.web.serializer.DateTimeJsonSerializer;

/**
 * Created by sardylan on 25/12/15.
 */
public class DataPayloadDTO extends AbstractModelDTO {
    @JsonSerialize(using = DateTimeJsonSerializer.class)
    public DateTime dateTime;
    public int acPower;
    public int acVoltage;
    public int acCurrent;
    public int acFrequency;
    public int dc1Voltage;
    public int dc1Current;
    public int dc2Voltage;
    public int dc2Current;
    public int temperature;
    public int production;

    public DataPayloadDTO() {
    }

    public DataPayloadDTO(DateTime dateTime,
                          int acPower,
                          int acVoltage,
                          int acCurrent,
                          int acFrequency,
                          int dc1Voltage,
                          int dc1Current,
                          int dc2Voltage,
                          int dc2Current,
                          int temperature,
                          int production) {
        this.dateTime = dateTime;
        this.acPower = acPower;
        this.acVoltage = acVoltage;
        this.acCurrent = acCurrent;
        this.acFrequency = acFrequency;
        this.dc1Voltage = dc1Voltage;
        this.dc1Current = dc1Current;
        this.dc2Voltage = dc2Voltage;
        this.dc2Current = dc2Current;
        this.temperature = temperature;
        this.production = production;
    }
}
