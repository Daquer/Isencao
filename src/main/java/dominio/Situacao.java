package dominio;

public enum Situacao {
	EMANALISE("Em an�lise"),ANALISADA("Analisada");
	
	private String value;
	
	private Situacao(String situacao){
		this.value = situacao;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
