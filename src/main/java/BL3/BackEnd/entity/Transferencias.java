package BL3.BackEnd.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "transferencias_pix_table")
public class Transferencias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "id_remetente")
    private int idRemetente;

    @Column(name = "id_destinatario")
    private int idDestinatario;

    @Column(name = "id_key_destinatario")
    private int idKeyDestinatario;

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

    public int getIdRemetente() {
        return idRemetente;
    }

    public void setIdRemetente(int idRemetente) {
        this.idRemetente = idRemetente;
    }

    public int getIdDestinatario() {
        return idDestinatario;
    }

    public void setIdDestinatario(int idDestinatario) {
        this.idDestinatario = idDestinatario;
    }

    public int getIdKeyDestinatario() {
        return idKeyDestinatario;
    }

    public void setIdKeyDestinatario(int idKeyDestinatario) {
        this.idKeyDestinatario = idKeyDestinatario;
    }

    public BigDecimal getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(BigDecimal moneyAmount) {
        this.moneyAmount = moneyAmount;
    }
}
