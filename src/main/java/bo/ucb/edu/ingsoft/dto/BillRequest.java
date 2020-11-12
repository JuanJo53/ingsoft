package bo.ucb.edu.ingsoft.dto;

import bo.ucb.edu.ingsoft.model.Transaction;

import java.util.Date;

public class BillRequest {
    private Date buyDate;
    private String billingAddress;
    private String country;
    private String city;
    private Integer status;


    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BillRequest{" +
                ", buyDate=" + buyDate +
                ", billingAddress='" + billingAddress + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", status=" + status +
                '}';
    }
}
