import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Terreng {

    private List<Sted> steder = new ArrayList<>();
    private List<Gjenstand> gjenstander = new ArrayList<>();

    public Terreng(String fil) throws FileNotFoundException {
    	Scanner scanner = new Scanner(new File("gjenstander.txt"));
	    while (scanner.hasNextLine()) {
            String[] linje = scanner.nextLine().split(" ");
            int verdi = Integer.parseInt(linje[1]);
            Gjenstand item = new Gjenstand (linje[0], verdi);
            gjenstander.add(item);
        }

        scanner = new Scanner(new File(fil));
        while (scanner.hasNextLine()) {
            String linje = scanner.nextLine();
            Sted sted = new Sted(linje);
            sted.kiste().leggGjenstand(gjenstander);
            steder.add(sted);
        }

        Collections.shuffle(steder);

        for (int i = 0; i < steder.size() - 1 ; i++) {
        	steder.get(i).settNesteSted(steder.get(i + 1));
        }
    }

    public Sted hentStart() {
    	return steder.get(0);
    }

    public List<Sted> steder() {
    	return steder;
    }

    public List<Gjenstand> gjenstander() {
    	return gjenstander;
    }
}
