package dominio;

public enum SituacaoItem {
	INDEFINIDO("Indefinido"),DEFERIDO("Deferido"),INDEFERIDO("Indeferido");
	
	private String value;

	private SituacaoItem(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
