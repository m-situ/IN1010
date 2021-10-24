import java.util.*;
import java.io.*;

class Labyrint{
  private Rute [][] labyrint;
  protected int rader;
  protected int kolonne;
  //for a lagre alle utveier
  Liste <String> utveier;

  private Labyrint(Rute [][] labyrint, int rader, int kolonne ){
    this.labyrint = labyrint;
    this.rader = rader;
    this.kolonne = kolonne;
  }



  public int hentRader(){
    return rader;
  }

  public int hentKolonne(){
    return kolonne;
  }

  public int hentAntRader(){
    int ant = 0;
    for (int r= 0;  r < rader; r++){
      ant ++;
    }//r
    return ant;
  }

  public int hentAntKolonne(){
    int antK = 0;
    for (int r= 0;  r < kolonne; r++){
      antK ++;
    }//r
    return antK;
  }

  //for aa returnere plassen
  public Rute hentRute(int rad, int kolonne){
    return labyrint[rad][kolonne];
  }

  public Rute[][] hentLabyrint(){
    return labyrint;
  }



  public String toString(){
    String lab = "";
    for (int r= 0;  r < rader; r++){
      for( int k = 0; k < kolonne; k++){
        lab += (labyrint[r][k].tilTegn() );
      }//k
      lab += "\n";
    }//r
    return lab;
  }


//Denne - OK
  public static Labyrint lesFraFil(File fil) throws FileNotFoundException {
      Scanner scanner = new Scanner(fil);
      //rad- kolonne
      String[] data = scanner.nextLine().split(" "); //forste linje for strl til labyrinten
      int antRader = Integer.parseInt(data[0]);
      int antKolonner = Integer.parseInt(data[1]);

      //oppretter ruter
      Rute[][] tempArray = new Rute[antRader][antKolonner];

      int tempRad = 0;
      Labyrint labyrint = new Labyrint(tempArray, antRader, antKolonner);

      Character temp;
      while(scanner.hasNextLine()) {   //les inn resten
        String scan = scanner.nextLine();
        for(int k = 0; k < antKolonner; k++) {
          temp = new Character(scan.charAt(k));
          if(temp.equals('.') ){
            if(erKant(tempRad, k, antRader, antKolonner)){
              tempArray[tempRad][k] = new Aapning(labyrint,tempRad, k);
            }else{
              tempArray[tempRad] [k] = new HvitRute(labyrint,tempRad, k);
            }
          }else if(temp.equals('#')){
            tempArray[tempRad][k] = new SortRute(labyrint, tempRad, k);
          }
        }
        tempRad++;
      }//while

      for(int r = 0; r < antRader; r++){
        for(int k = 0; k < antKolonner; k++){
          tempArray[r][k].leggNabo(tempArray, antRader, antKolonner);
        }
      }

        System.out.println(labyrint.toString()); //test
         return labyrint;
    }//lesFraFil



//hjelpemetode for aa sjekke en aapning
  public static boolean erKant(int rad, int kolonne, int antRader, int antKolonne){
    if(rad ==0 || kolonne ==0 || rad== (antRader-1) || kolonne == (antKolonne-1)){ //kanten
      return true;
    }else{
      return false;
    }
  }//erApning



//midlertidig
  Liste<String> finnUtveiFra(int kolonne, int rad){
    utveier = new Lenkeliste<String>();
    labyrint[rad][kolonne].finnUtvei();
    return utveier;
    // return null;
  }





}//class
