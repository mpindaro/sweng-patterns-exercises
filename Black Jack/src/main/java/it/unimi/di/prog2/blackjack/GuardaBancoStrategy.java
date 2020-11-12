package it.unimi.di.prog2.blackjack;

public class GuardaBancoStrategy implements Strategia {

    final private Strategia next;
    final private Sfidante sfidante;

    //@pre  next!=null && sfidante !=null
    public GuardaBancoStrategy(Strategia next, Sfidante sfidante){
        assert next!=null && sfidante!=null;
        this.next=next;
        this.sfidante=sfidante;
    }

    @Override
    public boolean chiediCarta() {
        int punteggiobanco=sfidante.getPuntiBanco();
        if (sfidante.getPunti() > punteggiobanco)
            return next.chiediCarta();
        else
            return true;
    }
}
