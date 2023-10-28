package repository;

import exception.GateNotFoundException;
import models.Gate;

import java.util.HashMap;
import java.util.Map;

public class GateRepository {
    private Map<Integer, Gate> gateMap;

    public GateRepository() {
        this.gateMap = new HashMap<>();
    }

    public Gate get(int parkingLotNumber)
    {
        Gate gate = gateMap.get(parkingLotNumber);
        if (gate == null)
        {
            throw new GateNotFoundException("Parking Floor not found" + gate.getId());
        }
        return gate;
    }
    public void put(Gate gate)
    {
        gateMap.put(gate.getId(),gate);
        System.out.println("Gate has been added successfully");
    }
}
