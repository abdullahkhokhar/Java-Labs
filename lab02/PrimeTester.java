public class PrimeTester {

	/**
	 * @param args the command line arguments, we expect user supplied
	 * integers STARTNUM
	 */

	public static void main(String[] args) {
		try {
			if(args.length!=1){
				System.out.println("Usage: java Practice STARTNUM");
				return;
			}
			int checkPrime = Integer.parseInt(args[0]);
      boolean checked = isPrime(checkPrime);
      if(checked){
        System.out.println("Prime");
      } else {
        System.out.println("Not Prime");
      }

		} catch (NumberFormatException e){
			System.out.println("One of the command line arguments is not an integer");
		}
	}

	// function that tests of the number given is prime
	public static boolean isPrime(int s){
    int i;
    if(s == 1 || s <= 0){
      return false;
    } else if(s == 2) {
      return true;
    }
    for(i = 2; i < s; i = i+1){
      if(s%i == 0){
        return false;
      }
    }
    return true;
  }
}
