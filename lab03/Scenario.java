/**
 * The main method of this class plays out a scenario...
 * Jack has two cans of soda,
 * RootBeer and GingerAle, Jill also has two cans, Cherry and Grape.
 * Jack opens his RootBeer first, and gives it to Jill.
 * Jill completely drinks the RootBeer. Jack asks her if she is still
 * thirsty, Jill responds. Now Jill opens her Cherry soda and drinks it until
 * she is satisfied, then gives it to Jack. He takes a sip, but doesn't
 * like it. Jill checks how much is left in her Cherry soda, but decides
 * not to drink any more. Jack asks Jill if he can try her Grape soda.
 * Jack drinks about half of it, then stops and tells Jill how he now feels.
 * Finally, they check the amount available in all of the cans.
 */
public class Scenario {
  public static void main(String[] args){
    // Jack has two cans of soda RootBeer and GingerAle
    Person jack = new Person("Jack");
    SodaCan rootBeer = new SodaCan("RootBeer");
    SodaCan gingerAle = new SodaCan("GingerAle");
    // Jill also has two cans, Cherry and Grape.
    Person jill = new Person("Jill");
    SodaCan cherry = new SodaCan("Cherry");
    SodaCan grape = new SodaCan("Grape");
    // Jack opens his RootBeer first, and gives it to Jill.
    rootBeer.open();
    // Jill completely drinks the RootBeer.
    while(rootBeer.amount != 0){
      jill.sipFrom(rootBeer);
    }
    // Jack asks her if she is still thirsty, Jill responds.
    jill.getThirstStatus();
    //System.out.println(jill.getThirstStatus());
    // Now Jill opens her Cherry soda and drinks it until she is satisfied, then gives it to Jack
    cherry.open();
    while(jill.getThirstStatus() != "satisfied"){
      jill.sipFrom(cherry);
    }
    // He takes a sip, but doesn't like it.
    jack.sipFrom(cherry);
    // Jill checks how much is left in her Cherry soda, but decides not to drink any more
    cherry.amount();
    // System.out.println(cherry.amount);
    // Jack asks Jill if he can try her Grape soda.
    //Jack drinks about half of it
    grape.open();
    while(grape.amount > 125){
      jack.sipFrom(grape);
    }
    // then stops and tells Jill how he now feels.
    jack.getThirstStatus();
    //System.out.println(jack.getThirstStatus());
    // Finally, they check the amount available in all of the cans.
    //System.out.println(rootBeer.amount);
    rootBeer.amount();
    //System.out.println(gingerAle.amount);
    gingerAle.amount();
    //System.out.println(cherry.amount);
    cherry.amount();
    //System.out.println(grape.amount);
    grape.amount();
  }

}
