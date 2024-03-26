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
    private String poisition;
    private Date startDate;
    private Date endDate;
    private String description;

    @Override
    public String[] getFieldValues() {
        return new String[] {
                Long.toString(getId()),
                candidateId.toString(),
                company,
                poisition,
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
                "poisition",
                "startDate",
                "endDate",
                "description"
        };
    }

    @Override
    public void setFieldValues(String[] csv) {
        setId(Long.parseLong(csv[0]));
        company = csv[1];
        poisition = csv[2];
        
        try {
            startDate = DateFormat.getDateInstance().parse(csv[3]);
        } catch (Exception e) {
            startDate = new Date();
        }

        try {
            endDate = DateFormat.getDateInstance().parse(csv[4]);
        } catch (Exception e) {
            endDate = new Date();
        }

        description = csv[5];
    }
}