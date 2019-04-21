import java.util.function.*;
import java.util.*;

public class FunctionalOperations{

    interface NamedBiFunction<T, U, R> extends BiFunction<T, U, R>{

        String name();

    }

    public static NamedBiFunction<Double, Double, Double> add = new NamedBiFunction<Double, Double, Double>(){
        public String name(){
            return "add";
        }

        public Double apply(Double d1, Double d2){
            return d1 + d2;
        }
    };

    public static NamedBiFunction<Double, Double, Double> diff = new NamedBiFunction<Double, Double, Double>(){
        public String name(){
            return "subtract";
        }

        public Double apply(Double d1, Double d2){
            return d1 - d2;
        }
    };

    public static NamedBiFunction<Double, Double, Double> mult = new NamedBiFunction<Double, Double, Double>(){
        public String name(){
            return "multiply";
        }

        public Double apply(Double d1, Double d2){
            return d1 * d2;
        }
    };

    public static NamedBiFunction<Double, Double, Double> div = new NamedBiFunction<Double, Double, Double>(){
        public String name(){
            return "divide";
        }

        public Double apply(Double d1, Double d2){
            if (d2 == 0)
                throw new ArithmeticException("Cannot divide by zero");
            return d1 / d2;
        }
    };

    /**
    * Applies a given list of bifunctions -- functions that take two arguments of a
    * certain type, and produce a single instance of that type -- to a list of
    * arguments of that type. The functions are applied in an iterative manner, and
    * the result of each function is stored in the list in an iterative manner as
    * well, to be used by the next bifunction in the next iteration.
    * For example, given
    * List<Integer> args = [1,1,3,0,4], and
    * List<BiFunction<Double, Double, Double>> bfs = [add, multiply, add, divide],
    * <code>zip(args, bfs)</code> will proceed iteratively as follows:
    * - index 0: the result of add(1,1) is stored in args[1] to yield args = [1,2,3,0,4]
    * - index 1: the result of multiply(2,3) is stored in args[2] to yield args = [1,2,6,0,4]
    * - index 2: the result of add(6,0) is stored in args[3] to yield args = [1,2,6,6,4]
    * - index 3: the result of divide(6,4) is stored in args[4] to yield args = [1,2,6,6,1]
    *
    * @param args: the arguments over which <code>bifunctions</code>
    * will be iteratively applied.
    * @param bifunctions: the given list of bifunctions that will iteratively be
    * applied on the <code>args</code>.
    * @param <T>: the type parameter of the arguments (e.g., Integer, Double)
    * @return the last element in <code>args</code>, the final result of
    * all the bifunctions being applied in sequence.
    */
    public static <T> T zip(List<T> args, List<NamedBiFunction<T, T, T>> bifunctions){
        if (args.size() < bifunctions.size() + 1)
            throw new IllegalArgumentException("Not enough arguments in args compared to bifunctions");
        if (args.size() == 0 || bifunctions.size() == 0)
            throw new IllegalArgumentException("args and/or bifunctions are not allowed to be empty");
        List<T> newArgs = new ArrayList<T>(); //newArgs to avoid side effects made to args
        newArgs.add(args.get(0));
        bifunctions.forEach(fxn -> newArgs.add(fxn.apply(newArgs.get(newArgs.size()-1), args.get(newArgs.size()))));
        return newArgs.get(newArgs.size()-1);        
    }

    static class FunctionComposition<T, U, R>{
        BiFunction<Function<T, U>, Function<U, R>, Function<T, R>> composition = new BiFunction<Function<T, U>, Function<U, R>, Function<T, R>>(){
            public Function<T, R> apply(Function<T, U> t, Function<U, R> u){
                return t.andThen(u);
            }
        };
    }

}