public class ValidadorExpresion {

    public void validar(String expresion) {
        if (expresion == null || expresion.trim().isEmpty()) {
            throw new IllegalArgumentException("La expresion no puede estar vacia");
        }

        String exp = expresion.replaceAll(" ", "");
        int parentesis = 0;
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (c == '(') {
                parentesis++;
            } else if (c == ')') {
                parentesis--;
                if (parentesis < 0) {
                    throw new IllegalArgumentException("Parentesis de cierre sin apertura");
                }
            } else if (!Character.isDigit(c) && !esOperador(c)) {
                throw new IllegalArgumentException("Caracter no permitido: " + c);
            }
            if (i + 1 < exp.length() && Character.isDigit(c) && Character.isDigit(exp.charAt(i + 1))) {
                throw new IllegalArgumentException("No se permiten numeros de mas de un digito");
            }
        }
        if (parentesis != 0) {
            throw new IllegalArgumentException("Parentesis desbalanceados");
        }
    }
    public static boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}