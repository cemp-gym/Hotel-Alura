package pe.com.hotelalura.utils;

public enum FormaDePago {
	Credito("Tarjeta de Crédito"), 
	Debito("Tarjeta de Débito"), 
	Efectivo("Dinero en efectivo");
	
	private String medioDePago;

    FormaDePago(String name) {
        this.medioDePago = name;
    }

    public String getName() {
        return this.medioDePago;
    }
    
    @Override
    public String toString() {
    	return medioDePago;
    }
}
