package Jogador;
import java.lang.Math;
import java.util.Random;

import Tabuleiro.Tabuleiro;

public class Computador extends Jogador{
    public Computador(int jogador){
        super(jogador);
        System.out.println("Jogador 'Computador' criado!");
    }

    @Override
    public void jogar(Tabuleiro tabuleiro) {
        Tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa,jogador);
    }

    @Override
    public void Tentativa(Tabuleiro tabuleiro) {
        Random random = new Random();
            do {
                do {
                    tentativa[0] = random.nextInt((3 - 1)+1)+1;
                } while (tentativa[0] > 3 || tentativa[0] < 1);
                do {
                    tentativa[1] = random.nextInt((3 - 1)+1)+1;
                } while (tentativa[1] > 3 || tentativa[1] < 1);

                tentativa[0]--;
                tentativa[1]--;

            } while (!verifTentativa(tentativa, tabuleiro));
        }
}
