public class Gjenstand {
	public String navn;
	public int verdi;

	public Gjenstand(String navn, int verdi) {
		this.navn = navn;
		this.verdi = verdi;
	}


	public String hentNavn() {
		return navn;
	}

	public int hentVerdi() {
		return verdi;
	}
}
