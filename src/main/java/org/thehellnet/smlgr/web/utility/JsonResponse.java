package org.thehellnet.smlgr.web.utility;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sardylan on 16/05/15.
 */
public class JsonResponse implements Serializable {

    private boolean success;
    private Map<String, Object> data;
    private Map<String, Object> errors;

    public JsonResponse() {
    }

    public JsonResponse(boolean success) {
        this.setSuccess(success);
    }

    public static JsonResponse createInstance(boolean success) {
        return new JsonResponse(success);
    }

    public static JsonResponse createInstance(boolean success, Map<String, Object> data) {
        JsonResponse jsonResponse = createInstance(success);
        jsonResponse.setData(data);
        return jsonResponse;
    }

    public static JsonResponse createInstance(String errorMessage) {
        JsonResponse jsonResonse = createInstance(false);
        jsonResonse.getErrors().put("message", errorMessage);
        return jsonResonse;
    }

    public boolean getSuccess() {
        return success;
    }

    public JsonResponse setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public Map<String, Object> getData() {
        if (data == null) {
            data = new HashMap<>();
        }
        return data;
    }

    public JsonResponse setData(Map<String, Object> data) {
        this.data = data;
        return this;
    }

    public Map<String, Object> getErrors() {
        if (errors == null) {
            errors = new HashMap<>();
        }
        return errors;
    }

    public JsonResponse setErrors(Map<String, Object> errors) {
        this.errors = errors;
        return this;
    }

    public JsonResponse putData(String key, Object value) {
        getData().put(key, value);
        return this;
    }

    public JsonResponse putError(String key, Object value) {
        getErrors().put(key, value);
        return this;
    }
}
