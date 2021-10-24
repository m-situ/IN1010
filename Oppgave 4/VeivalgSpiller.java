

import java.util.List;

public class VeivalgSpiller extends Spiller {

	public VeivalgSpiller(String navn, Sted sted, Brukergrensesnitt grenesnitt, List<Gjenstand> gjenstandList) {
		super(navn, sted, grenesnitt, gjenstandList);


	}

	@Override
	public void nyttTrekk(int flytt) {
		switch (flytt) {

		// her skal det ga til neste tilfeldigvalg venstre, hoyre, foran nabo
		}
	}



}
