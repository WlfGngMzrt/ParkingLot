package repository;

import exception.ParkingLotNotFoundException;
import models.ParkingLot;
import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {
    private Map<Integer, ParkingLot> parkingLotMap;

    public ParkingLotRepository() {
        this.parkingLotMap = new HashMap<>();
    }

    public ParkingLot get(int parkingLotNumber)
    {
        ParkingLot parkingLot = parkingLotMap.get(parkingLotNumber);
        if (parkingLot == null)
        {
            throw new ParkingLotNotFoundException("Parking Lot not found" + parkingLot.getId());
        }
        return parkingLot;
    }
    public void put(ParkingLot parkingLot)
    {
        parkingLotMap.put(parkingLot.getId(),parkingLot);
        System.out.println("Parking lot has been added successfully");
    }
}
