package it.unimi.di.prog2.esame.view;

import it.unimi.di.prog2.esame.model.TicketModel;
import it.unimi.di.prog2.esame.model.Ticket;
import it.unimi.di.prog2.esame.observer.Subject;

public interface RoleStrategy {
  void incNumber(TicketModel m);

  int getNumber(Subject<Ticket> m);
}

//TODO: implementare due strategie CustomerRole e ClerkRole che associate alla vista DisplayView permettano
//     di differenziare il funzionamento del bottone e del display della stessa implementando le operazioni
//     incNumber e getNumber in maniera opportuna
//     come derivabile anche dalla classe Main, tali strategie devono essere implementate seguendo il pattern SINGLETON
