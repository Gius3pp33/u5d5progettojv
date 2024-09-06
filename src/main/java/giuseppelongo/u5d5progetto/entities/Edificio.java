package giuseppelongo.u5d5progetto.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class Edificio {

    @Id

    private UUID id;

    private String nome;
    private String indirizzo;
    private String citta;
}
