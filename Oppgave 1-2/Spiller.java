import java.util.List;

public class Spiller {
	public List<Gjenstand> gjenstandList;

	public String navn;

	public Sted sted;
	public Skattkiste ryggsekk= new Skattkiste();
	public Brukergrensesnitt grenesnitt;
	private int formue = 0; //begynner med 0 i formue



	public Spiller (String navn, Sted sted, Brukergrensesnitt grenesnitt,  List<Gjenstand> gjenstandList) {
		this.sted= sted;
		this.grenesnitt = grenesnitt;
		this.navn = navn;
		this.gjenstandList = gjenstandList;
		oppdaterFormue();
	}

	//oppdaterer formue
	public void oppdaterFormue() {

		//legger til verdi
		for(Gjenstand item : ryggsekk.gjenstander ) {
			formue +=item.hentVerdi();
		}
		System.out.print(" \n Navn : " + navn + " \n skattKiste : " + formue);


		for(Gjenstand gjenstand: ryggsekk.gjenstander) {
			System.out.print((gjenstand.navn)+" ");
		}
	}


	public void trekk() {
		System.out.println("\n" + navn + " -> " + sted.beskrivelse());
		String [] alter = {"selg til kisten","ta fra kisten","gaaVidere"};
		int flytt= grenesnitt.beOmKommando("Du fant en kiste, hva vil du gjore ?",alter);
		nyttTrekk(flytt);
	}

	//hjelpemetode
	public void nyttTrekk(int flytt) {
		switch (flytt) {
		//bruker kan velge mellom 3 da..
		case 0:
			//naar spiller vil selge skal formue oppdateres
			Gjenstand gjenstandFraRyggsek = ryggsekk.fjern();
			if(gjenstandFraRyggsek != null) {
				formue -= gjenstandFraRyggsek.verdi;
				System.out.print("\n Du selger: "+gjenstandFraRyggsek.navn+ ", Verdi: "+gjenstandFraRyggsek.verdi + ", Formue: " + formue);
				int verdi = sted.kiste().selg(gjenstandFraRyggsek);
				System.out.println("Legger til: "+ verdi );
				System.out.println("----------------------" );
				formue += verdi;
			}
			else {
				System.out.println("Ingenting aa selge");
				System.out.println("----------------------" );
			}
			break;
		case 1:
			//Not Sell
			 Gjenstand item = sted.kiste().fjern();
			 formue += item.verdi;
			 System.out.println("\n Legger til "+ item.navn+ " og formue: "+ formue );
			 System.out.println("----------------------" );
			 ryggsekk.selg(item);
			break;
		default:
			break;
		}
		sted = sted.nesteSted();
		System.out.println("----------------------" );
	}

	public int formue() {
		return formue;
	}

	public String navn() {
		return navn;
	}

	@Override
	public String toString() {
		return navn + " - " + formue + ",-";
	}

}

