public class Die {

	/**
	 * instance data/ attributes/ properties
	 */
	private int faces;
	private int value;
	
	public Die() {
		//initialize our instance variable/data
		this.faces = 6;
		rollDie();
		
	}
	//overloaded constructor. example of polymorphism
	
	public Die(int faces) {
		this.faces = faces;
		rollDie();
	}
	
	//method to roll my die
	public int rollDie() {
		return this.value = (int)(Math.random()*this.faces + 1);
	}
	
	public int getValue() {
		return this.value;
	}
	
	public boolean compareTo(Die d) {
		return this.getValue() == d.getValue();
	}
	
	public static void main(String[] args) {
		// Declare and create a die d
		Die d;
		d = new Die();
		
		//display its value
		System.out.println(d.getValue());
		
		//roll the d die
		d.rollDie();
		
		//display again
		System.out.println(d.getValue());
		
		//declare and create a die d1
		Die d1 = new Die();
		
		//display the value of d1
		System.out.println(d1.getValue());
		
		
		int counter = 0;
		
		for (int i = 0; i< 100; i++) {
			//roll the d die
			d.rollDie();
			d1.rollDie();
			
			if (d.compareTo(d1)) {
				System.out.println(d1.getValue());
				counter++;
				System.out.println(d.getValue() + " " + d1.getValue());
			}
		}
		
		System.out.println("there were " + counter + " indentical rolls out of 100");
	}

}
