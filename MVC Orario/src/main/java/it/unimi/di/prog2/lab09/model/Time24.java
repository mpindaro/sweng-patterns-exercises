package it.unimi.di.prog2.lab09.model;

public class Time24 {
  //TODO dire in un breve commento se e perché questa classe risulta immmutabile o meno
  //La classe risulta essere immutabile dato i suoi attributi sono tutti sia privati che final
  //inoltre non vi sono metodi che modificano l'oggetto o che causino escaping references, infatti
  //gli unici getter che vi sono restituiscono tipi primitivi per quanto riguarda getHour() e getMin()
  // e oggetti immutabili nel caso invece di toString()

  private final int h24;
  private final int min;

  public Time24(int h24, int min) {
    assert 0 <= h24 && h24 < 24;
    assert 0 <= min && min < 60;
    this.h24 = h24;
    this.min = min;
  }

  public int getHour() {
    return h24;
  }

  public int getMin() {
    return min;
  }

  @Override
  public String toString() {
    return String.format("%02d:%02d", getHour(), getMin());

  }

  //TODO dire in un breve commento se e perché per questa classe serve definire i metodi
  // equals  e/o   hashCode
  //In un ipotetico caso in cui si voglia confrontare gli orari, premettendo che due ore sono uguali
  //se hanno lo stesso numero di ore e di minuti, allora è necessario ridefinirlo dato che se non
  //venisse fatto equals, semanticamente parlando, si riferirebbe alla identità degli oggetti e non
  //ai suoi valori. Per questo motivo anche hashCode andrebbe ridefinito dato che la documentazione
  //ufficiale "vincola" che due oggetti che risultano "equals" debbano avere lo stesso hashcode.
  //TODO se si è risposto che servono... implementarli

  @Override
  public boolean equals(Object object){
    if(object instanceof Time24) {
      Time24 time24 =(Time24)object;
      if (this.getHour() == time24.getHour() && this.getMin() == time24.getMin())
        return true;
    }
    return false;
  }

  @Override
  public int hashCode(){
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.getHour());
    stringBuilder.append(this.getMin());
    return Integer.parseInt(stringBuilder.toString());
  }
}
