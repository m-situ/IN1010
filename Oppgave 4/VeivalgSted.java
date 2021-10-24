
import java.util.List;
import java.util.Random;

public class VeivalgSted extends Sted {


	public VeivalgSted(String beskrivelse) {
		super(beskrivelse);
	}

	@Override
	public void settUtgang( Sted[] sted) {
			utgang = sted;

	}

	public hentString(){
		return hoyre;
		//venstre
		//foran
	}



}
