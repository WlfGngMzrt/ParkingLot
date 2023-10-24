package strategy.spotallocationstrategy;

import repository.ParkingLotRepository;

public class SpotAllocationFactory {
    public static SpotAllocationStrategy getSpotAllocationStrategy(ParkingLotRepository parkingLotRepository)
    {
        return new RandomSpotAllocationStrategy(parkingLotRepository);
    }
}
