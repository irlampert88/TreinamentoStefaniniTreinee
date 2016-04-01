package programa.entidades;

public final class IpVisitante {

	private final String ip;
	
	public IpVisitante(String dadoBruto) {
		this.ip = extrairIpVisitanteDoDadoBruto(dadoBruto);
	}

	private String extrairIpVisitanteDoDadoBruto(String dadoBruto) {
		String[] dadosSeparados = dadoBruto.split("-");
		String ip = dadosSeparados[1];
		
		// Em caso de 2 ips, usar o segundo
		if (ip.contains(","))
			ip = ip.split(",")[1].trim();
		
		return ip;
	}

	public final String getIp() {
		return ip;
	}

	@Override
	public final int hashCode() {
		return ip.hashCode();
	}
	
	@Override
	public final String toString() {
		return ip;
	}
	
}
