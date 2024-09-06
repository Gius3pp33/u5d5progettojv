package giuseppelongo.u5d5progetto.repositories;

import giuseppelongo.u5d5progetto.entities.Postazione;
import giuseppelongo.u5d5progetto.entities.Prenotazione;
import giuseppelongo.u5d5progetto.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, UUID> {
    boolean existsByUtenteAndDataPrenotazione(Utente utente, LocalDate dataPrenotazione);

    boolean existsByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate dataPrenotazione);
}
