package it.unimi.di.prog2.esame.view;

import it.unimi.di.prog2.esame.controller.Controller;
import it.unimi.di.prog2.esame.model.Ticket;
import it.unimi.di.prog2.esame.observer.Observer;

public interface TicketView extends Observer<Ticket> {
  void addHandler(Controller handler);
  RoleStrategy getRole();
}
