package com.lpnu.iot.cornerstoneondemand.resources;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Recruiter extends Resource {

    private String department;

    @Override
    public String[] getFieldValues() {
        return new String[] {
                Long.toString(getId()),
                department
        };
    }

    @Override
    public String[] getFieldNames() {
        return new String[] {
                "id",
                "department"
        };
    }

    @Override
    public void setFieldValues(String[] csv) {
        setId(Long.parseLong(csv[0]));
        department = csv[1];
    }
}
