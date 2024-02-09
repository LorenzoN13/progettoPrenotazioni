package it.epicode.progetto.repository;

import it.epicode.progetto.bean.Postazione;
import it.epicode.progetto.bean.Prenotazione;
import it.epicode.progetto.bean.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface UtenteRepository extends JpaRepository<Utente,Integer> {
}
