package megasenav6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GloboGiratorio {

    private final int ultimoNumero;

    public GloboGiratorio(int ultimoNumero) {
        this.ultimoNumero = ultimoNumero;
    }

    public Resultado sorteiaNumeros(int quantidade) {
        if (quantidade > ultimoNumero) {
            String msg = "A quantidade a ser sorteada '%d' supera a quantidade de números disponíveis '%d'!";
            throw new IllegalArgumentException(String.format(msg, quantidade, ultimoNumero));
        }
        List<Integer> numerosSorteados = new ArrayList<>();
        int numeroSorteado;
        while (numerosSorteados.size() < quantidade) {
            numeroSorteado = new Random().nextInt(ultimoNumero - 1) + 1;
            if (!numerosSorteados.contains(numeroSorteado)) {
                numerosSorteados.add(numeroSorteado);
            }
        }
        return new Resultado(numerosSorteados);
    }

}




