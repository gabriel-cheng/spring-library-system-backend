package com.example.library_system.domain.reader;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name="reader")
@Entity(name="reader")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="readerId")
public class Reader {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private String readerId;

    private String firstname;

    private String surname;

    private String cpf;

    private String email;

    private String cel;

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCel() {
        return this.cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public Reader(RequestReader requestReader) {
        this.firstname = requestReader.firstname();
        this.surname = requestReader.surname();
        this.cpf = requestReader.cpf();
        this.email = requestReader.email();
        this.cel = requestReader.cel();
    }

}
