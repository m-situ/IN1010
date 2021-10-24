import java.io.*;
import java.util.*;



//FIFO
class Lenkeliste<T> implements Liste<T> {

  //Node-klasse
  public class Node{
    Node neste;
    Node forrige;
    T data;

    public Node(T x) {
      this.data = x;
    }
  }//slutt node class




public class LenkelisteIterator implements Iterator<T>{
    private Liste<T> iListe;
    private int indeks = 0;

    public LenkelisteIterator(Liste<T> lx){
      iListe = lx;
    }


    public boolean hasNext(){
      return indeks<iListe.stoerrelse();
    }


    public T next(){
      return iListe.hent(indeks++);
    }


    public void remove(){ /*Implementerer ikke denne.*/
      throw new UnsupportedOperationException();
    }
  }

  public LenkelisteIterator iterator(){
    return new LenkelisteIterator(this);
  }




  protected Node start;
  protected Node slutt;
 //ny for a telle noder
  protected int antNoder = 0;

  //sette inn paa slutten av listen
  public void leggTil(T x){
    Node ny = new Node(x);
    //hvis det er tomt liste legge til noden
    if(start == null ){
        start = ny;
    }else{
      //hvis det ikke er tomt, sett temp som start
      slutt.neste = ny;
      ny.forrige = slutt;
    }
    slutt = ny;
    antNoder++;

  }//leggTil



//fjern den foerte og returnerer
  public T fjern() {
    //gi feilmelding hvis vi fjener fra en tomt liste
      if(start == null){
        throw new UgyldigListeIndeks(0);
      }else{
        //sett neste som foerste
        Node temp = start;
        T fjern = temp.data;
        start = temp.neste;
        antNoder--;
        return temp.data;
      }
  }




  //sette inn element paa en gitt posisjon, overskriver
    public void sett(int pos, T x) {
      Node temp = this.hentNode(pos);
      temp.data = x;

    }//sett erstatter




    //legger til og skyver ett hakk bak
    public void leggTil(int pos, T x) {
      Node ny = new Node(x);

      if(pos > this.stoerrelse() || pos < 0){
        throw new UgyldigListeIndeks(pos);
      } else if ( this.stoerrelse() == 0){     //hvis listen er tomt
        start = ny;
        slutt = ny;
        antNoder++;
      } else if (pos == 0){    //hvis skal settes paa starten
        ny.neste = start;
        start.forrige = ny;
        start = ny;
        antNoder++;
        } else if (pos == this.stoerrelse() ){   //hvis skal settes paa slutten
        leggTil(x);
      } else {  //ellers legge til mellom to noder
        Node temp = start;

          for(int i = 0; i< pos; i++){
            temp = temp.neste;
          }
            Node tempFor = temp.forrige;
            tempFor.neste = ny;
            ny.forrige = tempFor;
            ny.neste = temp;
            temp.forrige = ny;
            antNoder++;
        }

    }//leggTil





        //fjerner pa gitt indeks
        public T fjern(int pos) {
          Node fjern = this.hentNode(pos);

          //samme som legge til, unntak at man kan ikke fjerner noder fra en tom liste
          if( pos < 0 ||  pos >= this.stoerrelse() || this.stoerrelse() == 0) {
            throw new UgyldigListeIndeks(pos-1);
          } else if(this.stoerrelse() == 1){ //hvis vi fjerner det eneste noden
            start = null;
            slutt = null;
            antNoder--;
          } else if(pos == 0){ //hvis vi fjerner fra starten
            start = fjern.neste;
            Node fjernNeste = fjern.neste;
            fjern.forrige = null;
            antNoder--;
          } else if(pos == this.stoerrelse() -1){ //fjerner siste
            Node fjernFor = fjern.forrige;
            slutt = fjernFor;
            fjernFor.neste = null;
            antNoder--;
          } else { //midten
            Node fjernFor = fjern.forrige;
            Node fjernNest = fjern.neste;
            fjernFor.neste = fjernNest;
            fjernNest.forrige = fjernFor;
            antNoder--;
          }
          return fjern.data;
        }




//returner stoerrelsen pa listen
   public int stoerrelse(){
      int teller =0;
      Node temp = start;
      while (temp != null){
        temp = temp.neste;
        teller ++;
      }
      return teller;
    } //stoerrelse




//hjelpe metode som returnerer en node
  protected Node hentNode( int pos) {
    //hvis pos er negativ eller stoerre enn antall gi feilmelding
    if(pos < 0 || pos > this.stoerrelse()-1){
      throw new UgyldigListeIndeks(pos);
    } else {
      Node temp = start;
      //les gjennom foran pos, returner data paa pos
      int t = 0;
      while(t != pos){
         temp = temp.neste;
         t++;
      }
      return temp;
    }

  }

//henter nodedata
  public T hent( int pos){
    return hentNode(pos).data;
  }







} //class
