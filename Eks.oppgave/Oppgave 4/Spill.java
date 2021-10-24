

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Spill {
    private static final int ANTALL_TREKK = 10;

    private final List<Spiller> spillere;

    Spill(List<Spiller> spillere) {
    	this.spillere = spillere;
    }

	  void spill() {
		  for (int i = 0; i < ANTALL_TREKK; i++) {
			  for(Spiller spiller : spillere) {
				  spiller.trekk();
			  }
		  }
		  spillere.sort(Comparator.comparing(Spiller::formue).reversed());
		  Spiller winner = spillere.get(0);
		  System.out.println("Winner er " + winner.navn() +  " med formue " + winner.formue());
		  System.out.println("Deltagere: " + spillere);
	}

	  public static void main(String[] args) throws FileNotFoundException {
		  	System.out.println("Eksamen IN1010 2020 v");
	    	Terreng terreng = new Terreng ("steder.txt");
	        List<Spiller> spillere = new ArrayList<Spiller>();
	        spillere.add(new Spiller("Bot", terreng.hentStart(), new Robot(), terreng.gjenstander()));
	        spillere.add(new Spiller( "Spiller",  terreng.hentStart(), new Terminal(new Scanner(System.in)), terreng.gjenstander()));

	        new Spill( spillere).spill();
	    }
}



