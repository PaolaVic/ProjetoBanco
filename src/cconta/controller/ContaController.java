package cconta.controller;

import java.util.ArrayList;

import cconta.model.Conta;
import cconta.repository.ContaRepository;

public class ContaController implements ContaRepository{

	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;
	
	@Override
	public void procurarPorNumero(int numero) {
		// TODO Auto-generated method stub
		var conta = buscarNaCollection(numero);
		
		if(conta !=null)
			conta.visualizar();
		else
			System.out.println("\nA conta número: " + numero + " nao foi encontrada!" );
	}
	@Override
	public void listarTodas() {
		for (Conta conta : listaContas) {
			conta.visualizar();
		}	
	}
	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("Conta número" + conta.getNumero() + " cadastrada com sucesso");	
	}
	@Override
	public void atualizar(Conta conta) {
		var buscarConta = buscarNaCollection(conta.getNumero());
		
		if(conta !=null) {
			listaContas.set(listaContas.indexOf(buscarConta),conta);
			System.out.println("A conta número: " + conta.getNumero() + " foi atualizada com sucesso!");
		} else {
            System.out.println("Conta numero: " + conta.getNumero() + " nao foi encontrada!");
		}
		
	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);

        if(conta != null) {
            if(listaContas.remove(conta) == true)
                System.out.println("A conta numero: " + numero + " foi deletada com sucesso!");
        } else {
            System.out.println("A conta numero: " + numero + " nao foi encontrada!" );
        }
    }

	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
        if (conta != null) {
            if(conta.sacar(valor) == true) {
                System.out.println("Saque na conta numero: " + numero + " foi efetuado com sucesso!");
            }
            else {
                System.out.println("A conta numero: " + numero + " nao foi encontrada!");
            }
        }
		
	}

	@Override
	public void depositar(int numero, float valor) {
		var conta = buscarNaCollection(numero);

        if(conta != null) {
            conta.depositar(valor);
            System.out.println("O Depósito na conta numero: " + numero + " foi efetuado com sucesso!");
        } else {
            System.out.println("A conta numero: " + numero + " nao foi encontrada ou a conta destino nao é uma conta corrente!");
        }
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaCollection(numeroOrigem);
        var contaDestino = buscarNaCollection(numeroDestino);

        if(contaOrigem != null && contaDestino != null) {
            if(contaOrigem.sacar(valor) == true) {
                contaDestino.depositar(valor);
                System.out.println("A Transferência foi efetuada!");
            }
            else {
                System.out.println("A conta de origem e/ou destino nao foram encontradas!");
            }
        }
    }

    public int gerarNumero() {
        return ++ numero;
    }

    public Conta buscarNaCollection(int numero) {
        for(var conta: listaContas) {
            if(conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
		
	}

}
