package it.epicode.progetto;

import it.epicode.progetto.bean.*;
import it.epicode.progetto.service.EdificioService;
import it.epicode.progetto.service.PostazioneService;
import it.epicode.progetto.service.PrenotazioneService;
import it.epicode.progetto.service.UtenteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private EdificioService edificioService;
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private PrenotazioneService prenotazioneService;
    @Autowired
    private UtenteService utenteService;

    private Logger logger = LoggerFactory.getLogger("progetto");

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Edificio edificio = ctx.getBean("edificio", Edificio.class);
        edificioService.salvaEdificio(edificio);

        Utente utente = ctx.getBean("lorenzo", Utente.class);
        utenteService.salvaUtente(utente);

        Postazione postazione= ctx.getBean("postazione", Postazione.class);
        postazioneService.salvaPostazione(postazione);

        Prenotazione p1 = ctx.getBean("prenotazione", Prenotazione.class);
        prenotazioneService.salvaPrenotazione(p1);


        logger.info("La prenotazione: " + p1);



//        try {
//            prenotazioneService.canellaPrenotazione(2);
//            utenteService.canellaUtente(1);
//            postazioneService.canellaPostazione(1);
//            edificioService.canellaEdificio(1);
//
//            logger.info("Eliminazione dei dati è stata eseguita con successo");
//
//        }catch (Exception e){
//            e.getMessage();
//        }


        List<Postazione> ricerca = postazioneService.ricercaPostazioni(TipoPostazione.SALA,"Roma");
        logger.info("Ecco la ricerca delle postazioni: " + ricerca.toString());


        Boolean prenotazioneValida = prenotazioneService.prenotazioneValida(p1);
        Boolean utenteHaGiaPrenotato = prenotazioneService.utenteHaGiaPrenotato(utente, LocalDate.of(2024,02,10));

        if (prenotazioneValida && !utenteHaGiaPrenotato){
            Prenotazione p2 = ctx.getBean("prenotazione", Prenotazione.class);
            prenotazioneService.salvaPrenotazione(p2);

            logger.info("Prenotazione effettuata con successo.");
        } else {
            logger.error("La prenotazione non è valida");
        }
    }
}
