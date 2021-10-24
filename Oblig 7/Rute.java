
abstract class Rute {
  protected int rad;
  protected int kolonne;
  protected Labyrint labyrint;
  Rute nord;
  Rute syd;
  Rute vest;
  Rute ost;
  boolean besokt= false;


  public Rute(Labyrint labyrint, int rad, int kolonne){
    this.rad = rad;
    this.kolonne = kolonne;
    this.labyrint = labyrint;

  }


  abstract public char tilTegn();
  abstract public boolean erAapning();
  abstract public String toString();
  abstract public void gaa(Rute forrige, String vei);



  public void leggNabo(Rute[][] tempArray, int antRader, int antKolonner) {
    if(rad > 0) {
      nord = tempArray[rad-1][kolonne]; //opp
    }
    if(kolonne+1 < antKolonner ) {
      ost = tempArray[rad][kolonne+1]; //hoyre
    }
    if(rad+1 < antRader) {
      syd = tempArray[rad+1][kolonne]; //ned
    }
    if(kolonne > 0) {
      vest = tempArray[rad][kolonne-1]; //venstre
    }
  }



    //finn utvei paa den ruten vi er i
    public void finnUtvei(){
      gaa(null, "");
    }


    public int hentRuteRader(){
      return rad;
    }

    public int hentRuteKolonne(){
      return kolonne;
    }


}//class
