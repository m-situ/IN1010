// import java.io.File;
// import java.io.FileNotFoundException;
//
// import java.util.ArrayList;
// import java.util.Scanner;
//
// import javafx.application.Application;
// import javafx.application.Platform;
// import javafx.event.*;
// import javafx.scene.control.Button;
//
// import javafx.scene.layout.GridPane;
// import javafx.scene.layout.Pane;
// import javafx.scene.paint.Color;
// import javafx.scene.Scene;
//
// import javafx.scene.shape.Rectangle;
//
// import javafx.stage.FileChooser;
// import javafx.stage.Stage;
//
//
// public class GUILabyrint extends Application {
//   Labyrint labyrint;
//   Liste<String> utveier;
//   Rute[][] brett;
//   int gRad, gKolonne;
//   int utvei;
//   int antLosning = 0;
//   int numLosning = 0;
//
//   public class RuteBehandler implements EventHandler <ActionEvent>{
//
//     @Override
//     public void handle (ActionEvent ev){
//
//         Rute r = (Rute)ev.getSource();
//         utveier = new Lenkeliste<String>();
//         utveier = labyrint.finnUtveiFra(r.hentRuteKolonne(), r.hentRuteRader());
//         System.out.println("Test");
//
//         if(utveier.stoerrelse() >0){
//           for(String s :utveier){
//             System.out.println(s);
//           }
//           // boolean[][] losning = labyrint.losningStringTilTabell(utveier.hent(0), labyrint.hentKolonne(), labyrint.hentRader());
//           // for (int r = 0; r < l.hentRader(); r++) {
//           //   for (int k = 0; k < l.hentKolonner(); k++) {
//           //     if (losning[r][k]) {
//           //       brett[r][k].setFill(Color.YELLOW);
//           //     }
//           //   }
//           // }
//         }
//     }
//
//   }
//
//   // class LosningBehandler implements EventHandler<ActionEvent>{
//   //   @Override
//   //   public void handle(ActionEvent e){
//   //     try{
//   //       ((Rute)e.getSource()).finnUtvei();
//   //       utveier = ((Rute)e.getSource()).hentUtveier();
//   //
//   //       ((Rute)e.getSource()).tomUtvei();
//   //
//   //       antLosning = utveier.stoerrelse();
//   //       numLosning = 0;
//   //       losning = utveier.hent(numLosning);
//   //
//   //       losningbrett = GUI.this.losningStringTilTabell(losning, labyrint.hentRader(), labyrint.hentKolonner());
//   //
//   //       for (int i = 0;  i < labyrint.hentRader();  i++) {
//   //         for(int j = 0; j < labyrint.hentKolonner(); j++){
//   //           Rute r = brett[i][j];
//   //           if(r instanceof HvitRute){r.reset();}
//   //           if(losningbrett[i][j]){
//   //             brett[i][j].settLosning();
//   //           }
//   //         }
//   //       }
//   //       tekst.setText("Losning " + (numLosning+1) + " av " + utveier.stoerrelse() + " losninger");
//   //     } catch (UgyldigListeIndeks er){
//   //       tekst.setText("Ingen losninger");
//   //     }
//   //   }
//   // }
//
//   public void start(Stage teater){
//     File fil = new FileChooser().showOpenDialog(teater);
//
//     try{
//       labyrint = labyrint.lesFraFil(fil);
//     }catch(FileNotFoundException e){
//       System.out.println("Feil fil, tast inn fil + .in");
//       System.exit(1);
//     }
//
//     GridPane gridPane = new GridPane();
//     brett = labyrint.hentLabyrint();
//     gRad = labyrint.hentAntRader();
//     gKolonne= labyrint.hentAntKolonne();
//
//     for(int i = 0; i < gRad; i++){
//       for(int j = 0; j < gKolonne; j++){
//         Rute r = brett[j][i];
//         if(r instanceof SortRute) {
//           Rectangle sort = new Rectangle(25,25);
//           gridPane.add(sort, i,j);
//         }else{
//           Button hvit = new Button();
//           hvit.setPrefSize(25,25);
//           RuteBehandler rutebehandler  = new RuteBehandler();
//           hvit.setOnAction(rutebehandler);
//           gridPane.add(hvit, i, j);
//         }
//       }
//     }
//
//     Scene scene = new Scene(gridPane);
//     teater.setTitle ("Oblig 7");
//     teater.setScene(scene);
//     teater.show();
//   }
//
//           /**
//   * Konverterer losning-String til en boolean[][]-representasjon
//   * av losningstien.
//   * @param losningString String-representasjon av utveien
//   * @param bredde        bredde til labyrinten
//   * @param hoyde         hoyde til labyrinten
//   * @return              2D-representasjon av rutene der true indikerer at
//   *                      ruten er en del av utveien.
//   */
//   static boolean[][] losningStringTilTabell(String losningString, int bredde, int hoyde) {
//       boolean[][] losning = new boolean[hoyde][bredde];
//       java.util.regex.Pattern p = java.util.regex.Pattern.compile("\\(([0-9]+),([0-9]+)\\)");
//       java.util.regex.Matcher m = p.matcher(losningString.replaceAll("\\s",""));
//       while (m.find()) {
//           int x = Integer.parseInt(m.group(1));
//           int y = Integer.parseInt(m.group(2));
//           losning[y][x] = true;
//       }
//       return losning;
//   }
//
// }
