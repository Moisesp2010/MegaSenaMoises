package megasenav6;

import java.util.Optional;

public class Premio {

        private final double valor;

        public Premio(double valor) {
            this.valor = valor;
        }

        public double calcula(Aposta aposta, Resultado resultado){
            int acertos = aposta.calculaAcertos(resultado);
            Optional<TipoPremio> tipoPremio = TipoPremio.of(acertos);
            return tipoPremio.isPresent()? tipoPremio.get().calculaValor(valor): 0.0;
        }

        public double getValor(){
            return valor;
        }
    }


