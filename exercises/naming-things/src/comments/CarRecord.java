package src.comments;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class CarRecord {
    private String licensePlateNumber;
    private String manufacturingDate;

    private String rimColor;

    private String owner;
    private String ownerSince;

    public void update(String o) {
        this.owner = o;
        this.ownerSince = ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT);
    }

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
