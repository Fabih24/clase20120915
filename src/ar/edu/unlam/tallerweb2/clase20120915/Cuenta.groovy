package ar.edu.unlam.tallerweb2.clase20120915

abstract class Cuenta {
	
	def saldo
	def cantidadMovimientos
	Cliente cliente
	
	abstract double extraer(double importe);
	
	void prohibirImporteNegativo(double importe) {
		if (importe < 0) {
			throw new ImporteNegativoException("Espere por favor mientras le mandamos a la policia.")
		}
	}
}
