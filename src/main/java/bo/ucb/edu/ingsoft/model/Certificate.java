package bo.ucb.edu.ingsoft.model;

import java.util.Date;
public class Certificate {
    private Integer certificateId;
    private Integer userId;
    private String name;
    private String company;
    private Date expeditionDate;
    private String credentialId;
    private String credentialURL;
    private Date expirationDate;
    private Integer status;
    private Transaction transaction;

    public Certificate() {
        transaction=new Transaction();
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "certificateId=" + certificateId +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", expeditionDate=" + expeditionDate +
                ", credentialId='" + credentialId + '\'' +
                ", credentialURL='" + credentialURL + '\'' +
                ", date=" + expirationDate +
                ", txId=" + transaction.getTxId() +
                ", txHost=" + transaction.getTxHost() +
                ", txUserId=" + transaction.getTxUserId() +
                ", txDate=" + transaction.getTxDate() +
                '}';
    }

    public Integer getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(Integer certificateId) {
        this.certificateId = certificateId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
