package com.dio.domain;

public class ContaCorrente extends Conta {
    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void ìmprimirExtrato() {
        System.out.println("EXTRATO CONTA CORRENTE");
        super.imprimirConta();
    }
}