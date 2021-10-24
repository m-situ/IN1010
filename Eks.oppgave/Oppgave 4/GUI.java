
//
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//
//public class GUI extends Application {
//    public static void main(String[] args) throws FileNotFoundException {
//        //terreng = new Terreng("steder.txt");
//    	terreng = new Terreng ("src/eksamen20220v1/steder.txt");
//        Sted startSted = terreng.hentStart();
//
//        System.out.println("Start: " + terreng.stedListe.indexOf(startSted) + "." + startSted.beskrivelse);
//
//        //robot
//        robot = new Spiller("Bot", startSted, new Robot(), terreng.stedListe, terreng.gjenstandList);
//        //spiller
//        player = new Spiller( "Spiller",  startSted, new Terminal(new Scanner(System.in)), terreng.stedListe, terreng.gjenstandList);
//
//
//        nyttTrekk();
//
//        //Print hvem vinner
//        if (robot.formue == player.formue) {
//            System.out.println("Begge vant");
//        }
//
//        if (robot.formue > player.formue) {
//            System.out.println("Robot Wins");
//        }
//
//        if (robot.formue < player.formue) {
//            System.out.println(player.navn + "wins");
//        }
//
//    }
//
//
//	  public static void nyttTrekk() {
//	  for (int i = 0; i < 10; i++) {
//	      player.trekk(false);
//	      robot.trekk(true);
//	  }
//	}
//
//}
