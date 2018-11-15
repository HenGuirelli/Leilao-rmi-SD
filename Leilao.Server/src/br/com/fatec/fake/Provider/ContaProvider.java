package br.com.fatec.fake.Provider;

import br.com.fatec.DTO.ILoginDTO;
import br.com.fatec.exceptions.ContaExisteException;
import br.com.fatec.model.Conta;
import br.com.fatec.enums.TipoConta;
import br.com.fatec.model.Participante;
import br.com.fatec.model.Usuario;

public class ContaProvider  implements ILoginDTO {
    
    public void save(Conta conta) throws ContaExisteException{
        /* nada pra fazer aqui */
    }

    public Usuario signIn(Conta conta) {
        Usuario u = new Participante();
        u.setConta(conta);
        conta.setTipoConta(TipoConta.PARTICIPANTE);
        return u;
    }

    public void update(Conta conta) {
        /* nada a fazer */
    }   
}
