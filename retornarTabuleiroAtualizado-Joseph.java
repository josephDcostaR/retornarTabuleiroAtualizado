import java.util.Scanner;
import java.util.Random;
/*
Online Java - IDE, Code Editor, Compiler
Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/

public class Main
{
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        
        char[][] tabuleiro = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        
        boolean jogadaValida = false;
        int[] jogada = new int[2];
        
        int[] maquina = new int[2];
        
        maquina[0] = random.nextInt(3);
        maquina[1] = random.nextInt(3);
        char caractereMaquina = 'O';
        
        while(!jogadaValida) {
            System.out.println(" jogada 1: ");
            jogada[0] = sc.nextInt();
            System.out.println(" jogada 2: ");
            jogada[1] = sc.nextInt();
            char caractereJogador = 'X';
            
            char[][] resultado =  retornarTabuleiroAtualizadoParaUsuario(tabuleiro, jogada, caractereJogador);
            
            if(resultado != null) {
                tabuleiro = resultado;
                jogadaValida = true;
            } else {
                System.out.println("Jogada inválida. Tente novamente.");
            }
        }
        
        // Exibindo o tabuleiro após a jogada
        System.out.println("Tabuleiro após a jogada Usuario:");
        imprimirTabuleiro(tabuleiro);
        
        tabuleiro = retornarTabuleiroAtualizadoParaMaquina(tabuleiro, maquina, caractereMaquina);
        
        System.out.println("Tabuleiro após a jogada Maquina:");
        imprimirTabuleiro(tabuleiro);
    }
    
        //Função - Joseph
        static char[][] retornarTabuleiroAtualizadoParaUsuario(char[][] tabuleiro, int[] jogada, char caractereJogador) {
        int linha = jogada[0];
        int coluna = jogada[1];
        
        if (linha < 0 || linha >= tabuleiro.length || coluna < 0 || coluna >= tabuleiro[0].length) {
            System.out.println("Erro: Posição fora dos limites do tabuleiro.");
            return null;
        } 
        
        if (tabuleiro[linha][coluna] != ' ') {
            System.out.println("Erro: Essa posição já está ocupada.");
            return null;
        }
            
        tabuleiro[linha][coluna] = caractereJogador;
            
        return tabuleiro;
            
    }
        
        //Função - Joseph
        static char[][] retornarTabuleiroAtualizadoParaMaquina(char[][] tabuleiro, int[] maquina, char caractereMaquina) {
        int linha = maquina[0];
        int coluna = maquina[1];
        
        if (linha < 0 || linha >= tabuleiro.length || coluna < 0 || coluna >= tabuleiro[0].length) {
            System.out.println("Erro: Posição fora dos limites do tabuleiro.");
            return null;
        } 
        
        if (tabuleiro[linha][coluna] != ' ') {
            System.out.println("Erro: Essa posição já está ocupada.");
            return null;
        }
            
        tabuleiro[linha][coluna] = caractereMaquina;
            
        return tabuleiro;
            
    }
        
        
        // Função para imprimir o tabuleiro
        static void imprimirTabuleiro(char[][] tabuleiro) {
            for (int i = 0; i < tabuleiro.length; i++) {
                for (int j = 0; j < tabuleiro[i].length; j++) {
                    System.out.print(tabuleiro[i][j] + " ");
                }
                System.out.println(); // Quebra de linha entre as linhas do tabuleiro
            }
         }
    }

