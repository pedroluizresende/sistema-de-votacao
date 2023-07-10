package com.betrybe.sistemadevotacao;

import java.util.Scanner;

public class Principal {

  /**
   * Método main responsável por inicial a aplicação.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();
    int opcaoCandidato;
    do {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente á opção desejada:");

      opcaoCandidato = Integer.parseInt(scanner.next());
      if (opcaoCandidato == 1) {
        System.out.println("Entre com o nome da pessoa candidata:");
        String nomeCandidato = scanner.next();
        System.out.println("Entre com o número da pessoa candidata:");
        int numeroCandidato = Integer.parseInt(scanner.next());
        gerenciamentoVotacao.cadastrarPessoaCandidata(nomeCandidato, numeroCandidato);
      }
    } while (opcaoCandidato != 2);

    int opcaoEleitora;

    do {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente á opção desejada:");

      opcaoEleitora = Integer.parseInt(scanner.next());

      if (opcaoEleitora == 1) {
        System.out.println("Entre com o nome da pessoa eleitora:");
        String nome = scanner.next();
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpf = scanner.next();
        gerenciamentoVotacao.cadastrarPessoaEleitora(nome, cpf);
      }
    } while (opcaoEleitora != 2);

    int opcaoVotacao;

    do {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");

      opcaoVotacao = Integer.parseInt(scanner.next());

      if (opcaoVotacao == 1) {
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpf = scanner.next();
        System.out.println("Entre com o número da pessoa candidata:");
        int numero = Integer.parseInt(scanner.next());
        gerenciamentoVotacao.votar(cpf, numero);
      }

      if (opcaoVotacao == 2) {
        gerenciamentoVotacao.mostrarResultado();
      }

    } while (opcaoVotacao != 3);

    gerenciamentoVotacao.mostrarResultado();
  }


}

