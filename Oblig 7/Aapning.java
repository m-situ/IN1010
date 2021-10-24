class Aapning extends HvitRute{
    public Aapning(Labyrint labyrint, int rad, int kolonne){
      super(labyrint, rad, kolonne);
    }

    @Override
    public boolean erAapning(){
      return true;
    }

    // @Override
    // public char tilTegn(){
    //   return '-';
    // }

    @Override
    public String toString(){
        return String.format("(%d, %d)" , kolonne, rad);
    }

    public void gaa(Rute forrige, String vei){
      vei += "(" + kolonne + "," + rad + ")" ;
      labyrint.utveier.leggTil(vei);
    }

}
