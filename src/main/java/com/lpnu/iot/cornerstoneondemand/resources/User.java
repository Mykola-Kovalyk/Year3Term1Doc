package com.lpnu.iot.cornerstoneondemand.resources;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User extends Resource {

    private String name;
    private String phone;
    private String email;

    @Override
    public String[] getFieldValues() {
        return new String[] {
                Long.toString(getId()),
                name,
                phone,
                email
        };
    }

    @Override
    public String[] getFieldNames() {
        return new String[] {
                "id",
                "name",
                "phone",
                "email",
        };
    }

    @Override
    public void setFieldValues(String[] csv) {
        setId(Long.parseLong(csv[0]));
        name = csv[1];
        phone = csv[2];
        email = csv[3];
    }
}
