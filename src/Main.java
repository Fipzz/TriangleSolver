import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // triangle [a], [b], [c], [A], [B], [C],
        String[] triangle = new String[6];

        boolean canSolve = false;

        System.out.println("--- Welcome to finish my triangle ---");

        Scanner scanner = new Scanner(System.in);

        System.out.println("If you know the value enter it, if not just type X\n");

        for (int i = 0; i < 6; i++) {

            if(i+1 == 1){
                System.out.println("Enter length a: ");
            } else if (i+1 == 2){
                System.out.println("Enter length b: ");
            } else if (i+1 == 3){
                System.out.println("Enter length c: ");
            } else if (i+1 == 4){
                System.out.println("Enter degree A: ");
            } else if (i+1 == 5){
                System.out.println("Enter degree B: ");
            } else {
                System.out.println("Enter degree C: ");
            }

            triangle[i] = scanner.nextLine();

            if (!isNumber(triangle[i]) && !(triangle[i].matches("x") || triangle[i].matches("X"))){
                System.out.println("You did not enter a number, or a X! Try again");
                i--;
            }
        }

        System.out.println("--- Here is your triangle ---");
        triangleStats(triangle);

        // --- Law of sines ---
        //One side, two degrees
        if( (isNumber(triangle[3]) && isNumber(triangle[4]) || isNumber(triangle[3]) && isNumber(triangle[5]) || isNumber(triangle[4]) && isNumber(triangle[5])) && (isNumber(triangle[0]) || isNumber(triangle[1]) || isNumber(triangle[2])) ){
            canSolve = true;
        }
        //Two sides, one degree (can't be degree of the two sides)
        if ( (isNumber(triangle[0]) && isNumber(triangle[1])) && (isNumber(triangle[3]) || isNumber(triangle[4])) ){
            canSolve = true;
        } else if ( (isNumber(triangle[0]) && isNumber(triangle[2])) && (isNumber(triangle[3]) || isNumber(triangle[5])) ){
            canSolve = true;
        } else if ( (isNumber(triangle[1]) && isNumber(triangle[2])) && (isNumber(triangle[4]) || isNumber(triangle[5])) ){
            canSolve = true;
        }

        // --- Law of cosines ---
        // Three sides
        if(isNumber(triangle[0]) && isNumber(triangle[1]) && isNumber(triangle[2])){
            canSolve = true;
        }
        //Two sides, one degree (has to be degree of the two sides)
        if ( (isNumber(triangle[3])) && (isNumber(triangle[1]) && isNumber(triangle[2])) ){
            canSolve = true;
        } else if ( (isNumber(triangle[4])) && (isNumber(triangle[0]) && isNumber(triangle[2])) ){
            canSolve = true;
        } else if ( (isNumber(triangle[5])) && (isNumber(triangle[0]) && isNumber(triangle[1])) ){
            canSolve = true;
        }

        if(canSolve){
            System.out.println("With the given lengths and sides the triangle can be finished!");
        }

        //TODO solve

        System.out.println("--- Here is the solved one ---");
        triangleStats(triangle);

        //TODO replay and stop
    }

    public static boolean isNumber(String string){

        if (string == null){
            return  false;
        }

        try{
            Integer.parseInt(string);
        } catch (NumberFormatException e){
            return false;
        }

        return true;
    }

    public static void triangleStats(String[] triangle){
        System.out.println("The three lengths are: a(" + triangle[0] + ") , b(" + triangle[1] + ") , c(" + triangle[2] + ")");
        System.out.println("The three degrees are: A(" + triangle[3] + ") , B(" + triangle[4] + ") , C(" + triangle[5] + ")");
    }

}
