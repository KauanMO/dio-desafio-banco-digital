package com.dio.domain;

import com.dio.exceptions.SaldoException;

public abstract class Conta implements IConta {
    private static final Integer AGENCIA_PADRAO = 1;
    private static Integer SEQUENCIAL = 1;

    protected Integer agencia;
    protected Integer numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
    }

    @Override
    public void depositar(Double valor) {
        saldo += valor;
    }

    @Override
    public void sacar(Double valor) throws SaldoException {
        if (valor > saldo) {
            throw new SaldoException();
        }

        saldo -= valor;
    }

    @Override
    public void transferir(Double valor, IConta contaDestino) throws SaldoException {
        this.sacar(valor);

        contaDestino.depositar(valor);
    }

    protected void imprimirConta() {
        System.out.printf("Titular: %s\n", this.cliente.getNome());
        System.out.printf("Agencia: %s\n", getAgencia());
        System.out.printf("Número: %s\n", getNumero());
        System.out.printf("Saldo: %s\n", getSaldo());
    }

    public Integer getAgencia() {
        return agencia;
    }

    public Integer getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }
}
