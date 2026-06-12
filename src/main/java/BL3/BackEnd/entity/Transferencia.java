package BL3.BackEnd.entity;

import aj.org.objectweb.asm.commons.JSRInlinerAdapter;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "transferencias_pix_table")
public class Transferencia /* implements UserDevice*/{

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
}
