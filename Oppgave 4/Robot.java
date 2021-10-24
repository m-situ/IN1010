

import java.util.Random;

public class Robot implements Brukergrensesnitt {
	public Random random = new Random();


	public Robot() {
	}


	@Override
	public void giStatus(String status) {
		System.out.println(status);
	}


	@Override
	public int beOmKommando(String spoersmaal, String[] alternativer) {

		int rand = random.nextInt(alternativer.length);
		System.out.println("Robot : "+ rand+" : "+alternativer[rand] );
		return rand;
	}




}
