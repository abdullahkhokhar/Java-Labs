/**
 * Capture a Can of Soda.
 * A Can of Soda has a type, amount (initially 250) and is initially closed.
 * Once opened, you can sip (take at most 10) or gulp (take at most 50) from
 * the can. Obviously, at all times, the amount of soda in the can is between 0 and 250.
 * An opened can can not be closed.
 */
public class SodaCan {
	public String type;
	public boolean isOpen;
	public int amount;

	/**
	 * Construct a new SodaCan of the specified type.
	 * The new can has 250 units in it, and is closed.
	 * @param t the type of soda, for example "RootBeer", "Coke", "Cherry"
	 */
	 public SodaCan(String t) {
 		this.type = t;
 		this.isOpen = false;
 		this.amount = 250;
 	}

        /**
         * open this SodaCan
         */
				 public void open() {
					 if(isOpen = false){
						 isOpen = true;
					 }else{
						 isOpen = true; 
					 }
				 }

	/**
	 * @return whether this is open
	 */
	 public boolean isOpen(){
		 return this.isOpen;
	 }

        /**
         * remove up to 10cc of soda from this, provided this is open
         * @return the amount of soda actually removed
         */
				 public int sip(){
					 int inital = this.amount;
					 if(this.isOpen() == false){
						 return 0;
					 } else if ((inital - 10) < 0){
						 this.amount = 0;
						 return inital;
					 } else {
						 this.amount -= 10;
						 return 10;
					 }
				 }

        /**
         * remove up to 50cc of soda from this, provided this is open
         * @return the amount of soda actually removed
         */
				 public int gulp(){
					 int inital = this.amount;
					 if(this.isOpen() == false){
						 return 0;
					 } else if ((inital - 50) < 0){
						 this.amount = 0;
						 return inital;
					 } else {
						 this.amount -= 50;
						 return 50;
					 }
				 }

        /**
         * @return the amount of soda left in this
         */
				 public int amount(){
					 return this.amount;
				 }

        /**
         * @return a string representation of this
         */
        public String toString(){
		String openString = (this.isOpen)?"open":"closed";
		return this.type+" "+openString+" "+this.amount;
        }

				public static void main(String[] args){
					SodaCan s1 = new SodaCan("Sprite");
					SodaCan s2 = new SodaCan("Coke");
					s1.open();
					s2.open();
					System.out.println("Sipping "+s1.sip());
					System.out.println("Gulping "+s1.gulp());
					System.out.println(s1);
					System.out.println("Sipping "+s2.sip());
					System.out.println(s2);
				}
}
