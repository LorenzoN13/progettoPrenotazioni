package it.epicode.progetto.service;

import it.epicode.progetto.bean.Prenotazione;
import it.epicode.progetto.bean.Utente;
import it.epicode.progetto.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public void salvaPrenotazione(Prenotazione prenotazione){

        prenotazioneRepository.save(prenotazione);
    }

    public void aggiornaPrenotazione(Prenotazione prenotazione){
        Prenotazione p = prenotazioneRepository.findById(prenotazione.getId()).get();
        p.setDataPrenotazione(prenotazione.getDataPrenotazione());
        p.setPostazione(prenotazione.getPostazione());
        p.setUtente(prenotazione.getUtente());
        prenotazioneRepository.save(p);
    }

    public Prenotazione cercaPrenotazionePerId(int id){

        return prenotazioneRepository.findById(id).get();
    }

    public void canellaPrenotazione(int id) {
        prenotazioneRepository.deleteById(id);
    }

    public boolean dataValidità(LocalDate dataPrenotazione){
        LocalDate dataOggi = LocalDate.now();

        return dataPrenotazione.isAfter(dataOggi) || dataPrenotazione.isEqual(dataOggi);
    }

    public boolean prenotazioneValida(Prenotazione prenotazione){
        return dataValidità(prenotazione.getDataPrenotazione());
    }

    public boolean utenteHaGiaPrenotato(Utente utente, LocalDate dataPrenotazione){
        return prenotazioneRepository.existsByUtenteAndDataPrenotazione(utente,dataPrenotazione);
    }

}
