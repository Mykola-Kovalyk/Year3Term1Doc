package com.lpnu.iot.cornerstoneondemand.resources;

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
                Long.toString(getId()),
                jobDescription,
                location,
                Long.toString(requisitionManagerId)
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
        setId(Long.parseLong(csv[0]));
        jobDescription = csv[1];
        location = csv[2];
        requisitionManagerId = Long.parseLong(csv[3]);
    }
}
