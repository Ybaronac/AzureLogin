package co.gov.icfes.autenticacionAD.AutenticacionAzureAD.Controllers;

import co.gov.icfes.autenticacionAD.AutenticacionAzureAD.AutenticacionAzureAdApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Ping {
    public static void main(String[] args) {
        SpringApplication.run(AutenticacionAzureAdApplication.class, args);
    }

    @GetMapping("/pingTest")
    public String hello(){
        return "Ping OK";
    }




}
