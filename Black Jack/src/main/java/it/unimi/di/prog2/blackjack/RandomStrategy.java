package it.unimi.di.prog2.blackjack;

//TODO spiegare in poche righe di commento se ha senso concatenare una dopo l'altra due strategie Random
//No dato che la possibilità è del 50%, anche se chiamato due volte essa non cambierà.
//Non ha senso concatenare una dopo l'altra due strategie random dato che nè si forza la scelta di uno o dell'altro nè si cambiano le probabilità di uscita di una delle due possibilità.
public class RandomStrategy implements Strategia {
  final private Strategia next;

  //@pre next != null
  public RandomStrategy(Strategia next) {
    assert next != null : "se si usa NullObject Pattern non si ha mai strategia 'null'";
    this.next = next;
  }

  @Override
  public boolean chiediCarta() {
    if (Math.random() > 0.5)
      return true;
    return next.chiediCarta();
  }
}
