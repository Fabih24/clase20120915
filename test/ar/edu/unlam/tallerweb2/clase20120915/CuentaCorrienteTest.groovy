package ar.edu.unlam.tallerweb2.clase20120915

import org.junit.Test


class CuentaCorrienteTest {
	
	@Test
	void crearCuentaCorrienteTest(){
		Cliente cliente1 = new Cliente(nombre:'Pedro')
		CuentaCorriente cuentaCorriente1 = new CuentaCorriente(saldo:3000, cliente:cliente1, cantidadMovimientos:0)
		assert cuentaCorriente1.saldo == 3000	
	}
	
	
	@Test
	void extraerCuentaCorrienteTest(){
		Cliente cliente1 = new Cliente(nombre:'Pedro')
		CuentaCorriente cuentaCorriente1 = new CuentaCorriente(saldo:3000, cliente:cliente1, cantidadMovimientos:0)
		cuentaCorriente1.extraer(350) 
		assert cuentaCorriente1.saldo == 2650			
	}
	
	@Test
	void extraerVariosMovimientosCuentaCorrienteTest(){
		Cliente cliente1 = new Cliente(nombre:'Pedro')
		CuentaCorriente cuentaCorriente1 = new CuentaCorriente(saldo:3000, cliente:cliente1, cantidadMovimientos:0)
		cuentaCorriente1.extraer(1)
		cuentaCorriente1.extraer(1)
		cuentaCorriente1.extraer(1)
		cuentaCorriente1.extraer(1)
		cuentaCorriente1.extraer(1)
		cuentaCorriente1.extraer(1)
		assert cuentaCorriente1.saldo == 2992
	}
	@Test(expected = ImporteNegativoException)
	void extraerImporteNegativo(){
		Cliente cliente1 = new Cliente(nombre:'Pedro')
		CuentaCorriente cuentaCorriente1 = new CuentaCorriente(saldo:3000, cliente:cliente1, cantidadMovimientos:0)
		cuentaCorriente1.extraer(-4000)
	}
	@Test(expected = SaldoInsuficienteException)
	void extraerMayorSaldoDelPermitido(){
		Cliente cliente1 = new Cliente(nombre:'Pedro')
		CuentaCorriente cuentaCorriente1 = new CuentaCorriente(saldo:3000, cliente:cliente1, cantidadMovimientos:0)
		cuentaCorriente1.extraer(4001)
	}
}
