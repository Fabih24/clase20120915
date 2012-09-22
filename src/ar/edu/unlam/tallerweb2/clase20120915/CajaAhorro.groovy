package ar.edu.unlam.tallerweb2.clase20120915

class CajaAhorro extends Cuenta {

	def limiteExtraccion = 1000
	
	@Override
	public double extraer(double importe) {
		
		this.prohibirImporteNegativo(importe)
		
		if (importe > limiteExtraccion) { 
			throw new LimiteExtraccionException('Usted no puede retir m�s de $'+limiteExtraccion);
		} 
		
		saldo = saldo - importe
		
		if (saldo < 0) {
			throw new SaldoInsuficienteException('Usted no tiene los fondos necesarios para realizar esta operaci�n.')
		}
		
		saldo
	}

}
