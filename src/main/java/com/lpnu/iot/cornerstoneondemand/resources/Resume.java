package com.lpnu.iot.cornerstoneondemand.resources;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Resume extends Resource {

    @Override
    public String[] getFieldValues() {
        return new String[] {
                Long.toString(getId()),
        };
    }

    @Override
    public String[] getFieldNames() {
        return new String[] {
                "id"
        };
    }

    @Override
    public void setFieldValues(String[] csv) {
        setId(Long.parseLong(csv[0]));
    }
}
