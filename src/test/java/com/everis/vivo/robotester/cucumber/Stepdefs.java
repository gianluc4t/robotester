package com.everis.vivo.robotester.cucumber;

import cucumber.api.java.pt.*;


public class Stepdefs {

	//Logger logger = LoggerFactory.getLogger(this.getClass());

	private long msisdnId;
	private String selecao;

	@Dado("^um usuario com numero (\\d+)$")
	public void selecaoUsuario(long msisdn) {
		System.out.println("XXX num tel " + msisdn);
		this.msisdnId = msisdn;
	}

	@Quando("^ele envia a opzao \"(.*?)\"$")
	public void envioOpzao(String selecao) {
		System.out.println("XXX opzao " + selecao);
		this.selecao = selecao;
	}

	@Entao("^ele deve receber a resposta \"([^\"]*)\"$")
	public void checkResposta(String selecao) throws Throwable {
		System.out.println("XXX resposta esperada \"" + selecao + "\"");
	}
	
	@E("^Ele envia uma nova opzao \"(.*?)\"$")
	public void envioNovaOpzao(String selecao) throws Throwable {
		System.out.println("XXX nova opzao " + selecao);

	}
}
