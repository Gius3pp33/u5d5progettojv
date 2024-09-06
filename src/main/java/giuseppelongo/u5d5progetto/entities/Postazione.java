package giuseppelongo.u5d5progetto.entities;

import giuseppelongo.u5d5progetto.enums.TipoPostazione;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Postazione {

    @Id

    private UUID id;

    @Column(unique = true, nullable = false)
    private String codiceUnivoco;

    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoPostazione tipo;

    private int numeroMaxOccupanti;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;
}
