package com.lpnu.iot.cornerstoneondemand.resources;

import java.text.DateFormat;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkExperience extends Resource {

    private Long candidateId;
    private String company;
    private String position;
    private Date startDate;
    private Date endDate;
    private String description;

    @Override
    public String[] getFieldValues() {
        return new String[] {
                Long.toString(getId()),
                candidateId.toString(),
                company,
                position,
                startDate.toString(),
                endDate.toString(),
                description
        };
    }

    @Override
    public String[] getFieldNames() {
        return new String[] {
                "id",
                "candidateId",
                "company",
                "position",
                "startDate",
                "endDate",
                "description"
        };
    }

    @Override
    public void setFieldValues(String[] csv) {
        int i = 0;
        
        setId(Long.parseLong(csv[i++]));
        candidateId = Long.parseLong(csv[i++]);
        company = csv[i++];
        position = csv[i++];

        try {
            startDate = DateFormat.getDateInstance().parse(csv[i++]);
        } catch (Exception e) {
            startDate = new Date();
        }

        try {
            endDate = DateFormat.getDateInstance().parse(csv[i++]);
        } catch (Exception e) {
            endDate = new Date();
        }

        description = csv[i++];
    }
}