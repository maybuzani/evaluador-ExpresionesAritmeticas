import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluadorPostfija {

    public int evaluar(String expresionPostfija) {
        Deque<Integer> pila = new ArrayDeque<>();
        String[] tokens = expresionPostfija.trim().split(" ");

        for (String t : tokens) {
            char c = t.charAt(0);

            if (Character.isDigit(c)) {
                pila.push(c - '0');
            } else {
                int b = pila.pop();
                int a = pila.pop();
                pila.push(operar(a, b, c));
            }
        }

        return pila.pop();
    }

    private int operar(int a, int b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Division entre cero");
                }
                return a / b;
        }
        return 0;
    }
}