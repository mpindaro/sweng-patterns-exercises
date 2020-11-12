package it.unimi.di.prog2.blackjack;

public class IngordoStrategy implements Strategia {

    final private Sfidante sfidante;
    final private Strategia next;

    //@pre  next!=null && sfidante !=null
    public IngordoStrategy(Strategia next, Sfidante sfidante) {
        assert next!=null && sfidante !=null;
        this.next=next;
        this.sfidante = sfidante;
    }


    @Override
    public boolean chiediCarta() {
        if(sfidante.getPunti()<21){
            return true;
        }else{
            return next.chiediCarta();
        }

    }
}
