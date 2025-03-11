package mk.finki.ukim.mk.lab1.model.dto;

import lombok.Data;

@Data
public class AuthorDto {
    private String name;

    private String surname;

    private Long countryId;

    public AuthorDto(String name, String surname, Long countryId) {
        this.name = name;
        this.surname = surname;
        this.countryId = countryId;
    }

    public AuthorDto() {}

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }
}
