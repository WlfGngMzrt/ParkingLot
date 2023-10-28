package controller;
import dto.IssueTicketRequestDTO;
import dto.IssueTicketResponseDTO;
import dto.ResponseStatus;
import exception.InvalidRequestDataException;
import models.Ticket;
import service.TicketService;
public class TicketController {
    private TicketService TicketService;
    public TicketController(TicketService ticketService) {
        TicketService = ticketService;
    }

    public IssueTicketResponseDTO getTicket(IssueTicketRequestDTO issueTicketRequestDTO)
    {
        IssueTicketResponseDTO issueTicketResponseDTO = new IssueTicketResponseDTO();
        try {
            if (issueTicketRequestDTO.getGateId() == 0 ||
                    issueTicketRequestDTO.getVehicleType() == null ||
                    issueTicketRequestDTO.getVehicleNumber() == null) {
                throw new InvalidRequestDataException("Ticket Generation request data is invalid");
            }
            Ticket ticket = TicketService.getTicket(issueTicketRequestDTO.getVehicleType()
                    ,issueTicketRequestDTO.getVehicleNumber(),
                    issueTicketRequestDTO.getVehicleMake(),
                    issueTicketRequestDTO.getVehicleMake(),
                    issueTicketRequestDTO.getGateId());
            issueTicketResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            issueTicketResponseDTO.setTicket(ticket);

        }
        catch(Exception e)
        {
            issueTicketResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
            issueTicketResponseDTO.setFailureReason(e.getMessage());
        }
        return issueTicketResponseDTO;
    }

}
