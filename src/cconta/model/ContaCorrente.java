package cconta.model;

public class ContaCorrente  extends Conta {
	
	private float limite;

	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
		// TODO Auto-generated constructor stub
	}

	public float getLimite() {
        return limite;
    
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
		public boolean sacar(float valor) {
			if(this.getSaldo() + this.getLimite() <valor) {
				System.out.println("\n Saldo Insuficiente!");
				return false;
			}
			
			this.setSaldo(this.getSaldo() - valor);
			return true;
			
		}
			public void visualizar() {
				super.visualizar();
				System.out.println("Limite de Crédito: " + this.limite);
			}
		}
