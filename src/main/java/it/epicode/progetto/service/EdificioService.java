package it.epicode.progetto.service;

import it.epicode.progetto.bean.Edificio;
import it.epicode.progetto.repository.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdificioService {
    @Autowired
    private EdificioRepository edificioRepository;

    public void salvaEdificio(Edificio edificio){

        edificioRepository.save(edificio);
    }

    public void aggiornaEdificio(Edificio edificio){
        Edificio e = edificioRepository.findById(edificio.getId()).get();
        e.setNome(edificio.getNome());
        e.setInidrizzo(edificio.getInidrizzo());
        e.setCitta(edificio.getCitta());
        edificioRepository.save(e);
    }

    public Edificio cercaEdificioPerId(int id){
        return  edificioRepository.findById(id).get();
    }

    public void canellaEdificio(int id){
        edificioRepository.deleteById(id);
    }
}
