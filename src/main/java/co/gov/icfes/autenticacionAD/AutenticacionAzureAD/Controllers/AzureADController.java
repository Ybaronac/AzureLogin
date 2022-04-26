package co.gov.icfes.autenticacionAD.AutenticacionAzureAD.Controllers;

import co.gov.icfes.autenticacionAD.AutenticacionAzureAD.AutenticacionAzureAdApplication;
import co.gov.icfes.autenticacionAD.AutenticacionAzureAD.Models.AzureConfiguration;
import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.azure.identity.UsernamePasswordCredential;
import com.azure.identity.UsernamePasswordCredentialBuilder;
import com.microsoft.graph.authentication.TokenCredentialAuthProvider;
import com.microsoft.graph.models.User;
import com.microsoft.graph.requests.GraphServiceClient;
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
import java.sql.Array;
import java.util.ArrayList;

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

        //Prueba 4

//        ArrayList scopes = new ArrayList<String>();
//        scopes.add("User.Read");
//
//        final UsernamePasswordCredential usernamePasswordCredential = new UsernamePasswordCredentialBuilder()
//                .clientId("34003f59-7c72-4d25-bf04-e84dd26eabd5")
//                .username("prisma@icfes.gov.co")
//                .password("Pruebas123*")
//                .build();
//
//        final TokenCredentialAuthProvider tokenCredentialAuthProvider = new TokenCredentialAuthProvider(scopes, usernamePasswordCredential);
//
//        final GraphServiceClient graphClient =
//                GraphServiceClient
//                        .builder()
//                        .authenticationProvider(tokenCredentialAuthProvider)
//                        .buildClient();
//
//        final User me = graphClient.me().buildRequest().get();


        ArrayList scopes = new ArrayList<String>();
            scopes.add("https://graph.microsoft.com/.default");


        final ClientSecretCredential clientSecretCredential = new ClientSecretCredentialBuilder()
                .clientId("34003f59-7c72-4d25-bf04-e84dd26eabd5")
                .clientSecret("Fz~7Q~ck2jJOmobcfe_upytiNymDtMt4Gk3o.")
                .tenantId("27864e10-5be4-4d4f-adb5-bbab512029e8")
                .build();

        final TokenCredentialAuthProvider tokenCredAuthProvider =
                new TokenCredentialAuthProvider(scopes, clientSecretCredential);

        final GraphServiceClient graphClient = GraphServiceClient
                .builder()
                .authenticationProvider(tokenCredAuthProvider)
                .buildClient();

        final User user = graphClient.me()
                .buildRequest()
                .get();

        return azureConfiguration.getTenant();
    }

}
