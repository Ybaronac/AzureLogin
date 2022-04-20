package co.gov.icfes.autenticacionAD.AutenticacionAzureAD.Models;

import org.springframework.beans.factory.annotation.Value;

public class AzureConfiguration {

    @Value("${spring.cloud.azure.active-directory.profile.tenant-id}")
    public String tenant;

    public AzureConfiguration() {}

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }
}
