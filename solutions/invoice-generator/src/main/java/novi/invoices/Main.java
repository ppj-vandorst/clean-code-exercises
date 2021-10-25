package novi.invoices;

import novi.invoices.dto.OrderItemInputDto;
import novi.invoices.dto.OrderRequestDto;

public class Main {
    public static void main(String[] args) {
        OrderService service = new OrderService();

        var request = new OrderRequestDto("test@test.com", new OrderItemInputDto(1, 1));
        service.processOrderRequest(request);
    }
}
