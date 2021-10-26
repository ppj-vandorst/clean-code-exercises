package src.naming;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class CarRecord {
    private String licensePlateNumber;
    private String manufacturingISODate;

    private String colorHex;
    private String rimColorHex;

    private String ownerFullName;
    private String ownerSinceISODate;

    public void assignNewOwner(String ownerFullName) {
        this.ownerFullName = ownerFullName;
        this.ownerSinceISODate = ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT);
    }

    // Getters / setters
    public String getOwnerSinceISODate() {
        return ownerSinceISODate;
    }

    public String getOwnerFullname() {
        return ownerFullName;
    }

    public String getRimColor() {
        return rimColorHex;
    }

    public void setRimColor(String rimColor) {
        this.rimColorHex = rimColor;
    }

    // public String getColor() {
    //     return color;
    // }

    // public void setColor(String color) {
    //     this.color = color;
    // }

    public String getManufacturingDate() {
        return manufacturingISODate;
    }

    public void setManufacturingDate(String manufacturingDate) {
        this.manufacturingISODate = manufacturingDate;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

}
