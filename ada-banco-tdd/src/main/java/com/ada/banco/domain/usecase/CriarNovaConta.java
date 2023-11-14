package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.ContaGateway;
import com.ada.banco.domain.model.Conta;

public class CriarNovaConta {

    private ContaGateway contaGateway;

    public CriarNovaConta(ContaGateway contaGateway) {
        this.contaGateway = contaGateway;
    }

    public Conta execute(Conta conta) throws Exception {
        // validar se o usuário já possui uma conta
        // - se possuir => vamos lançar uma exception, porque vai ter um endpoint para front consultar se usuário tem uma conta
        if(this.contaGateway.buscarPorCpf(conta.getCpf()) != null) {
            throw new Exception("Usuário já possui uma conta.");
        }

        // - se não => cria uma nova conta
        Conta novaConta = this.contaGateway.salvar(conta);

        return novaConta;
    }


}
