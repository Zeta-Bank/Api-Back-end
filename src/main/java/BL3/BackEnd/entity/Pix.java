package BL3.BackEnd.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CollectionIdMutability;

@Entity
@Table(name = "pix_key_table")
public class Pix {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "id_user")
    private int idUser;

    @Column(name = "key")
    private String key;


    @Override
    public String toString() {
        return "Pix{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", key='" + key + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
