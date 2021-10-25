package novi.invoices.dto;

import java.util.Arrays;
import java.util.List;

public class OrderRequestDto {
    public String customerEmail;
    public List<OrderItemInputDto> items;

    public OrderRequestDto(String customerEmail, OrderItemInputDto... items) {
        this.customerEmail = customerEmail;
        this.items = Arrays.asList(items);
    }
}
