
public class PassengerSeat {
	
	//private static int count = 0;
	private boolean isVacant;
	
	public boolean getIsVacant() {
		return isVacant;
	}

	public void setVacant(boolean isVacant) {
		this.isVacant = isVacant;
	}

	public PassengerSeat() {
		this.isVacant = true;
		//count++;
	}
	
	public void occupySeat() {
		this.isVacant = false;
	}
	
	public String returnSeatLetter(String letter){
		if (!this.isVacant)
			letter = "X";
		return letter;
	}
	
	public String toString(){
		return "Vacancy: " + this.getIsVacant();
	}

}
