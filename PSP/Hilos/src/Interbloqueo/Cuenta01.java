package Interbloqueo;

public class Cuenta01 {
	
	private double saldo;
	private final int id;
	
	public Cuenta01(double saldo, int id) {
		super();
		this.saldo = saldo;
		this.id = id;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getId() {
		return id;
	}
	
	public synchronized void retirar(double cantidad) {
        saldo -= cantidad;
    }

    public synchronized void ingresar(double cantidad) {
        saldo += cantidad;
    }
}
