package src.comments;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class CarRecord {
    private String licensePlateNumber;
    private String manufacturingDate;

    // private String color;
    private String rimColor;

    private String owner;
    private String ownerSince;

    public void update(String o) {
        this.owner = o;
        this.ownerSince = ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT);
    }

    // Gets owner
    public String getOwnerSince() {
        return ownerSince;
    }
    
    // Sets owner
    public String getOwner() {
        return owner;
    }

    // Gets rim color
    public String getRimColor() {
        return rimColor;
    }

    // Sets rim color
    public void setRimColor(String rimColor) {
        this.rimColor = rimColor;
    }

    // public String getColor() {
    //     return color;
    // }

    // public void setColor(String color) {
    //     this.color = color;
    // }

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
