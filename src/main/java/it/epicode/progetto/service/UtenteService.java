package it.epicode.progetto.service;

import it.epicode.progetto.bean.Postazione;
import it.epicode.progetto.bean.Utente;
import it.epicode.progetto.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;

    public void salvaUtente(Utente utente){

        utenteRepository.save(utente);
    }

    public void aggiornaUtente(Utente utente){
        Utente u = utenteRepository.findById(utente.getId()).get();
        u.setNome(utente.getNome());
        u.setCongnome(utente.getCongnome());
        u.setUsermane(utente.getUsermane());
        u.setEmail(utente.getEmail());
        utenteRepository.save(u);
    }

    public Utente cercaUtentePerId(int id){

       return utenteRepository.findById(id).get();
    }

    public void canellaUtente(int id) {
        utenteRepository.deleteById(id);
    }


}
