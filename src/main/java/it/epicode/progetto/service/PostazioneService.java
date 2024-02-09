package it.epicode.progetto.service;

import it.epicode.progetto.bean.Edificio;
import it.epicode.progetto.bean.Postazione;
import it.epicode.progetto.bean.TipoPostazione;
import it.epicode.progetto.repository.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneRepository postazioneRepository;

    public void salvaPostazione(Postazione postazione){

        postazioneRepository.save(postazione);
    }

    public void aggiornaPostazione(Postazione postazione){
        Postazione p = postazioneRepository.findById(postazione.getId()).get();
        p.setCodiceUnivoco(postazione.getCodiceUnivoco());
        p.setDescrizione(postazione.getDescrizione());
        p.setTipoPostazione(postazione.getTipoPostazione());
        p.setMaxOccupanti(postazione.getMaxOccupanti());
        p.setEdificio(postazione.getEdificio());
        postazioneRepository.save(p);
    }

    public Postazione cercaPostazionePerId(int id){

        return  postazioneRepository.findById(id).get();
    }

    public void canellaPostazione(int id) {
        postazioneRepository.deleteById(id);
    }

    public List<Postazione> ricercaPostazioni(TipoPostazione tipoPostazione, String citta) {
        if (tipoPostazione != null && citta != null) {
            return postazioneRepository.findByTipoPostazioneAndEdificio_Citta(tipoPostazione, citta);
        } else if (citta != null) {
            return postazioneRepository.findByEdificio_Citta(citta);
        } else {

            return postazioneRepository.findAll();
        }
    }
}
