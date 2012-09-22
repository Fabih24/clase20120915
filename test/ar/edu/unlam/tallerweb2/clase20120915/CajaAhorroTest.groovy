package ar.edu.unlam.tallerweb2.clase20120915

import org.junit.Test

public class CajaAhorroTest {

	@Test
	void crearCajaAhorroTest(){
		Cliente cliente1 = new Cliente(nombre:'Pedro')
		CajaAhorro cajaAhorro1 = new CajaAhorro(saldo:3000, cliente:cliente1, cantidadMovimientos:0)
		assert cajaAhorro1.saldo == 3000
	}
	
	
	@Test
	void extraerCajaAhorroTest(){
		Cliente cliente1 = new Cliente(nombre:'Pedro')
		CajaAhorro cajaAhorro1 = new CajaAhorro(saldo:3000, cliente:cliente1, cantidadMovimientos:0)
		cajaAhorro1.extraer(350)
		assert cajaAhorro1.saldo == 2650
	}
	
	@Test
	void extraerVariosMovimientosCajaAhorroTest(){
		Cliente cliente1 = new Cliente(nombre:'Pedro')
		CajaAhorro cajaAhorro1 = new CajaAhorro(saldo:3000, cliente:cliente1, cantidadMovimientos:0)
		cajaAhorro1.extraer(1)
		cajaAhorro1.extraer(1)
		cajaAhorro1.extraer(1)
		cajaAhorro1.extraer(1)
		cajaAhorro1.extraer(1)
		cajaAhorro1.extraer(1)
		assert cajaAhorro1.saldo == 2994
	}
	@Test(expected = ImporteNegativoException)
	void extraerImporteNegativo(){
		Cliente cliente1 = new Cliente(nombre:'Pedro')
		CajaAhorro cajaAhorro1 = new CajaAhorro(saldo:3000, cliente:cliente1, cantidadMovimientos:0)
		cajaAhorro1.extraer(-4000)
	}
	@Test(expected = SaldoInsuficienteException)
	void extraerMayorSaldoDelPermitido(){
		Cliente cliente1 = new Cliente(nombre:'Pedro')
		CajaAhorro cajaAhorro1 = new CajaAhorro(saldo:500, cliente:cliente1, cantidadMovimientos:0)
		cajaAhorro1.extraer(501)
	}
}
