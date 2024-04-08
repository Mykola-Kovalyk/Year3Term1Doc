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
public class Education extends Resource {

    private Long candidateId;
    private String institution;
    private String degree;
    private String fieldOfStudy;
    private Integer graduationYear;

    @Override
    public String[] getFieldValues() {
        return new String[] {
                Objects.toString(getId()),
                Objects.toString(candidateId),
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
                "candidateId",
                "institution",
                "degree",
                "fieldOfStudy",
                "graduationYear"
        };
    }

    @Override
    public void setFieldValues(String[] csv) {
        setId(Long.parseLong(csv[0]));
        candidateId = Long.parseLong(csv[1]);
        institution = csv[2];
        degree = csv[3];
        fieldOfStudy = csv[4];
        graduationYear = Integer.parseInt(csv[5]);
    }
}
