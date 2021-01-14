package bo.ucb.edu.ingsoft.dto;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CertificateRequest {
    private Integer certificateId;

    @NotBlank(message = " Se requiere nombre del Certificado.")
    @Size(min = 3, message = "Se requiere 3 caracteres como minimo.")
    private String certificateName;

    @NotBlank(message = "Se requiere nombre de la Empresa.")
    @Size(min = 3, message = "Se requiere 3 caracteres como minimo.")
    private String company;

    @NotBlank(message = "Se requiere el Id del credencial.")
    @Size(min = 8,max = 30,message = "Se requiere 8 caracteres como minimo y 30 como maximo.")
    private String credentialId;

    @NotBlank(message = " Se requiere la URL del credencial.")
    @Size(min = 15,max = 74,message = "Se requiere 15 caracteres como minimo y 74 como maximo.")
    private String credentialURL;

    @NotBlank(message = " Se requiere la fecha de expedicion.")
    @Size(min =2020,max =2029,message = "La fecha de expedicion se requiere a partir del 2020 al 2029.")
    private Date expeditionDate;

    @NotBlank(message = " Se requiere la fecha de expiracion.")
    @Size(min = 2021,max =2029,message = "La fecha de expiracion se requiere a partir  del 2021 al 2029.")
    private Date expirationDate;

    public CertificateRequest() {
    }

    public Integer getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(Integer certificateId) {
        this.certificateId = certificateId;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
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
