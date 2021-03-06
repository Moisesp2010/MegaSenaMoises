package megasenav6;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Aposta {


    public static final int MENOR = 6;
    public static final int MAIOR = 15;
    public static final int PRIMEIRO_NUMERO = 1;
    public static final int ULTIMO_NUMERO = 60;

    private final List<Integer> numeros;

    public Aposta(List<Integer> numeros) {
        if (!isApostaValida(numeros)) {
            throw new IllegalArgumentException("Aposta inválida:" + numeros);
        }
        this.numeros = Collections.unmodifiableList(numeros);
    }

    private boolean isApostaValida(List<Integer> numerosApostados) {
        return numerosApostados.size() >= MENOR && numerosApostados.size() <= MAIOR &&
                numerosApostados.stream().
                        distinct().filter(n -> n >= PRIMEIRO_NUMERO && n <= ULTIMO_NUMERO).
                        count() == numerosApostados.size();
    }

    public int calculaAcertos(Resultado resultado) {
        return (int) numeros.stream().filter(n -> resultado.foiSorteado(n)).count();
    }

    public List<Integer> getNumeros() {
        return numeros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aposta aposta = (Aposta) o;
        return Objects.equals(numeros, aposta.numeros);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeros);
    }

}


