import java.util.ArrayDeque;
import java.util.Deque;

public class ConvertidorPostfija {
    public String convertir(String expresion) {
        new ValidadorExpresion().validar(expresion);

        Deque<Character> pila = new ArrayDeque<>();
        StringBuilder salida = new StringBuilder();
        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                salida.append(c).append(" ");
            } else if (c == '(') {
                pila.push(c);
            } else if (c == ')') {
                while (pila.peek() != '(') {
                    salida.append(pila.pop()).append(" ");
                }
                pila.pop(); // quita el '('
            } else {
                while (!pila.isEmpty() && pila.peek() != '('
                        && prioridad(pila.peek()) >= prioridad(c)) {
                    salida.append(pila.pop()).append(" ");
                }
                pila.push(c);
            }
        }
        while (!pila.isEmpty()) {
            salida.append(pila.pop()).append(" ");
        }
        return salida.toString().trim();
    }
    private int prioridad(char op) {
        if (op == '+' || op == '-') {
            return 1;
        }
        return 2;
    }
}