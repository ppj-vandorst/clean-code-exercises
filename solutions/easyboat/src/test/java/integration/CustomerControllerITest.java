package integration;

import com.novi.easyboat.EasyboatApplication;
import com.novi.easyboat.controllers.dto.CustomerDto;
import com.novi.easyboat.controllers.dto.CustomerInputDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = EasyboatApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
public class CustomerControllerITest {
    private static final String BASE_URL = "http://localhost:8082";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testSaveCustomer() {
        // test a customer is saved correctly
    }

    @Test
    public void testGetCustomers() {
        // test we can retrieve a list of customers
    }

}
