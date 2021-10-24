class SortRute extends Rute {


  public SortRute(Labyrint labyrint, int rad, int kolonne){
    super(labyrint, rad, kolonne);
  }

  @Override
  public char tilTegn(){
    return '#';
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
  public void gaa(Rute forrige, String vei ){
    return;
  }


}//class
