package JogoDaVelha;

import Tabuleiro.Tabuleiro;
import Jogador.Jogador;
import Jogador.Humano;
import Jogador.Computador;
import java.util.Scanner;

public class Jogo {
    private Tabuleiro tabuleiro;
    public int rodada=1, vez=1;
    private Jogador  jogador1;
    private Jogador jogador2;
    public Scanner sc = new Scanner(System.in);

    public Jogo(){
        tabuleiro = new Tabuleiro();
        iniciarJogadores();
        System.out.println("O jogo irá começar, você vai escolher em qual linha e coluna irá marcar. Cuidado para não se confundir, ein! kkk");
        while(Jogar());
    }

    public void iniciarJogadores(){
        System.out.println("Quem será o Jogador 1? ");
        if (escolherJogador() == 1)
            this.jogador1 = new Humano(1);
        else
            this.jogador1 = new Computador(1);

        System.out.println("__________________");
        System.out.println("Quem será o Jogador 2? ");
        if (escolherJogador() == 1)
            this.jogador2 = new Humano(2);
        else
            this.jogador2 = new Computador(2);
    }

    public int escolherJogador(){
        int opcao = 0;

        do {
            System.out.println("1. Humano");
            System.out.println("2. Computador\n");
            System.out.println("Opção: ");
            opcao = sc.nextInt();

            if (opcao != 1 && opcao != 2)
                System.out.println("Opção inválida! Tente novamente.");
        }while(opcao != 1 && opcao != 2);
        return opcao;
    }
    public boolean Jogar(){

        if (ganhou() == 0){
            System.out.println("__________________");
            System.out.println("\nRodada "+rodada);
            System.out.println("É a vez do jogador "+ vez());

            if (vez()==1)
                jogador1.jogar(tabuleiro);
            else
                jogador2.jogar(tabuleiro);

            if (tabuleiro.tabuleiroCompleto() && ganhou()==0){
                System.out.println("Ops!! Deu velha");
                return false;
            }
            vez++;
            rodada++;

            return true;
        }else{
            if (ganhou()==-1)
                System.out.println("Jogador 1 ganhou!");
            else
                System.out.println("Jogador 2 ganhou!");

            return false;
        }
    }

    public int vez(){
        if (vez%2 == 1)
            return 1;
        else
            return 2;
    }

    public int ganhou(){
        if (tabuleiro.checaLinhas()==1)
            return 1;
        if (tabuleiro.checaColunas()==1)
            return 1;
        if (tabuleiro.checaDiagonais()==1)
            return 1;

        if (tabuleiro.checaLinhas()==-1)
            return -1;
        if (tabuleiro.checaColunas()==-1)
            return -1;
        if (tabuleiro.checaDiagonais()==-1)
            return -1;

        return 0;
    }
}
