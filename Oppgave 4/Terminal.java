
import java.util.Scanner;

public class Terminal implements Brukergrensesnitt {
    private Scanner scanner;



    //som tar i mot scanner
    public Terminal(Scanner scanner) {
        this.scanner = scanner;
    }


    public void giStatus(String status) {
        System.out.println(status);
    }


    @Override
    public int beOmKommando(String spoersmaal, String[] alternativer) {
        System.out.println(spoersmaal); //vis spoersmaal

        //printer ut alternativer
        for (int i = 0; i < alternativer.length; i++) {
            System.out.print("\n" + i + "." + alternativer[i] );
        }

       //tekst for aa informer om input
        System.out.println("\n Skriv inn alternativnummer: " );
        int index = 0;
        try {
            index = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("ugyldig input");
        }
        System.out.println("Du valgte " + index + " : " + alternativer[index] );
        return index;
    }



}
