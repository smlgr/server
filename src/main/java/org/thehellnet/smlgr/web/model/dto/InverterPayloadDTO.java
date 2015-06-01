package org.thehellnet.smlgr.web.model.dto;

import java.io.Serializable;

/**
 * Created by sardylan on 30/05/15.
 */
public class InverterPayloadDTO implements Serializable {
    String token;
    DataPayloadDTO data;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public DataPayloadDTO getData() {
        return data;
    }

    public void setData(DataPayloadDTO data) {
        this.data = data;
    }
}
