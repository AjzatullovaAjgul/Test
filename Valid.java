
public class Valid {

    public static void main(String[] args) {
        String p1 = "(()";
        String p2 = ")()())";
        String p3 = ")(()())";
        String p4 = ")(";

        String number1 = longestValidParentheses(p1);
        System.out.println(number1.length() + " - " + number1);

        String number2 = longestValidParentheses(p2);
        System.out.println(number2.length() +  " - " + number2);

        String number3 = longestValidParentheses(p3);
        System.out.println(number3.length() +  " - " + number3);

        String number4 = longestValidParentheses(p4);
        System.out.println(number4.length() +  " - " + number4);
    }

    public static String longestValidParentheses(String input) {
        int start = 0;
        int len = 0;
        for(int i=0; i<input.length(); i++){
            for(int j=i+1; j<input.length(); j++){
                if (isValid(input, i, j)){
                    int newLen = j-i+1;
                    if (newLen > len){
                        len = newLen;
                        start = i;
                    }
                }
            }
        }
        return input.substring(start, start+len);
    }

    public static boolean isValid(String str, int start, int end){
        int open = 0;
        for(int i=start; i<=end; i++) {
            if (str.charAt(i) == '(') open++;
            if (str.charAt(i) == ')'){
                if (open == 0) return false;
                open--;
            }
        }
        return open == 0;
    }
}
