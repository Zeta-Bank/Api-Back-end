package BL3.BackEnd.pix;

import BL3.BackEnd.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "pix_key_table")
public class Pix {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @Column(name = "key")
    private String key;


    @Override
    public String toString() {
        return "Pix{" +
                "id=" + id +
                ", idUser=" + user +
                ", key='" + key + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getIdUser() {
        return user;
    }

    public void setIdUser(User idUser) {
        this.user = idUser;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
