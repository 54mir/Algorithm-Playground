import java.util.Stack;

public class DecodeString {



    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            StringBuilder sb = new StringBuilder();
            if (c == ']'){
                char ch = stack.pop();
                while (ch != '['){
                    sb.insert(0, ch);
                    ch = stack.pop();
                }

                StringBuilder strnum = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    strnum.insert(0, stack.pop());
                }
                int num = Integer.parseInt(strnum.toString());
                for (int j = 0; j < num; j++) {
                    for (int k = 0; k < sb.length(); k++) {
                        stack.push(sb.charAt(k));
                    }
                }

            }else{
                stack.push(c);
            }

        }

        while(!stack.isEmpty()){
            result.insert(0, stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String str = "1[ab20[c3[cd]x]y2[z]]";
        //ab
        DecodeString ds = new DecodeString();
        System.out.println(ds.decodeString(str));

    }
}
