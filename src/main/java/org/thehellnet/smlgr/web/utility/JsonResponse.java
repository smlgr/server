package org.thehellnet.smlgr.web.utility;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by sardylan on 16/05/15.
 */
public class JsonResponse implements Serializable {
    private boolean success;
    private Object data;

    protected JsonResponse(boolean success) {
        this.setSuccess(success);
    }

    public static JsonResponse createInstance(boolean success) {
        JsonResponse jsonResonse = new JsonResponse(success);
        return jsonResonse;
    }

    public static JsonResponse createInstance(boolean success, Object data) {
        JsonResponse jsonResonse = new JsonResponse(success);
        jsonResonse.setData(data);
        return jsonResonse;
    }

    public static JsonResponse createErrorInstance(String error_msg) {
        JsonResponse jsonResonse = new JsonResponse(false);
        HashMap<String, String> responseData = new HashMap<>();
        responseData.put("error_msg", error_msg);
        jsonResonse.setData(responseData);
        return jsonResonse;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}