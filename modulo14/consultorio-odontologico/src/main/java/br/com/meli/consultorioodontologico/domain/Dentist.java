package br.com.meli.consultorioodontologico.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "dentists")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dentist")
    private Long id;

    private String name;

    @Column(name = "last_name")
    private String lastName;

    private String address;

    private String dni;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private String phone;

    private String email;

    @Column(name = "code_mp")
    private String codeMp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodeMp() {
        return codeMp;
    }

    public void setCodeMp(String codeMp) {
        this.codeMp = codeMp;
    }
}
