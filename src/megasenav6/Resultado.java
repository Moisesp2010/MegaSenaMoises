package megasenav6;

import java.util.Collections;
import java.util.List;

public class Resultado {



        private final List<Integer> numeros;

        public Resultado(List<Integer> numeros) {
            this.numeros = Collections.unmodifiableList(numeros);
        }

        public boolean foiSorteado(Integer numero) {
            return numeros.contains(numero);
        }

        public List<Integer> getNumeros() {
            return numeros;
        }
    }


