package repository;

import exception.GateNotFoundException;
import exception.TicketNotFoundException;
import models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    private Map<Integer, Ticket> TicketMap;

    public TicketRepository() {
        this.TicketMap = new HashMap<>();
    }

    public Ticket get(int parkingLotNumber)
    {
        Ticket Ticket = TicketMap.get(parkingLotNumber);
        if (Ticket == null)
        {
            throw new TicketNotFoundException("Parking Floor not found" + Ticket.getId());
        }
        return Ticket;
    }
    public void put(Ticket Ticket)
    {
        TicketMap.put(Ticket.getId(),Ticket);
        System.out.println("Parking lot has been added successfully");
    }
}
