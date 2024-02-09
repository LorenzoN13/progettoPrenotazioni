package it.epicode.progetto.bean;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String codiceUnivoco;

    private String descrizione;


    @Enumerated(EnumType.STRING)
    private TipoPostazione tipoPostazione;

    private int maxOccupanti;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

}
