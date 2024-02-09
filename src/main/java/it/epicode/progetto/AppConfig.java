package it.epicode.progetto;


import it.epicode.progetto.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;


@Configuration
public class AppConfig {

    @Bean("edificio")
    public Edificio edificio(){
        Edificio edificio = new Edificio();
        edificio.setNome("TrustCompany&co");
        edificio.setCitta("Roma");
        edificio.setInidrizzo("Via nussuna, nussuno");
        return edificio;
    }
    @Bean("lorenzo")
    public Utente lorenzo(){
        Utente utente1 = new Utente();
        utente1.setNome("Lorenzo");
        utente1.setCongnome("Rossi");
        utente1.setUsermane("Lorenzo_$");
        utente1.setEmail("loren@example.it");
        return utente1;
    }

    @Bean("postazione")
    public Postazione postazione1(){
        Postazione postazione = new Postazione();
        postazione.setCodiceUnivoco("456745375");
        postazione.setTipoPostazione(TipoPostazione.SALA);
        postazione.setDescrizione("La migliore popstazione con angolo vista lago.");
        postazione.setMaxOccupanti(2);
        postazione.setEdificio(edificio());
        return postazione;
    }

    @Bean("prenotazione")
    public Prenotazione prenotazione(){
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setUtente(lorenzo());
        prenotazione.setPostazione(postazione1());
        prenotazione.setDataPrenotazione(LocalDate.of(2024,02,10));

        return prenotazione;
    }

}
