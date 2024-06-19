package cconta;

import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;

import cconta.controller.ContaController;
import cconta.model.ContaCorrente;
import cconta.model.ContaPoupanca;
import cconta.util.cores;

public class menu {

	public static void main(String[] args) {
		
		ContaController contas = new ContaController();
		// TODO Auto-generated method stubs
		Scanner leia = new Scanner(System.in);
		int opcao, numero, agencia, tipo, aniversario, numeroDestino;;
		String titular;
		float saldo, limite, valor;
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva, 1000f, 100.0f");
		contas.cadastrar(cc1);
		
		ContasCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc2);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
		contas.cadastrar(cp1);
		
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Juliana Ramos", 8000f, 15);
		contas.cadastrar(cp2);
		
		while (true) {

			System.out.println(cores.TEXT_WHITE+ cores.ANSI_BLACK_BACKGROUND 
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("               BANCO CENTRAL DO BRAZIL               ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta:                          ");
			System.out.println("            2 - Listar todas as Contas:               ");
			System.out.println("            3 - Buscar Conta por Numero:              ");
			System.out.println("            4 - Atualizar Dados da Conta:             ");
			System.out.println("            5 - Apagar Conta:                         ");
			System.out.println("            6 - Sacar:                                ");
			System.out.println("            7 - Depositar:                            ");
			System.out.println("            8 - Transferir valores entre Contas:      ");
			System.out.println("            9 - Sair.                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     "+ cores.TEXT_RESET);
			
			try {
                opcao = leia.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Digite valores inteiros!");
                leia.nextLine();
                opcao = 0;
            }
			
			if (opcao == 9) {
                System.out.println(cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
                sobre();
                leia.close();
                System.exit(0);
			}

			switch (opcao) {
				case 1:
					System.out.println(cores.TEXT_WHITE_BOLD +"Criar Conta\n\n");
					
					System.out.println("Digite o Numero da Agência: ");
					agencia = leia.nextInt();
					System.out.println("Digite o Nome do Titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
					do {
						System.out.println("Digite o Tipo da Conta (1-CC ou 2-CP): ");
						tipo = leia.nextInt();
					}while(tipo < 1 && tipo > 2);
					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = leia.nextFloat();
					switch(tipo) {
					case 1 -> {
						System.out.println("Digite o Limite de Crédito");
						limite = leia.nextFloat();
						contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo));
					}
					case 2 -> {
						System.out.println("Digite o dia do Aniversario da Conta: ");
						aniversario = leia.nextInt();
						contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					}
					}							
					keyPress();
					break;
				case 2:
					System.out.println(cores.TEXT_WHITE_BOLD +"Listar todas as Contas\n\n");
					contas.listarTodas();
					keyPress();
					break;
				case 3:
					System.out.println(cores.TEXT_WHITE_BOLD +"Consultar dados da Conta - por número\n\n");
					keyPress();
					break;
				case 4:
					System.out.println(cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");

                    System.out.println("Digite o número da conta: ");
                    numero = leia.nextInt();
                    var buscarConta = contas.buscarNaCollection(numero);
                    if(buscarConta != null) {
                        tipo = buscarConta.getTipo();
					System.out.println("Digite o Numero da Agência: ");
					agencia = leia.nextInt();
					System.out.println("Digite o Nome do Titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
					
					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = leia.nextFloat();
					
					switch (tipo) {
                    case 1:
                        System.out.println("Digite o limite de crédito (R$): ");
                        limite = leia.nextFloat();
                        contas.atualizar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo));
                        break;

                    case 2:
                        System.out.println("Digite o dia do aniversario: ");
                        aniversario = leia.nextInt();
                        contas.atualizar(new ContaPoupanca(numero, tipo, titular, saldo, agencia, aniversario));
                        break;

                    default:
                        System.out.println("Tipo inválido!");
                }
            }
            else {
                System.out.println("A conta não foi encontrada!");
				}
					keyPress();
					break;
				case 5:
					System.out.println(cores.TEXT_WHITE + "Apagar a Conta\n\n");
                    System.out.println("Digite o número da conta: ");
                    numero = leia.nextInt();
                    contas.deletar(numero);
                    keyPress();
                    break;
				case 6:
					System.out.println(cores.TEXT_WHITE + "Saque\n\n");
                    System.out.println("Digite o numero da conta: ");
                    numero = leia.nextInt();
                    do {
                        System.out.println("Digite o valor do Saque (R$): ");
                        valor = leia.nextFloat();
                    } while (valor <= 0);
                    contas.sacar(numero,valor);
                    keyPress();
                    break;
				case 7:
					System.out.println(cores.TEXT_WHITE + "Depósito\n\n");
                    System.out.println("Digite o numero da conta: ");
                    numero = leia.nextInt();
                    do {
                        System.out.println("Digite o valor do deposito (R$): ");
                        valor = leia.nextFloat();
                    } while (valor <= 0);
                    keyPress();
                    break;
				case 8:
                    System.out.println(cores.TEXT_WHITE + "Transferência entre Contas\n\n");
                    System.out.println("Digite o numero da conta de origem: ");
                    numero = leia.nextInt();
                    System.out.println("Digite o numero da conta de destino: ");
                    numeroDestino = leia.nextInt();
                    do{
                        System.out.println("Digite o valor da trassnferência (R$): ");
                        valor = leia.nextFloat();
                    } while (valor <= 0 );
                    contas.transferir(numero, numeroDestino, valor);
                    keyPress();
                    break;
                default:
                    System.out.println(cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + cores.TEXT_RESET);
                    keyPress();
                    break;
			}
		}
        }
   

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Paola Victorya C.Silva ");
		System.out.println("paolavic014@outlook.com");
		System.out.println("github.com/PaolaVic");
		System.out.println("*********************************************************");
		
	}
	
	public static void keyPress() {
        try {
            System.out.println(cores.TEXT_RESET + "\nPressione Enter para Continuar...");
            System.in.read();
        } catch (IOException e) {
            System.out.println("Você pressionou uma tecla diferente de enter!");
        }
    }
}