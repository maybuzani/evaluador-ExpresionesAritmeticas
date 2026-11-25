import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ValidadorExpresion validador = new ValidadorExpresion();
        ConvertidorPostfija convertidor = new ConvertidorPostfija();
        EvaluadorPostfija evaluador = new EvaluadorPostfija();

        System.out.print("Ingresa la expresion infija: ");
        String entrada = sc.nextLine();

        try {
            validador.validar(entrada);
            String postfija = convertidor.convertir(entrada);
            int resultado = evaluador.evaluar(postfija);

            System.out.println("Expresion postfija: " + postfija);
            System.out.println("Resultado: " + resultado);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}