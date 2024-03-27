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

    private Long userId;
    private Long jobId;

    @Override
    public String[] getFieldValues() {
        return new String[] {
                Long.toString(getId()),
                userId.toString(),
                jobId.toString()
        };
    }

    @Override
    public String[] getFieldNames() {
        return new String[] {
                "id",
                "userId",
                "jobId",
        };
    }

    @Override
    public void setFieldValues(String[] csv) {
        setId(Long.parseLong(csv[0]));
        userId = Long.parseLong(csv[1]);
        jobId = Long.parseLong(csv[1]);
    }
}
