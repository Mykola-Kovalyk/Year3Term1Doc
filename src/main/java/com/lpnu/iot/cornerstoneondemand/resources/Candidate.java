package com.lpnu.iot.cornerstoneondemand.resources;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Candidate extends Resource {

    private Long jobId;
    private String name;
    private String phone;
    private String email;

    @Override
    public String[] getFieldValues() {
        return new String[] {
                Long.toString(getId()),
                jobId.toString(),
                name,
                phone,
                email
        };
    }

    @Override
    public String[] getFieldNames() {
        return new String[] {
                "id",
                "jobId",
                "name",
                "phone",
                "email",
        };
    }

    @Override
    public void setFieldValues(String[] csv) {
        setId(Long.parseLong(csv[0]));
        jobId = Long.parseLong(csv[1]);
        name = csv[2];
        phone = csv[3];
        email = csv[4];
    }
}
