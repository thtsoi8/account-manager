package com.acmebank.accountmanager.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class BaseDto implements Serializable {
    private Map<String, String> errors = new HashMap<>();

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public void addError(String key, String errorMessage) {
        errors.put(key, errorMessage);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BaseDto{");
        sb.append("errors=").append(errors);
        sb.append('}');
        return sb.toString();
    }
}
