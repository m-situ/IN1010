class SortertLenkeliste < T extends Comparable <T> > extends Lenkeliste <T>{

  public SortertLenkeliste(){
    super();
  }



    @Override
    public void leggTil(T x){
    Node ny = new Node(x);

    //sjekk om listen er tomt
    if (start == null){
      start = ny;
      slutt = ny;
    } else {
      Node tmp = start;
      T nyData = ny.data;

      //sorter etter stigende rekkefolge
        while(tmp != null && nyData.compareTo(tmp.data) > 0){
          tmp = tmp.neste;
        }

            if(tmp == start){
              ny.neste = start;
              start.forrige = ny;
              start = ny;
            } else if (tmp == null){
              ny.forrige = slutt;
              slutt.neste = ny;
              slutt = ny;
            } else {
              Node tmpForrige = tmp.forrige;
              tmpForrige.neste = ny;
              ny.forrige = tmpForrige;

              ny.neste = tmp;
              tmp.forrige = ny;
            }
    } //else
  }//legg til


  @Override
  public T fjern() {
    return fjern(stoerrelse()-1); //fjern siste indeks
  }


  @Override
  public void sett(int pos, T x){
    throw new UnsupportedOperationException();
  }

  @Override
  public void leggTil(int pos, T x){
    throw new UnsupportedOperationException();
  }





}// class


/*
logg:

start.forrige = ny;
ny.neste = start;
start = ny;



  // @Override
  // //sorterer nodene i stigende rekkefolge
  // public void leggTil(T x){
  //   Node ny = new Node(x);
  //   Node temp = start;
  //
  //   //hvis det en en tomt liste, legger noden i starten av listen
  //   if(start == null){
  //     start = ny;
  //     slutt = ny;
  //   }
  //   else if (stoerrelse () ==1){
  //     if(x.compareTo(temp.data) >= 0){
  //       start.neste = ny;
  //       }
  //       else{
  //         ny.neste = start;
  //         start = ny;
  //       }
  //     }
  //     else{
  //
  //     //loop gjennom
  //     while( temp != null){
  //
  //       //hvis vi har kommet til enden av listen og verdien er stoerest
  //       if(temp.neste == null){
  //         ny.forrige = slutt;
  //         slutt.neste = ny;
  //         slutt = ny;
  //         break;
  //       }
  //       //hvis ny er storre enn temp og mindre enn temp sin neste
  //       else if (x.compareTo(temp.data) >= 0 && x.compareTo(temp.neste.data) <0){
  //         Node temp1 = temp.neste;
  //         temp.neste = ny;
  //         ny.neste = temp1;
  //         break;
  //       }
  //       temp = temp.neste;
  //     }//while
  //   }//else
  // }//if


*/
