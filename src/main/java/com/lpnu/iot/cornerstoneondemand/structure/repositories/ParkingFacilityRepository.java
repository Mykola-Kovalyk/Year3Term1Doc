package com.lpnu.iot.cornerstoneondemand.structure.repositories;

import com.lpnu.iot.cornerstoneondemand.resources.ParkingFacility;
import org.springframework.stereotype.Repository;

@Repository
public class ParkingFacilityRepository extends CSVRepository<ParkingFacility> {
    public ParkingFacilityRepository() {
        super("data/parking_facilities");
    }

    @Override
    protected ParkingFacility createNewResource() {
        return new ParkingFacility();
    }
}
