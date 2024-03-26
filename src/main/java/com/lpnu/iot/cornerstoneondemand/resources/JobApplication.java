package com.lpnu.iot.cornerstoneondemand.resources;

import java.util.Date;
import java.text.DateFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobApplication extends Resource {

    private Long candidateId;
    private Long jobRequisitionId;
    private ApplicationStatus status;
    private Date applicationDate;

    @Override
    public String[] getFieldValues() {
        return new String[] {
                Long.toString(getId()),
                Long.toString(candidateId),
                Long.toString(jobRequisitionId),
                status.toString(),
                applicationDate.toString()
        };
    }

    @Override
    public String[] getFieldNames() {
        return new String[] {
                "id",
                "candidateId",
                "jobRequisitionId",
                "status",
                "applicationDate"
        };
    }

    @Override
    public void setFieldValues(String[] csv) {
        setId(Long.parseLong(csv[0]));
        candidateId = Long.parseLong(csv[1]);
        jobRequisitionId = Long.parseLong(csv[2]);
        status = ApplicationStatus.valueOf(csv[3]);

        try {
            applicationDate = DateFormat.getDateInstance().parse(csv[4]);
        } catch (Exception e) {
            applicationDate = new Date();
        }
    }
}
