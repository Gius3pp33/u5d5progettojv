package giuseppelongo.u5d5progetto.services;

import giuseppelongo.u5d5progetto.entities.Postazione;
import giuseppelongo.u5d5progetto.entities.Prenotazione;
import giuseppelongo.u5d5progetto.entities.Utente;
import giuseppelongo.u5d5progetto.exceptions.BookingConflictException;
import giuseppelongo.u5d5progetto.repositories.PostazioneRepository;
import giuseppelongo.u5d5progetto.repositories.PrenotazioneRepository;
import giuseppelongo.u5d5progetto.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PrenotazioneService {

    private final PrenotazioneRepository prenotazioneRepository;
    private final PostazioneRepository postazioneRepository;
    private final UtenteRepository utenteRepository;

    @Autowired
    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository, PostazioneRepository postazioneRepository, UtenteRepository utenteRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
        this.postazioneRepository = postazioneRepository;
        this.utenteRepository = utenteRepository;
    }

    public Prenotazione prenota(Utente utente, Postazione postazione, LocalDate dataPrenotazione) throws BookingConflictException {
        // Controlla se l'utente ha già prenotato una postazione per quella data
        if (prenotazioneRepository.existsByUtenteAndDataPrenotazione(utente, dataPrenotazione)) {
            throw new BookingConflictException("L'utente ha già una prenotazione per questa data.");
        }

        // Controlla se la postazione è già prenotata per quella data
        if (prenotazioneRepository.existsByPostazioneAndDataPrenotazione(postazione, dataPrenotazione)) {
            throw new BookingConflictException("La postazione è già prenotata per questa data.");
        }

        Prenotazione prenotazione = Prenotazione.builder()
                .utente(utente)
                .postazione(postazione)
                .dataPrenotazione(dataPrenotazione)
                .build();

        return prenotazioneRepository.save(prenotazione);
    }
}
