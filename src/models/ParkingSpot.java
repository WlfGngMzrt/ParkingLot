package models;

public class ParkingSpot extends BaseModel{
    private int number;
    private VehicleType vehicleTypeSupported;
    private Status status;
    private Vehicle vehicle;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public VehicleType getVehicleTypeSupported() {
        return vehicleTypeSupported;
    }

    public void setVehicleTypeSupported(VehicleType vehicleTypeSupported) {
        this.vehicleTypeSupported = vehicleTypeSupported;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
