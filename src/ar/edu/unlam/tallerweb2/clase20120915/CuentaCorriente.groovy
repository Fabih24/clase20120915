package ar.edu.unlam.tallerweb2.clase20120915

class CuentaCorriente extends Cuenta {
	
	def debitoAdicional = 0
	def debitoAdicionalPosteriorAccionRecargo = 2
	int descubiertoPermitido = 1000
	def posteriorAccionRecargo = 5
	
	@Override
	double extraer(double importe) {
		
		this.prohibirImporteNegativo(importe)
		
		if (cantidadMovimientos >= posteriorAccionRecargo) {
			debitoAdicional = debitoAdicionalPosteriorAccionRecargo
		}
					
		if (importe > (saldo + descubiertoPermitido)) {
			throw new SaldoInsuficienteException('Usted no tiene los fondos necesarios para realizar esta operación.')
		}
		
		saldo = saldo - importe - debitoAdicional
		
		cantidadMovimientos++
		
		saldo
	}
}
