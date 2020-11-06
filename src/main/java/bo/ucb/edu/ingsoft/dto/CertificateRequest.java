package bo.ucb.edu.ingsoft.dto;

import bo.ucb.edu.ingsoft.model.Transaction;

import java.util.Date;

public class CertificateRequest {
    private String name;
    private String company;
    private Date expeditionDate;
    private String credentialId;
    private String credentialURL;
    private Date expirationDate;

    public CertificateRequest() {
    }

    @Override
    public String toString() {
        return "CertificateRequest{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", expeditionDate=" + expeditionDate +
                ", credentialId='" + credentialId + '\'' +
                ", credentialURL='" + credentialURL + '\'' +
                ", expirationDate=" + expirationDate +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getExpeditionDate() {
        return expeditionDate;
    }

    public void setExpeditionDate(Date expeditionDate) {
        this.expeditionDate = expeditionDate;
    }

    public String getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(String credentialId) {
        this.credentialId = credentialId;
    }

    public String getCredentialURL() {
        return credentialURL;
    }

    public void setCredentialURL(String credentialURL) {
        this.credentialURL = credentialURL;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
