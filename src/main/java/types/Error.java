package types;

public enum Error {

    OUT_COORDINATE("Error!!! No es una coordenada del tablero"), 
    EMPTY_ORIGIN("Error!!! No hay ficha que mover"), 
    OPPOSITE_PIECE("Error!!! No es una de tus fichas"),
    NOT_DIAGONAL("Error!!! No vas en diagonal"),
    BAD_DISTANCE("Error!!! No respetas la distancia"),
    NOT_EMPTY_TARGET("Error!!! No está vacío el destino"),
    NOT_ADVANCED("Error!!! No avanzas"),
    EATING_EMPTY("Error!!! No comes contrarias"),
    WRONG_OPTION("Error!!! Opción incorrecta"),
	WRONG_FORMAT("Error!!! No te entiendo: <d><d>{,<d><d>}[0-2]"),
	NOT_EAT("Error!!! No se puede comer tantas en un movimiento"),
	NOT_EAT_JUMP("Error!!! No se puede comer tantas en un salto");
	
    private String text;
    
    Error(String text) {
        this.text = text;
    }
 
    public String getText() {
        return text;
    }
}

