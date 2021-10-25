package novi.invoices.dto;

public class OrderItemInputDto {
    public int productId;
    public int count;

    public OrderItemInputDto(int productId, int count) {
        this.productId = productId;
        this.count = count;
    }
}
