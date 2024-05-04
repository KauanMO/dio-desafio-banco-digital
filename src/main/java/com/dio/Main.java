package com.dio;

import com.dio.domain.Cliente;
import com.dio.domain.Conta;
import com.dio.domain.ContaCorrente;
import com.dio.domain.ContaPoupanca;
import com.dio.exceptions.SaldoException;

public class Main {
    public static void main(String[] args) {
        Cliente kauan = new Cliente();
        kauan.setNome("Kauan");

        Conta contaCorrente = new ContaCorrente(kauan);
        Conta contaPoupanca = new ContaPoupanca(kauan);

        contaCorrente.depositar(200.00);

        try {
            contaPoupanca.sacar(100.50);
        } catch (SaldoException e) {
            System.out.println("Sem saldo suficiente para saque");
        }

        try {
            contaCorrente.transferir(150.00, contaPoupanca);
        } catch (SaldoException e) {
            System.out.println("Sem saldo suficiente para transferencia");
        }

        contaCorrente.ìmprimirExtrato();
        contaPoupanca.ìmprimirExtrato();
    }
}