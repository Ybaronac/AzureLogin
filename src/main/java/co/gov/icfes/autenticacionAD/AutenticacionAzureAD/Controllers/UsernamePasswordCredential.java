package co.gov.icfes.autenticacionAD.AutenticacionAzureAD.Controllers;

public class UsernamePasswordCredential {
    private Object clientId;
    private Object username;
    private Object password;
    public UsernamePasswordCredential() {
    }

    public Object getPassword() {
        return password;
    }

    public void setPassword(Object password) {
        this.password = password;
    }

    public Object getClientId() {
        return clientId;
    }

    public void setClientId(Object clientId) {
        this.clientId = clientId;
    }

    public Object getUsername() {
        return username;
    }

    public void setUsername(Object username) {
        this.username = username;
    }
}
