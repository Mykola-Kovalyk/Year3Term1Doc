package com.lpnu.iot.cornerstoneondemand.resources;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobRequisition extends Resource {

    private String jobTitle;
    private String jobDescription;
    private String location;
    private Long requisitionManagerId;

    @Override
    public String[] getFieldValues() {
        return new String[] {
                Objects.toString(getId()),
                jobDescription,
                location,
                Objects.toString(requisitionManagerId)
        };
    }

    @Override
    public String[] getFieldNames() {
        return new String[] {
                "id",
                "jobDescription",
                "location",
                "requisitionManagerId"
        };
    }

    @Override
    public void setFieldValues(String[] csv) {
        int i = 0;
        setId(Long.parseLong(csv[i++]));
        jobDescription = csv[i++];
        location = csv[i++];
        requisitionManagerId = Long.parseLong(csv[i++]);
    }
}
