package giuseppelongo.u5d5progetto.runners;

import giuseppelongo.u5d5progetto.entities.Edificio;
import giuseppelongo.u5d5progetto.entities.Postazione;
import giuseppelongo.u5d5progetto.entities.Prenotazione;
import giuseppelongo.u5d5progetto.entities.Utente;
import giuseppelongo.u5d5progetto.enums.TipoPostazione;
import giuseppelongo.u5d5progetto.repositories.EdificioRepository;
import giuseppelongo.u5d5progetto.repositories.PostazioneRepository;
import giuseppelongo.u5d5progetto.repositories.PrenotazioneRepository;
import giuseppelongo.u5d5progetto.repositories.UtenteRepository;
import giuseppelongo.u5d5progetto.services.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class StartupRunner implements CommandLineRunner {

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private EdificioRepository edificioRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Override
    public void run(String... args) throws Exception {
        // Creazione e salvataggio degli edifici
        Edificio edificio1 = new Edificio(UUID.randomUUID(), "Edificio A", "Via Roma 1", "Milano");
        Edificio edificio2 = new Edificio(UUID.randomUUID(), "Edificio B", "Via Milano 2", "Roma");
        Edificio edificio3 = new Edificio(UUID.randomUUID(), "Edificio C", "Via Catania 2", "Catania");
        Edificio edificio4 = new Edificio(UUID.randomUUID(), "Edificio C", "Via Torino 45", "Torino");
        //edificioRepository.save(edificio4);
        //edificioRepository.save(edificio2);

        // Creazione e salvataggio delle postazioni
        Postazione postazione1 = new Postazione(UUID.randomUUID(), "P01", "Postazione privata 1", TipoPostazione.PRIVATO, 1, edificio1);
        Postazione postazione2 = new Postazione(UUID.randomUUID(), "P02", "Postazione openspace 1", TipoPostazione.OPENSPACE, 4, edificio2);
        Postazione postazione3 = new Postazione(UUID.randomUUID(), "P07", "Postazione privata 1", TipoPostazione.PRIVATO, 1, edificio3);
        //postazioneRepository.save(postazione1);
        //postazioneRepository.save(postazione3);

        // Creazione e salvataggio degli utenti
        Utente utente1 = new Utente(UUID.randomUUID(), "mrossi", "Mario Rossi", "mario.rossi@example.com");
        Utente utente2 = new Utente(UUID.randomUUID(), "lbianchi", "Luca Bianchi", "luca.bianchi@example.com");
        Utente utente3 = new Utente(UUID.randomUUID(), "fbatti", "Franco Battiato", "franco@example.it");
        Utente utente4 = new Utente(UUID.randomUUID(), "giancac", "Giancarlo Conti", "gianca.c@example.it");
        //utenteRepository.save(utente1);
        //utenteRepository.save(utente4);

        // Test di prenotazione
        Prenotazione prenotazione = Prenotazione.builder()
                .id(UUID.randomUUID())
                .utente(utente3)
                .postazione(postazione1)
                .dataPrenotazione(LocalDate.now())
                .build();
        try {
            prenotazioneRepository.save(prenotazione);
            System.out.println("Prenotazione effettuata con ID: " + prenotazione.getId());
        } catch (Exception e) {
            System.out.println("Errore nella prenotazione: " + e.getMessage());
        }
    }
}
