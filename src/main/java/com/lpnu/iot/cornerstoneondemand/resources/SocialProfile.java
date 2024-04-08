package com.lpnu.iot.cornerstoneondemand.resources;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SocialProfile extends Resource {

    private String platform;
    private String profileUrl;

    @Override
    public String[] getFieldValues() {
        return new String[] { Long.toString(getId()), platform, profileUrl };
    }

    @Override
    public String[] getFieldNames() {
        return new String[] {
                "id",
                "platform",
                "profileUrl"
        };
    }

    @Override
    public void setFieldValues(String[] csv) {
        int i = 0;
        setId(Long.parseLong(csv[i++]));
        platform = csv[i++];
        profileUrl = csv[i++];
    }
}
