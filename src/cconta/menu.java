package cconta;

import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;

import cconta.model.ContaCorrente;
import cconta.model.ContaPoupanca;
import cconta.util.cores;

public class menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stubs
		
		ContaCorrente cc1 = new ContaCorrente(1304, 1995 , 5, "Antonio", 1000.0f);
		cc1.visualizar();
		cc1.sacar(12000.0f);
		cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();
		
		ContaPoupanca cp1 = new ContaPoupanca(1989, 179, 2, "Alessandra", 100000.0f, 15);
		cp1.visualizar();
        cp1.sacar(1000.0f);
		cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();
		Scanner leia = new Scanner(System.in);

		int opcao;

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
			}catch(InputMismatchException e) {
System.out.println("\nDigite valores inteiros!");
leia.nextLine();
opcao=0;

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

					break;
				case 2:
					System.out.println(cores.TEXT_WHITE_BOLD +"Listar todas as Contas\n\n");

					break;
				case 3:
					System.out.println(cores.TEXT_WHITE_BOLD +"Consultar dados da Conta - por número\n\n");

					break;
				case 4:
					System.out.println(cores.TEXT_WHITE_BOLD +"Atualizar dados da Conta\n\n");

					break;
				case 5:
					System.out.println(cores.TEXT_WHITE_BOLD +"Apagar a Conta\n\n");

					break;
				case 6:
					System.out.println(cores.TEXT_WHITE_BOLD +"Saque\n\n");

					break;
				case 7:
					System.out.println(cores.TEXT_WHITE_BOLD +"Depósito\n\n");

					break;
				case 8:
					System.out.println(cores.TEXT_WHITE_BOLD +"Transferência entre Contas\n\n");

					break;
				default:
					System.out.println(cores.TEXT_RED_BOLD +"\nOpção Inválida!\n" + cores.TEXT_RESET);
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
			
			System.out.println(cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();
			
		} catch (IOException e) {
			
			System.out.println("Você pressionou uma tecla diferente de enter");
		}
	}

}
