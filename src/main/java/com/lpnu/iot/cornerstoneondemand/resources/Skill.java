package com.lpnu.iot.cornerstoneondemand.resources;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Skill extends Resource {

    private Long candidateId;
    private String name;
    private SkillLevel level;

    @Override
    public String[] getFieldValues() {
        return new String[] {
                Long.toString(getId()),
                candidateId.toString(),
                name,
                level.toString()
        };
    }

    @Override
    public String[] getFieldNames() {
        return new String[] {
                "id",
                "candidateId",
                "name",
                "level"
        };
    }

    @Override
    public void setFieldValues(String[] csv) {
        setId(Long.parseLong(csv[0]));
        candidateId = Long.parseLong(csv[1]);
        name = csv[2];
        level = SkillLevel.valueOf(csv[3]);
    }
}
