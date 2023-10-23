package repository;

import exception.ParkingFloorNotFoundException;
import models.ParkingFloor;
import models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloorRepository {
    private Map<Integer, ParkingFloor> parkingFloorMap;

    public ParkingFloorRepository() {
        this.parkingFloorMap = new HashMap<>();
    }

    public ParkingFloor get(int parkingLotNumber)
    {
        ParkingFloor parkingFloor = parkingFloorMap.get(parkingLotNumber);
        if (parkingFloor == null)
        {
            throw new ParkingFloorNotFoundException("Parking Floor not found" + parkingFloor.getId());
        }
        return parkingFloor;
    }
    public void put(ParkingFloor parkingFloor)
    {
        parkingFloorMap.put(parkingFloor.getId(),parkingFloor);
        System.out.println("Parking lot has been added successfully");
    }
}
