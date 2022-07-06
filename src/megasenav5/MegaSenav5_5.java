package megasenav5;

import java.util.List;

public class MegaSenav5_5 {

        public double calculaPremio(List<Integer> apostados, List<Integer> sorteados, double premioTotal) {
            if (!isApostaValida(apostados)) {
                throw new IllegalArgumentException("Aposta inválida:" + apostados);
            }
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

        private int calculaAcertos(List<Integer> apostados, List<Integer> sorteados) {
            return (int) apostados.stream().filter(n -> sorteados.contains(n)).count();
        }
    }


