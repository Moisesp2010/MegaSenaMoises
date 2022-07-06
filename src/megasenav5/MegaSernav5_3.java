package megasenav5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MegaSernav5_3 {


        public double calculaPremio(List<Integer> apostados, double premioTotal) {
            if (!isApostaValida(apostados)) return 0.0;
            List<Integer> sorteados = sorteiaSeisNumeros();
            long acertos = calculaAcertos(apostados, sorteados);
            if (acertos == 6) {
                return premioTotal; // Sena = 100%
            } else if (acertos == 5) {
                return premioTotal * 0.2; // Quina = 20%
            } else if (acertos == 4) {
                return premioTotal * 0.05; // Quadra = 5%
            }
            return 0.0;
        }

        private boolean isApostaValida(List<Integer> numerosApostados) {
            return numerosApostados.size() >= 6 && numerosApostados.size() <= 15 &&
                    numerosApostados.stream().distinct().filter(n -> n >= 1 && n <= 60).
                            count() == numerosApostados.size();
        }

        private List<Integer> sorteiaSeisNumeros() {
            List<Integer> numerosSorteados = new ArrayList<>();
            int numeroSorteado;
            while (numerosSorteados.size() < 6) {
                numeroSorteado = new Random().nextInt(59) + 1;
                if (!numerosSorteados.contains(numeroSorteado)) {
                    numerosSorteados.add(numeroSorteado);
                }
            }
            return numerosSorteados;
        }

        private int calculaAcertos(List<Integer> apostados, List<Integer> sorteados) {
            return (int) apostados.stream().filter(n -> sorteados.contains(n)).count();
        }
    }


