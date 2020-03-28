package objects;

import java.time.LocalDate;

public class User {

    private int id;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private String bio;
    private Double latitude = null, longitude = null;

    public User(String name, String email, String phone, LocalDate birthDate, String bio, Double latitude, Double longitude) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.bio = bio;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Pessoa[" +
                "id: '" + id +
                "' Nome: '" + name +
                "' E-mail: '" + email +
                "' Telefone: '" + phone +
                "' Data de nascimento: '" + birthDate +
                "' Bio: '" + bio +
                "' Localização: '" + latitude + ", " + longitude + "']";


    }
}
