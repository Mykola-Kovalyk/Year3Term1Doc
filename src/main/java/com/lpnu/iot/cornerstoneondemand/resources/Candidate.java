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
public class Candidate extends Resource {

    private Long userId;
    private Long jobId;

    @Override
    public String[] getFieldValues() {
        return new String[] {
                Objects.toString(getId()),
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
        int i = 0;
        setId(Long.parseLong(csv[i++]));
        userId = Long.parseLong(csv[i++]);
        jobId = Long.parseLong(csv[i++]);
    }
}
