package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  private ArrayList<String> cpfsComputados;
  private ArrayList<PessoaCandidata> pessoasCandidatas;

  private ArrayList<PessoaEleitora> pessoasEleitoras;

  /**
   * Método construtor.
   */
  public GerenciamentoVotacao() {
    this.cpfsComputados = new ArrayList<>();
    this.pessoasCandidatas = new ArrayList<>();
    this.pessoasEleitoras = new ArrayList<>();
  }

  public ArrayList<String> getCpfsComputados() {
    return cpfsComputados;
  }

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    boolean numeroExistente = false;

    for (PessoaCandidata pessoaCandidata : this.pessoasCandidatas) {
      if (pessoaCandidata.getNumero() == numero) {
        numeroExistente = true;
        break;
      }
    }
    if (numeroExistente) {
      System.out.println("Número da pessoa candidata já utilizado!");
    } else {
      PessoaCandidata novaPessoaCandidata = new PessoaCandidata(nome, numero);
      this.pessoasCandidatas.add(novaPessoaCandidata);
    }
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    boolean cpfExistente = false;

    for (PessoaEleitora pessoaEleitora : this.pessoasEleitoras) {
      if (pessoaEleitora.getCpf().equals(cpf)) {
        cpfExistente = true;
        break;
      }
    }

    if (cpfExistente) {
      System.out.println("Pessoa eleitora já cadastrada!");
    } else {
      PessoaEleitora pessoaEleitora = new PessoaEleitora(nome, cpf);
      this.pessoasEleitoras.add(pessoaEleitora);
    }
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (this.cpfsComputados.contains(cpfPessoaEleitora)) {
      System.out.println("Pessoa eleitora já votou!");
    } else {
      for (PessoaCandidata pessoaCandidata : this.pessoasCandidatas) {
        if (pessoaCandidata.getNumero() == numeroPessoaCandidata) {
          pessoaCandidata.receberVoto();
          this.cpfsComputados.add(cpfPessoaEleitora);
          break;
        }
      }
    }
  }

  @Override
  public void mostrarResultado() {
    if (cpfsComputados.isEmpty()) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
      return;
    }

    int totalDeVotos = cpfsComputados.size();
    for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
      int votos = pessoaCandidata.getVotos();
      System.out.println(
          "Nome: " + pessoaCandidata.getNome() + " - " + votos + " votos ( " + calcularPorcentagem(
              votos, totalDeVotos) + "% )");
    }

    System.out.println("Total de votos: " + totalDeVotos);
  }

  private long calcularPorcentagem(int votos, int totalDeVotos) {
    if (votos == 0) {
      return 0;
    }
    double porcentagem = (votos * 100.0) / totalDeVotos;
    return Math.round(porcentagem);
  }
}
