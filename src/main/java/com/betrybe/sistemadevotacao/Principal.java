package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

public class Principal {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    GerenciamentoVotacao sistema = new GerenciamentoVotacao();
    sistema.cadastrarPessoaCandidata("Lula", 13);
    sistema.cadastrarPessoaCandidata("Inelegivel", 22);

    sistema.cadastrarPessoaEleitora("Pedro", "123132313");
    sistema.cadastrarPessoaEleitora("Eloisa", "12333456676");
    sistema.cadastrarPessoaEleitora("Gado1", "12333333333");

    sistema.votar("123132313", 13);
    sistema.votar("12333456676", 13);
    sistema.votar("12333333333", 22);

    sistema.mostrarResultado();
  }

}
