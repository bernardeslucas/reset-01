package objects;

import java.time.LocalDate;

public class User {
    /*   O e-mail não pode repetir
       O usuário deve ter mais de 18 anos de idade
       Todos os campos são obrigatórios
   Dados de um usuário:
   Id
   Nome
   Email
   Telefone
   Data de Nascimento
   Bio
   Localização:
   Latitude
   Longitude
     */
    private int id;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private String bio;
    private double latitude, longitude;

    public User(String name, String email, String phone, LocalDate birthDate, String bio, double latitude, double longitude) {
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Pessoa[ "+
                "id: '"+id+
                "Nome: '"+name+
                "E-mail: '"+email+
                "Telefone: '"+phone+
                "Data de nascimento: '"+birthDate+
                "Bio: '"+bio+
                "Localização: '"+latitude+", "+longitude+"']";


    }
}
