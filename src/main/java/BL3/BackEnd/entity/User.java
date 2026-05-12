package BL3.BackEnd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "User")
public class User {

    @Column(name = "first_name")
    private String FirstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    //Double????? pesquisar depois
    @Column(name = "moneyAmount")
    private double moneyAmount;

}
