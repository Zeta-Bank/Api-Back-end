package BL3.BackEnd.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "pix_key_table")
public class Pix /*implements UserService*/ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "id_user")
    private int idUser;

    @Column(name = "key")
    private String key;
}
