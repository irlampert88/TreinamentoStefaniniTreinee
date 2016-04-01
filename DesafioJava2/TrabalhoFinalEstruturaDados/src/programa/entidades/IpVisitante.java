package programa.entidades;

public class IpVisitante {

	private final String ip;
	
	public IpVisitante(String dadoBruto) {
		this.ip = extrairIpVisitanteDoDadoBruto(dadoBruto);
	}

	private String extrairIpVisitanteDoDadoBruto(String dadoBruto) {
		String[] dadosSeparados = dadoBruto.split("-");
		String ip = dadosSeparados[1];
		
		// Em caso de 2 ips, usar o segundo
		if (ip.contains(",")) {
			ip = ip.split(",")[1].trim();
		}
		
		return ip;
	}

	public String getIp() {
		return ip;
	}

	@Override
	public int hashCode() {
		return ip.hashCode();
	}
	
	@Override
	public String toString() {
		return ip;
	}
	
}
