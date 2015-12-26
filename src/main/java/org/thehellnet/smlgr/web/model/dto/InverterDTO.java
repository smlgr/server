package org.thehellnet.smlgr.web.model.dto;

/**
 * Created by sardylan on 25/12/15.
 */
public class InverterDTO extends AbstractModelDTO {
    public String description;
    public String producer;
    public String model;
    public int maxPower;

    public InverterDTO() {
    }

    public InverterDTO(String description, String producer, String model, int maxPower) {
        this.description = description;
        this.producer = producer;
        this.model = model;
        this.maxPower = maxPower;
    }
}

