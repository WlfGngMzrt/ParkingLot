package strategy.spotallocationstrategy;

import models.Gate;
import models.ParkingSpot;
import models.Vehicle;
import models.VehicleType;

public interface SpotAllocationStrategy {
    ParkingSpot getSpot(VehicleType vehicleType, Gate gate);

}
