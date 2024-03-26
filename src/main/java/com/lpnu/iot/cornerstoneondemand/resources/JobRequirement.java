package com.lpnu.iot.cornerstoneondemand.resources;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobRequirement extends Resource {

    private Long jobId;
    private JobRequirementType type;
    private String description;

    @Override
    public String[] getFieldValues() {
        return new String[] {
                Long.toString(getId()),
                jobId.toString(),
                type.toString(),
                description
        };
    }

    @Override
    public String[] getFieldNames() {
        return new String[] {
                "id",
                "jobId",
                "type",
                "description"
        };
    }

    @Override
    public void setFieldValues(String[] csv) {
        setId(Long.parseLong(csv[0]));
        jobId = Long.parseLong(csv[1]);
        type = JobRequirementType.valueOf(csv[2]);
        description = csv[3];
    }
}
