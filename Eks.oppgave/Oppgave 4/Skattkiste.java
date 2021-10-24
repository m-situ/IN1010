

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Skattkiste {
	ArrayList<Gjenstand> gjenstander = new ArrayList<Gjenstand>();
	Random rand = new Random();

	public Skattkiste() {
	}


	public void leggGjenstand(List<Gjenstand> gs) {
		//velger aa gi plass til 10 items
		for(int i= 0;i< 10; i++) {
			int tempG = rand.nextInt(gs.size());
			gjenstander.add(gs.get(tempG));
		}
	}


	public Gjenstand fjern() {
		if (gjenstander.size() == 0) {
			return null;
		}
		int tempG = rand.nextInt(gjenstander.size());
		Gjenstand g = gjenstander.get(tempG);
		gjenstander.remove(tempG);
		return g;
	}




	public int selg (Gjenstand gjenstand) {
		//salgspris er ikke veldig magisk i dette tilfellet
		gjenstander.add(gjenstand);
		int tempItem = rand.nextInt(100)+50;
		int v = gjenstand.hentVerdi();
		int verdi = (int) (v*tempItem*0.01);
		return verdi;
	}


	public int size() {
		return gjenstander.size();
	}







}
