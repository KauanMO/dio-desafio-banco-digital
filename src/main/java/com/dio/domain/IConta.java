package com.dio.domain;

import com.dio.exceptions.SaldoException;

public interface IConta {
    void sacar(Double valor) throws SaldoException;

    void depositar(Double valor);

    void transferir(Double valor, IConta contaDestino) throws SaldoException;

    void ìmprimirExtrato();
}
