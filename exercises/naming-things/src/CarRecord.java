package src;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class CarRecord {
    private String licensePlateNumber;
    private String manufacturingDate;

    private String color;
    private String rimColor;

    private String owner;
    private String ownerSince;

    public void update(String o) {
        this.owner = o;
        this.ownerSince = ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT);
    }

    // Getters / setters
    public String getOwnerSince() {
        return ownerSince;
    }

    public String getOwner() {
        return owner;
    }

    public String getRimColor() {
        return rimColor;
    }

    public void setRimColor(String rimColor) {
        this.rimColor = rimColor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(String manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

}
