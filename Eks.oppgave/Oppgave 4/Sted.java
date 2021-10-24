
import java.util.List;

public class Sted {
	protected String beskrivelse;
	protected Skattkiste kiste;
	protected Sted nesteSted;
	protected Sted[] utgang;
//	protected String hoyre = "hoyre";
//	protected String venstre = "venstre";
//	protected String rettFrem = "rettFrem";


	/**
	 * Oppretter et sted med gitt beskrivelse en en tom skattekiste.
	 *
	 * @param beskrivelse navnet til dette stedet
	 */
	public Sted (String beskrivelse) {
		this.beskrivelse= beskrivelse;
		this.kiste = new Skattkiste();
	}


	public Skattkiste kiste() {
		return kiste;
	}

	public Sted nesteSted() {
		return nesteSted;
	}

	public void settNesteSted(Sted nesteSted) {
		this.nesteSted = nesteSted;
	}

	public String beskrivelse() {
		return beskrivelse;
	}

	public void settUtgang(List<Sted> sted) {}

	public void settUtgang(Sted[] sted) {	}



}//class
