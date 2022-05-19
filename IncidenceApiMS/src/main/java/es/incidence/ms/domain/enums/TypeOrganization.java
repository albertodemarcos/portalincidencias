package es.incidence.ms.domain.enums;

public enum TypeOrganization {

	TOWN_HALL				( 1, "GRUPOTIPOOPERACION.REFRIGERACION" ),
	COMMONWEALTH 			( 2, "GRUPOTIPOOPERACION.REFRIGERACION" ),
	ADMINISTRATIVE_REGIONS 	( 3, "GRUPOTIPOOPERACION.REFRIGERACION" ),
	STATE 					( 4, "GRUPOTIPOOPERACION.REFRIGERACION" ),
	CONFEDERATION			( 5, "GRUPOTIPOOPERACION.REFRIGERACION" );
	
	
	private final int value;
	private final String message;
	
	TypeOrganization( int value, String message ){
		this.value = value;
		this.message = message; 
	}
	
	public String getMessage() {
		return message; 
	}
	
	public int getValue() {
		return value; 
	}
}
