package Jogador;
import Jogador.Jogador;
import Tabuleiro.Tabuleiro;

import java.util.Scanner;

public class Humano extends Jogador{
    public Scanner sc = new Scanner(System.in);

    public Humano(int jogador){
        super(jogador);
        this.jogador = jogador;
        System.out.println("Jogador 'Humano' criado!");
    }

    @Override
    public void jogar(Tabuleiro tabuleiro) {
        Tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador);
    }

    @Override
    public void Tentativa(Tabuleiro tabuleiro) {
        do {
            do {
                System.out.println("Linha: ");
                tentativa[0] = sc.nextInt();

                if (tentativa[0] > 3 || tentativa[0] < 1)
                    System.out.println("Linha inválida. Apenas 1, 2 ou 3");
            }while (tentativa[0] > 3 || tentativa[0]< 1);
            do {
                System.out.println("Coluna ");
                tentativa[1] = sc.nextInt();
                if (tentativa[1] > 3 || tentativa[1] < 1)
                    System.out.println("Coluna inválida. Apenas 1, 2 ou 3");
            }while (tentativa[1] > 3 || tentativa[1] < 1);
                tentativa[0]--;
                tentativa[1]--;

                if (!verifTentativa(tentativa, tabuleiro))
                    System.out.println("Esse local já foi marcado.");
        }while (!verifTentativa(tentativa,tabuleiro));
    }
}
