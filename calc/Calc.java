/**
 * @author Moaz Aamir
 * @date 05/03/2024
 * A standard calculator programmed in Java.
 */

package calc;

import java.util.Scanner;

/**
 * The Calc class provides a main method to evaluate basic mathematical expressions entered by the user.
 * It uses two queues to separate numbers and operators and then processes them to compute the result.
 */
public class Calc {

    /**
     * Main method to read and evaluate a mathematical expression from the user.
     * Supported operations are addition (+), subtraction (-), multiplication (*), and division (/).
     * 
     * @param args command-line arguments (not used)
     * @throws Exception if an error occurs during queue operations or invalid input
     */
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a Math Expression: ");
        String userExpression = scanner.nextLine();
        String[] splitExpression = userExpression.split(" ");

        // Call WQueue
        WQueue<Integer> nums = new WQueue<>();
        WQueue<Character> ops = new WQueue<>();

        for (String obj: splitExpression) {
            if (isNumeric(obj)) {
                nums.enqueue(Integer.valueOf(obj));
            }
            if (isOperator(obj)) {
                ops.enqueue(obj.charAt(0));
            }
        }
        while (!ops.isEmpty()) {
            int x = nums.dequeue();
            int y = nums.dequeue();
            int z = 0;
            char op = ops.dequeue();

            if (op == '+') {
                z = x + y;
            }
            if (op == '-') {
                z = x - y;
            }
            if (op == '*') {
                z = x * y;
            }
            if (op == '/') {
                z = x / y;
            }
            nums.enqueue(z);
        }
        System.out.println(nums.dequeue());
    }

    /**
     * Checks if a given string is a numeric value.
     * 
     * @param strNum the string to check
     * @return true if the string is numeric, false otherwise
     */
    public static boolean isNumeric(String strNum) {
        return strNum.matches("-?\\d+(\\.\\d+)?");
    }

    /**
     * Checks if a given string is a valid operator.
     * 
     * @param chr the string to check
     * @return true if the string is an operator (+, -, *, /), false otherwise
     */
    public static boolean isOperator(String chr) {
        return chr.equals("+") || chr.equals("-") || chr.equals("*") || chr.equals("/");
    }
}
