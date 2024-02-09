package it.epicode.progetto.repository;

import it.epicode.progetto.bean.Postazione;
import it.epicode.progetto.bean.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione,Integer> {
    List<Postazione> findByTipoPostazioneAndEdificio_Citta(TipoPostazione tipoPostazione,String citta);
    List<Postazione> findByEdificio_Citta(String citta);
}
