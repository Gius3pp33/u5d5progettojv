package giuseppelongo.u5d5progetto.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Utente {

    @Id

    private UUID id;

    @Column(unique = true, nullable = false)
    private String username;

    private String nomeCompleto;

    @Column(unique = true, nullable = false)
    private String email;
}
