package BL3.BackEnd.transferencia;

import BL3.BackEnd.user.User;
import BL3.BackEnd.pix.Pix;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "transferencias_pix_table")
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_remetente")
    private User idRemetente;

    @ManyToOne
    @JoinColumn(name = "id_destinatario")
    private User idDestinatario;

    @ManyToOne
    @JoinColumn(name = "id_key_destinatario")
    private Pix idKeyDestinatario;

    @Column(name = "money_amount")
    private BigDecimal moneyAmount;


    @Override
    public String toString() {
        return "Transferencias{" +
                "id=" + id +
                ", idRemetente=" + idRemetente +
                ", idDestinatario=" + idDestinatario +
                ", idKeyDestinatario=" + idKeyDestinatario +
                ", moneyAmount=" + moneyAmount +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getIdRemetente() {
        return idRemetente;
    }

    public void setIdRemetente(User idRemetente) {
        this.idRemetente = idRemetente;
    }

    public User getIdDestinatario() {
        return idDestinatario;
    }

    public void setIdDestinatario(User idDestinatario) {
        this.idDestinatario = idDestinatario;
    }

    public Pix getIdKeyDestinatario() {
        return idKeyDestinatario;
    }

    public void setIdKeyDestinatario(Pix idKeyDestinatario) {
        this.idKeyDestinatario = idKeyDestinatario;
    }

    public BigDecimal getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(BigDecimal moneyAmount) {
        this.moneyAmount = moneyAmount;
    }
}
