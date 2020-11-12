package it.unimi.di.prog2.blackjack;

public class SicuroStrategy implements Strategia {
    final private Strategia next;
    final private Sfidante sfidante;

    //@pre next!=null && sfidante!=null
    public SicuroStrategy(Strategia next, Sfidante sfidante){
        assert next!=null && sfidante!=null;
        this.next=next;
        this.sfidante=sfidante;
    }

    @Override
    public boolean chiediCarta() {
        int punti=sfidante.getPunti();
        if(punti<=16){
            return true;
        }else{
            return next.chiediCarta();
        }

    }
}
