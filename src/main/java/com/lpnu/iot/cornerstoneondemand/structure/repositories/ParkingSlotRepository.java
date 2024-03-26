package com.lpnu.iot.cornerstoneondemand.structure.repositories;

import com.lpnu.iot.cornerstoneondemand.resources.ParkingSlot;
import org.springframework.stereotype.Repository;

@Repository
public class ParkingSlotRepository extends CSVRepository<ParkingSlot> {
    public ParkingSlotRepository() {
        super("data/parking_slots");
    }

    @Override
    protected ParkingSlot createNewResource() {
        return new ParkingSlot();
    }
}
