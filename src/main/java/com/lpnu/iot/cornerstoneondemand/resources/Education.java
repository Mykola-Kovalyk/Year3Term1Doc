package com.lpnu.iot.cornerstoneondemand.resources;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Education extends Resource {

    private String institution;
    private String degree;
    private String fieldOfStudy;
    private Integer graduationYear;

    @Override
    public String[] getFieldValues() {
        return new String[] {
                Long.toString(getId()),
                institution,
                degree,
                fieldOfStudy,
                Integer.toString(graduationYear)
        };
    }

    @Override
    public String[] getFieldNames() {
        return new String[] {
                "id",
                "institution",
                "degree",
                "fieldOfStudy",
                "graduationYear"
        };
    }

    @Override
    public void setFieldValues(String[] csv) {
        setId(Long.parseLong(csv[0]));
        institution = csv[1];
        degree = csv[2];
        fieldOfStudy = csv[3];
        graduationYear = Integer.parseInt(csv[4]);
    }
}
