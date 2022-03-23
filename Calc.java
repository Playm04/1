package Pack_1;

/**
 * Created by Рустик on 23.03.2022.
 */
import java.util.*;
// import Pack_1.Catch_ex;
public class Calc {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Calculate: ");
        String oper = in.nextLine();
        // System.out.println("Your Operation is " + oper);
        int n = oper.length();
        // System.out.println("Your String has Length " + n);

        char[] result = oper.toCharArray();


        for (int i = 0; i < (n - 1); i++) {
            try {
                if ((Character.isDigit(result[i])) && (Character.isDigit(result[i + 1])))
                    throw new Exception("Wrong String!");
            }

            catch(Exception ex)

            {
                System.out.println(ex.getMessage());
                System.out.println("Program is Out!");
                System.exit(0);
            }
        }

        // System.out.println("Your Array:");
        // for (int i = 0; i < n; i++){
        //     System.out.println("Your Char [" + i + "] is " + result[i]);
        // }
        int a = Character.getNumericValue(result[0]);
        int b = Character.getNumericValue(result[n-1]);
        for (int i = 0; i < n; i++) {
            if (result[i] == '+') {
                //   System.out.println("Your Operation [" + i + "] is SUM");
                Operation op = Operation.SUM;
                System.out.println(op.action(a, b));
                break;
            }
            if (result[i] == '-') {
                //   System.out.println("Your Operation [" + i + "] is SUBTRACT");
                Operation op = Operation.SUBTRACT;
                System.out.println(op.action(a, b));
                break;
            }
            if (result[i] == '*') {
                //   System.out.println("Your Operation [" + i + "] is MULTIPLY");
                Operation op = Operation.MULTIPLY;
                System.out.println(op.action(a, b));
                break;
            }
            if (result[i] == '/') {
                //   System.out.println("Your Operation [" + i + "] is DIVISION");
                Operation op = Operation.DIVISION;
                System.out.println(op.action(a, b));
                break;
            }
        }

    }
}

enum Operation{
    SUM{
        public int action(int x, int y)
        {return(x + y);}
    },
    SUBTRACT{
        public int action(int x, int y)
        {return(x - y);}
    },
    MULTIPLY{
        public int action(int x, int y)
        {return(x * y);}
    },
    DIVISION{
        public int action(int x, int y)
        {return(x / y);}
    };
    public abstract int action(int x, int y);
}