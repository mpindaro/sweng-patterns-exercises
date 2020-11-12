package it.unimi.di.prog2.esame.model;

import it.unimi.di.prog2.esame.observer.Observer;
import it.unimi.di.prog2.esame.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class TicketModel implements Subject<Ticket> {


  //TODO: implementare i due seguenti metodi utili a modificare lo stato del modello
  //     ATTENZIONE: serveNext modifica lo stato solo se ci sono clienti (ticket) in attesa non ancora serviti

  public void serveNext() { }

  public void getTicket() { }

  //TODO: Aggiungere attributi e implementare i metodi necessari a soddisfare la interfaccia Subject

}
