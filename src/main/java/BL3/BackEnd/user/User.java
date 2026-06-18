package BL3.BackEnd.user;

import BL3.BackEnd.pix.Pix;
import BL3.BackEnd.transferencia.Transferencia;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "money_amount")
    private BigDecimal moneyAmount;

    @OneToMany(mappedBy = "user")
    private List<Pix> pixKeys;

    @OneToMany(mappedBy = "idRemetente")
    private List<Transferencia> remetenteTransferencia;

    @OneToMany(mappedBy = "idDestinatario")
    private List<Transferencia> destinatarioTransferencia;


    @Override
    public String toString() {
        return "User{" +
                "FirstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", moneyAmount=" + moneyAmount +
                '}';
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public List<Pix> getPixKeys() {
        return pixKeys;
    }

    public void setPixKeys(List<Pix> pixKeys) {
        this.pixKeys = pixKeys;
    }

    public List<Transferencia> getRemetenteTransferencia() {
        return remetenteTransferencia;
    }

    public void setRemetenteTransferencia(List<Transferencia> remetenteTransferencia) {
        this.remetenteTransferencia = remetenteTransferencia;
    }

    public List<Transferencia> getDestinatarioTransferencia() {
        return destinatarioTransferencia;
    }

    public void setDestinatarioTransferencia(List<Transferencia> destinatarioTransferencia) {
        this.destinatarioTransferencia = destinatarioTransferencia;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(BigDecimal moneyAmount) {
        this.moneyAmount = moneyAmount;
    }
}
