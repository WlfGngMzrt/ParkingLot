import controller.TicketController;
import dto.IssueTicketRequestDTO;
import dto.IssueTicketResponseDTO;
import models.ParkingLot;
import models.VehicleType;
import repository.*;
import service.InitialisationService;
import service.TicketService;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    private InitialisationService initialisationService;
    private TicketController ticketController;

    public Main() {
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        GateRepository gateRepository = new GateRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();

        this.initialisationService = new InitialisationService(gateRepository, parkingFloorRepository, parkingSpotRepository, parkingLotRepository);
        this.ticketController = new TicketController(new TicketService(ticketRepository, parkingLotRepository, gateRepository));

    }
    public static void main(String[] args) {

        Main main = new Main();
        ParkingLot parkingLot = main.initialisationService.initialise();
        IssueTicketRequestDTO issueTicketRequestDTO =
                new IssueTicketRequestDTO(VehicleType.FOUR_WHEELER,  "Black", "AB237","Volkswagen", 1);
        IssueTicketResponseDTO responseDTO = main.ticketController.getTicket(issueTicketRequestDTO);
        System.out.println(responseDTO);

    }
}