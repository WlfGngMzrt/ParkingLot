package strategy.spotallocationstrategy;

import exception.ParkingSpotNotFoundException;
import models.*;
import repository.ParkingLotRepository;

public class RandomSpotAllocationStrategy implements SpotAllocationStrategy{

    private ParkingLotRepository parkingLotRepository;

    public RandomSpotAllocationStrategy(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    public ParkingSpot getSpot(VehicleType vehicleType, Gate gate) {

        ParkingLot parkingLot = parkingLotRepository.get(gate.getParkingLotId());
        int currentFloor = gate.getFloorNumber();

        ParkingFloor parkingFloor = parkingLot.getParkingFloors().get(currentFloor - 1);
        for(ParkingSpot parkingSpot : parkingFloor.getParkingSpots()) {
            if (parkingSpot.getVehicleTypeSupported().equals(vehicleType)
                    && parkingSpot.getStatus().equals(Status.AVAILABLE)) {
                return parkingSpot;
            }
        }

        for(ParkingFloor floor : parkingLot.getParkingFloors())
        {
            for(ParkingSpot parkingSpot : floor.getParkingSpots())
            {
                if (parkingSpot.getVehicleTypeSupported().equals(vehicleType)
                        && parkingSpot.getStatus().equals(Status.AVAILABLE)) {
                    return parkingSpot;
                }
            }
        }
        throw new ParkingSpotNotFoundException("No Parking Spot Available");
    }
}
