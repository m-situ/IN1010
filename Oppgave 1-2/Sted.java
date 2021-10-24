public class Sted {
	private String beskrivelse;
	private Skattkiste kiste;
	private Sted nesteSted;

	/**
	 * Oppretter et sted med gitt beskrivelse en en tom skattekiste.
	 *
	 * @param beskrivelse navnet til dette stedet
	 */
	public Sted(String beskrivelse) {
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
}
