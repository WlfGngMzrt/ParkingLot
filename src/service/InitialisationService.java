package service;

import models.*;
import repository.GateRepository;
import repository.ParkingFloorRepository;
import repository.ParkingLotRepository;
import repository.ParkingSpotRepository;

import java.util.ArrayList;
import java.util.List;

public class InitialisationService {
    private GateRepository gateRepository;
    private ParkingFloorRepository parkingFloorRepository;
    private ParkingSpotRepository parkingSpotRepository;
    private ParkingLotRepository parkingLotRepository;

    public InitialisationService(GateRepository gateRepository, ParkingFloorRepository parkingFloorRepository, ParkingSpotRepository parkingSpotRepository, ParkingLotRepository parkingLotRepository) {
        this.gateRepository = gateRepository;
        this.parkingFloorRepository = parkingFloorRepository;
        this.parkingSpotRepository = parkingSpotRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    public ParkingLot  initialise()
    {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(1);
        parkingLot.setStatus(Status.ACTIVE);
        parkingLot.setAddress("A Street, B City, C State");
        parkingLot.setCapacity(100);

        //initialising a gate
        Gate entryGate = new Gate();
        entryGate.setId(1);
        entryGate.setOperator("Ram Kumar");
        entryGate.setGateNumber(1);
        entryGate.setGateType(GateType.ENTRY_GATE);
        entryGate.setFloorNumber(0);
        entryGate.setStatus(Status.ACTIVE);
        entryGate.setParkingLotId(1);

        Gate exitGate = new Gate();
        exitGate.setId(2);
        exitGate.setOperator("Mohan Kumar");
        exitGate.setGateNumber(2);
        exitGate.setGateType(GateType.EXIT_GATE);
        exitGate.setFloorNumber(0);
        exitGate.setStatus(Status.ACTIVE);
        exitGate.setParkingLotId(1);

        parkingLot.setGates(List.of(entryGate,exitGate));
        gateRepository.put(entryGate);
        gateRepository.put(exitGate);

        List<ParkingFloor> parkingFloors = new ArrayList<>();

        for(int i = 1; i <= 10; i++)
        {
            List<ParkingSpot> parkingSpots = new ArrayList<>();
            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setId(100+i);
            parkingFloor.setStatus(Status.ACTIVE);
            parkingFloor.setFloorNumber(i);
            for(int j = 1;j <= 10; j++)
            {
                ParkingSpot parkingSpot = new ParkingSpot();
                parkingSpot.setId(j*1000 + 1);
                parkingSpot.setNumber(i*10+j);
                if(j % 2 == 0)
                {
                    parkingSpot.setVehicleTypeSupported(VehicleType.TWO_WHEELER);
                }
                else
                {
                    parkingSpot.setVehicleTypeSupported(VehicleType.FOUR_WHEELER);
                }
                parkingSpot.setStatus(Status.AVAILABLE);
                parkingSpots.add(parkingSpot);
                parkingSpotRepository.put(parkingSpot);
            }
            parkingFloor.setParkingSpots(parkingSpots);
            parkingFloorRepository.put(parkingFloor);
            parkingFloors.add(parkingFloor);
        }
        parkingLot.setParkingFloors(parkingFloors);
        parkingLotRepository.put(parkingLot);
        return parkingLot;
    }
}
