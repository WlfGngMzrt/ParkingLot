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

    public Ticket get(int ticketId)
    {
        Ticket Ticket = TicketMap.get(ticketId);
        if (Ticket == null)
        {
            throw new TicketNotFoundException("Ticket not found" + ticketId);
        }
        return Ticket;
    }
    public void put(Ticket Ticket)
    {
        TicketMap.put(Ticket.getId(),Ticket);
        System.out.println("Ticket has been added successfully");
    }
}
