package co.gov.icfes.autenticacionAD.AutenticacionAzureAD.Controllers;

import co.gov.icfes.autenticacionAD.AutenticacionAzureAD.AutenticacionAzureAdApplication;
import co.gov.icfes.autenticacionAD.AutenticacionAzureAD.Models.AzureConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(path = "")
public class AzureADController {
private AzureConfiguration azureConfiguration;
    @Value("${spring.cloud.azure.active-directory.profile.tenant-id}")
    private String tenant;

    public static void main(String[] args) {
        SpringApplication.run(AutenticacionAzureAdApplication.class, args);
    }

    @GetMapping("/Token")
    public String Token() throws URISyntaxException {
        //RestTemplate restTemplate = new RestTemplate();

/*        RestTemplate restTemplate = new RestTemplate();

        String resourceUrl
                = "https://login.microsoftonline.com/"+ tenant +"/oauth2/v2.0/token";*/


        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://login.microsoftonline.com/375abf56-f1c9-42af-8094-fb5b7f1020fb/oauth2/v2.0/token")
                .header("Cookie", "fpc=ApiAVW3IsAtAhuvT9cLVqGKzfU6RAQAAADRL8dkOAAAA; stsservicecookie=estsfd; x-ms-gateway-slice=estsfd")
                .multiPartContent()
                .field("password", "Popayan2703")
                .field("username", "jhonTest@faibertorresohotmail.onmicrosoft.com")
                .field("client_id", "318c3c9b-9f36-4cbe-8ffa-93bd78428834")
                .field("scope", "https://graph.microsoft.com/.default")
                .field("client_secret", "45z7Q~9H2Ou4qWAESaUyOp0TBN5jYLGcdDsXB")
                .field("grant_type", "password")
                .asString();

        // Fetch JSON response as String wrapped in ResponseEntity
/*        ResponseEntity<String> response
                = restTemplate.getForEntity(resourceUrl, String.class);

        String productsJson = response.getBody();*/


//            final String baseUrl = "https://login.microsoftonline.com/"+ tenant +"/oauth2/v2.0/token";
//            URI uri = new URI(baseUrl);
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.set("X-COM-PERSIST", "true");
//            headers.set("X-COM-LOCATION", "USA");
//
//            HttpEntity<Employee> requestEntity = new HttpEntity<>(null, headers);
//
//            ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
//
//            //Verify request succeed
//            Assert.assertEquals(200, result.getStatusCodeValue());
//            Assert.assertEquals(true, result.getBody().contains("employeeList"));




        return azureConfiguration.getTenant();
    }

}
