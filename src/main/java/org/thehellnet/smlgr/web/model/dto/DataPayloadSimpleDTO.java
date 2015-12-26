package org.thehellnet.smlgr.web.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.joda.time.DateTime;
import org.thehellnet.smlgr.web.serializer.DateTimeJsonSerializer;

/**
 * Created by sardylan on 25/12/15.
 */
public class DataPayloadSimpleDTO extends AbstractModelDTO {
    @JsonSerialize(using = DateTimeJsonSerializer.class)
    public DateTime dateTime;
    public int acPower;

    public DataPayloadSimpleDTO() {
    }

    public DataPayloadSimpleDTO(DateTime dateTime, int acPower) {
        this.dateTime = dateTime;
        this.acPower = acPower;
    }
}
