package br.com.cwi.tinderevolution.domain.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private int id;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private String bio;
    private Double latitude;
    private Double longitude;
    private String photoUrl;

    private UserDTO(int id, String name, String email, String phone, LocalDate birthDate, String bio, Double latitude, Double longitude, String photoUrl) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.bio = bio;
        this.latitude = latitude;
        this.longitude = longitude;
        this.photoUrl = photoUrl;
    }

    public static UserDTO transform(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getPhone(),
                user.getBirthDate(), user.getBio(), user.getLatitude(), user.getLongitude(), user.getPhotoUrl());
    }

    public static List<UserDTO> transformList(List<User> list) {
        List<UserDTO> listDTO = new ArrayList<>();
        for (User user : list) {
            listDTO.add(transform(user));
        }
        return listDTO;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getBio() {
        return bio;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

}
