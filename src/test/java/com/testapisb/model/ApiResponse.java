package com.testapisb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse<T> {
    private int code;
    private int total;
    private List<T> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getData() { return data; }
    public void setData(List<T> data) { this.data = data; }

    // for Assertion size as intended
    public boolean hasSize(int expected) {
        return data != null && data.size() == expected && total == expected;
    }
}