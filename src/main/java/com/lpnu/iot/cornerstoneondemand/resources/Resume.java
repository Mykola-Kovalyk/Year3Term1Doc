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
public class Resume extends Resource {

    private Long candidateId;

    @Override
    public String[] getFieldValues() {
        return new String[] {
                Objects.toString(getId()),
                Objects.toString(candidateId),
        };
    }

    @Override
    public String[] getFieldNames() {
        return new String[] {
                "id",
                "candidateId",
        };
    }

    @Override
    public void setFieldValues(String[] csv) {
        setId(Long.parseLong(csv[0]));
        candidateId = Long.parseLong(csv[1]);
    }
}
