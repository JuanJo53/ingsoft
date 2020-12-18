package bo.ucb.edu.ingsoft.dto;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;

public class UserUpdate {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Surname is mandatory")
    private String surname;

    @NotBlank(message = "Username is mandatory")
    private String username;

    @NotBlank(message = "Email is required")
    @Email
    private String email;
    private String description;
    private String image;

    @Max(value=99999999, message="must be a number")
    @Size(min = 7, max = 20, message
            = "About Me must be between 7 and 20 characters")
    private String cellphone;

    public UserUpdate() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
}
