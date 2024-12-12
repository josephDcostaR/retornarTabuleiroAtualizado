import java.util.Random;
import java.util.Scanner;

public class Main {
    final static String CARACTERES_IDENTIFICADORES_ACEITOS = "XO0UC";
    static Random random = new Random(); // Instância de Random global

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escolha um desses caracteres: " + CARACTERES_IDENTIFICADORES_ACEITOS);
        String caractereUsuario = teclado.nextLine().toUpperCase();
        System.out.println("Jogador: " + obterCaractereUsuario(caractereUsuario));
        System.out.println("Máquina: " + obterCaractereComputador(caractereUsuario));
    }

    static String obterCaractereUsuario(String usuarioInput) {
        do {
            // Verifica se o caractere do usuário é válido
            for (int i = 0; i < CARACTERES_IDENTIFICADORES_ACEITOS.length(); i++) {
                char c = CARACTERES_IDENTIFICADORES_ACEITOS.charAt(i); // Obtém o caractere aceito atual
                if (usuarioInput.equals(String.valueOf(c))) { // Compara o input com o caractere atual
                    return usuarioInput; // Retorna o caractere válido
                }
            }
            System.out.println("Digite um caracter válido:");
            Scanner teclado = new Scanner(System.in); // Recolhe nova entrada
            usuarioInput = teclado.nextLine().toUpperCase();
        } while (true);
    }

    static String obterCaractereComputador(String inputUsuario) {
        do {
            int indiceAleatorio = random.nextInt(CARACTERES_IDENTIFICADORES_ACEITOS.length());
            char letraAleatoria = CARACTERES_IDENTIFICADORES_ACEITOS.charAt(indiceAleatorio);

            // Converter char para String para realizar a comparação
            if (!String.valueOf(letraAleatoria).equals(inputUsuario)) {
                return String.valueOf(letraAleatoria);
            }
        } while (true);
    }
}
