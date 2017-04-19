import java.util.Scanner;

public class PassengerPlane {
	
	private final int ROWS = 7;
	private final int COLS = 4;
	private int count = 0;
	private PassengerSeat[][] Seats = new PassengerSeat[ROWS][COLS];
	
	public void plusCount(){
		this.count++;
	}
	
	public PassengerSeat getSeat(int row, int col) {
		return this.Seats[row - 1][col - 1];
	}
	
	public void populatePlane(){
		for (int outCount = 0; outCount < ROWS; outCount++){
			for (int inCount = 0; inCount < COLS; inCount++){
				PassengerSeat tempSeat = new PassengerSeat();
				this.Seats[outCount][inCount] = tempSeat;
			}
		}
		
	}
	
	public void addSeat(int row, int col){
		PassengerSeat newSeat = new PassengerSeat();
		newSeat.occupySeat();
		Seats[row - 1][col - 1] = newSeat;
	}
	
	public void displaySeats(){
		String identifier = "";
		for (int outCount = 0; outCount < ROWS; outCount++){
			System.out.print((outCount + 1) + " ");
			for (int inCount = 0; inCount < COLS; inCount++){
				switch (inCount) {
				case 0: identifier = Seats[outCount][inCount].returnSeatLetter("A");
						break;
				case 1: identifier = Seats[outCount][inCount].returnSeatLetter("B");
						break;
				case 2: identifier = Seats[outCount][inCount].returnSeatLetter("C");
						break;
				case 3: identifier = Seats[outCount][inCount].returnSeatLetter("D");
						break;
				}
				System.out.print(identifier + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		PassengerPlane plane = new PassengerPlane();
		Scanner scan = new Scanner(System.in);
		String userInput = "";
		String[] splitInput = new String[2];
		int userRow = 0;
		int userCol = 0;
		String userLetterString = "";
		
		plane.populatePlane();
		plane.displaySeats();
		//plane.addSeat(2, 3);
		//plane.displaySeats();
		
		System.out.println("Please enter the row number and seat letter of the seat you would like to book.");
		System.out.println("Enter this data as number first, then letter. Do not use spaces.");
		userInput = scan.next();
		
		while (!(userInput.equals("Finish"))) {
			splitInput = userInput.split("");
			userRow = Integer.parseInt(splitInput[0]);
			userLetterString = splitInput[1];
			
			switch (userLetterString) {
			case "A": userCol = 1;
					break;
			case "B": userCol = 2;
					break;
			case "C": userCol = 3;
					break;
			case "D": userCol = 4;
					break;
			default: System.out.println("Please enter a valid seat letter.");
					System.exit(0);
					break;
			}
			
			if (plane.getSeat(userRow, userCol).isVacant()) {
				plane.addSeat(userRow, userCol);
				plane.displaySeats();
				plane.plusCount();	
			}
			else {
				System.out.println("That seat has already been filled! Please choose another seat.\n");
			}
			
			System.out.println("Please enter the row number and seat letter of the seat you would like to book.");
			System.out.println("Enter this data as number first, then letter. Do not use spaces.");
			userInput = scan.next();
		}

		plane.displaySeats();
		
		
	}

}
