import java.util.stream.*;
import java.util.*;
import java.util.function.*;

class Movie implements Comparable<Movie> 
{ 
    private double rating; 
    private String name; 
    private int year; 
  
    // Used to sort movies by year 
    public int compareTo(Movie m) 
    { 
        return this.year - m.year; 
    } 
  
    // Constructor 
    public Movie(String nm, double rt, int yr) 
    { 
        this.name = nm; 
        this.rating = rt; 
        this.year = yr; 
    } 
  
    // Getter methods for accessing private data 
    public double getRating() { return rating; } 
    public String getName()   {  return name; } 
    public int getYear()      {  return year;  } 

    public String toString(){
        return name;
    }
} 

public class testyTesties{

    public static void main(String[] args){

        //TESTING CAPITALIZED
        /*List<String> names = new ArrayList<String>();
        names.add("Horsey");
        names.add("monkey");
        names.add("Orangutan");
        
        System.out.println(names);

        Collection<String> newNames = FunctionalUtils.capitalized(names);

        System.out.println(newNames);

        Set<String> set = new HashSet<String>();
        set.add("Dorsley");
        set.add("woeifn");
        set.add("Aiyaa");

        System.out.println(set);

        Collection<String> newSet = FunctionalUtils.capitalized(set);

        System.out.println(newSet);
        */
        //TESTING LONGEST
        /*List<String> names2 = new ArrayList<String>();
        names2.add("Horseyw");
        names2.add("monkeyqww");
        names2.add("Orangutan");

        System.out.println(names2);

        String newName2 = FunctionalUtils.longest(names2, false);

        System.out.println(newName2);
        */
        //TESTING LEAST
        /*List<Movie> movieList = new ArrayList<Movie>();
        movieList.add(new Movie("Force Awakens", 8.3, 2015)); 
        movieList.add(new Movie("Star Wars", 8.7, 2015)); 
        movieList.add(new Movie("Empire Strikes Back", 8.8, 2016)); 
        movieList.add(new Movie("Return of the Jedi", 8.4, 2015)); 

        System.out.println(movieList);

        Movie leastMovie = FunctionalUtils.least(movieList, false);

        System.out.println(leastMovie);
        */
        //TESTING FLATTEN
        /*Map<String, Integer> mappy = new HashMap<String, Integer>();
        mappy.put("a", new Integer(100));
        mappy.put("b", new Integer(200)); 
        mappy.put("c", new Integer(300)); 
        mappy.put("d", new Integer(400)); 

        System.out.println(mappy);

        List betterMappy = FunctionalUtils.flatten(mappy);

        System.out.println(betterMappy);
        */

        /*
        System.out.println(FunctionalOperations.add.apply(2.0,3.0));
        System.out.println(FunctionalOperations.diff.apply(2.0,3.0));
        System.out.println(FunctionalOperations.mult.apply(2.0,3.0));
        System.out.println(FunctionalOperations.div.apply(2.0,3.0));
        //System.out.println(div.apply(2.0,0.0));

        List<Double> arg = new ArrayList<Double>();
        arg.add(1.0);
        arg.add(1.0);
        arg.add(3.0);
        arg.add(0.0);
        arg.add(4.0);

        List<FunctionalOperations.NamedBiFunction<Double, Double, Double>> bfs = new ArrayList<FunctionalOperations.NamedBiFunction<Double, Double, Double>>();
        bfs.add(FunctionalOperations.add);
        bfs.add(FunctionalOperations.mult);
        bfs.add(FunctionalOperations.add);
        bfs.add(FunctionalOperations.div);
        
        System.out.println(arg);
        System.out.println(FunctionalOperations.zip(arg, bfs));

        Function<Integer, String> halfvalue2str =
                new FunctionalOperations.FunctionComposition<Integer, Double, String>().composition.apply(i -> i / 2.0, d -> Double.toString(d));
        Function<List<String>, Integer> sizeOfFirstItem =
                new FunctionalOperations.FunctionComposition<List<String>, String, Integer>().composition.apply(list -> list.get(0), String::length);
        System.out.println("\"" + halfvalue2str.apply(5) + "\"");         // prints "2.5"
        System.out.println("\"" + halfvalue2str.apply(17) + "\"");        // prints "8.5"
        System.out.println(sizeOfFirstItem.apply(Arrays.asList("something",
                                                            "else",
                                                            "must",
                                                            "be",
                                                            "better",
                                                            "in",
                                                            "life"))); // prints 9
        */
    }

}