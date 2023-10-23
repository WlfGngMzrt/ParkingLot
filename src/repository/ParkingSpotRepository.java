package repository;

import exception.ParkingSpotNotFoundException;
import models.ParkingFloor;
import models.ParkingSpot;

import java.util.HashMap;
import java.util.Map;

public class ParkingSpotRepository {
    private Map<Integer, ParkingSpot> parkingSpotMap;

    public ParkingSpotRepository() {
        this.parkingSpotMap = new HashMap<>();
    }

    public ParkingSpot get(int parkingLotNumber)
    {
        ParkingSpot parkingSpot = parkingSpotMap.get(parkingLotNumber);
        if (parkingSpot == null)
        {
            throw new ParkingSpotNotFoundException("Parking Floor not found" + parkingSpot.getId());
        }
        return parkingSpot;
    }
    public void put(ParkingSpot parkingSpot)
    {
        parkingSpotMap.put(parkingSpot.getId(),parkingSpot);
        System.out.println("Parking lot has been added successfully");
    }
}
