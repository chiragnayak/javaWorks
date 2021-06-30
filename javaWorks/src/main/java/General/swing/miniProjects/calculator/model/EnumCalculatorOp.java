package General.swing.miniProjects.calculator.model;

public enum EnumCalculatorOp {
	
	ADD ("+"),
	SUBTRACT ("-"),
	MULTIPLY ("*"),
	DEVIDE ("/");

	String symbol;
	
	EnumCalculatorOp(String symbol){
		this.symbol=symbol;
	}

	public String getSymbol() {
		return symbol;
	}
	
	public static EnumCalculatorOp fromString( String str ){
	
		for(EnumCalculatorOp xx : values()){
			
			if(xx.getSymbol().equalsIgnoreCase(str)){
				return xx;
			}
		}
		
		return null;
		
	}
	
	
}
