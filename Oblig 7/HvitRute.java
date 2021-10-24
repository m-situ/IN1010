import javafx.scene.paint.Color;


class HvitRute extends Rute {

  public HvitRute(Labyrint labyrint, int rad, int kolonne){
    super(labyrint, rad, kolonne);
  }

  @Override
  public char tilTegn(){
    return '.';
  }

  @Override
  public boolean erAapning(){
    return false;
  }

  @Override
  public String toString(){
    return String.format("(%d, %d)" , kolonne, rad);
  }

  @Override
  public void gaa(Rute forrige, String vei){
    // if(besokt) return;
    // besokt = true;
    //
    vei += "(" + kolonne + "," + rad + ")" + "-->";

    if(nord != forrige) nord.gaa(this, vei);
    if(ost != forrige) ost.gaa(this, vei);
    if(syd != forrige) syd.gaa(this, vei);
    if(vest != forrige) vest.gaa(this, vei);

  }

}//class
