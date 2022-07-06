package megasenav5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MegaSenav5_2 {



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
            if (numerosApostados.size() < 6 || numerosApostados.size() > 15) {
                return false;
            }
            List<Integer> numerosValidos = new ArrayList<>();
            for (Integer apostado : numerosApostados) {
                if (apostado < 1 || apostado > 60) {
                    return false; // inválido
                }
                if (numerosValidos.contains(apostado)) {
                    return false; // repetido
                }
                numerosValidos.add(apostado);
            }
            return true;
        }

        private List<Integer> sorteiaSeisNumeros() {
            List<Integer> sorteados = new ArrayList<>();
            int numeroSorteado;
            while (sorteados.size() < 6) {
                numeroSorteado = new Random().nextInt(59) + 1;
                if (!sorteados.contains(numeroSorteado)) {
                    sorteados.add(numeroSorteado);
                }
            }
            return sorteados;
        }

        private int calculaAcertos(List<Integer> apostados, List<Integer> sorteados) {
            int acertos = 0;
            for (Integer apostado : apostados) {
                if (sorteados.contains(apostado)) {
                    acertos++;
                }
            }
            return acertos;
        }
    }


