public class IfNilai {
	// ambil inputan melalui args
	public static void main(String[] args){
		int score;

		if (args.length != 1){
			System.out.println("IfNilai <nilai>");
		}
		//else {
			score = Integer.parseInt(args[0]);
		//}
		



		//if 0-20 E, 21-40 D, 41-60 C, 61-80 B, 81-100 A
		if (score >=0 && score <=20) {
			System.out.println("Nilai E");
		}
		else if (score >=21 && score <=40) {
			System.out.println("Nilai D");
		}
		else if (score >=41 && score <=60) {
			System.out.println("Nilai C");
		}
		else if (score >=61 && score <=80) {
			System.out.println("Nilai B");
		}
		else if (score >=81 && score <=100) {
			System.out.println("Nilai A");
		}
		else {
			System.out.println("Nilai tidak tahu!");
		}
	}
}