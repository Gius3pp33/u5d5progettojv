package giuseppelongo.u5d5progetto.repositories;

import giuseppelongo.u5d5progetto.entities.Postazione;
import giuseppelongo.u5d5progetto.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, UUID> {
    List<Postazione> findByTipoAndEdificio_Citta(TipoPostazione tipo, String citta);
}
