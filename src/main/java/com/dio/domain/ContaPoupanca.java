package com.dio.domain;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void ìmprimirExtrato() {
        System.out.println("EXTRATO CONTA CORRENTE");
        super.imprimirConta();
    }
}