package org.jugvale.service;

import java.util.List;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jboss.resteasy.client.ClientExecutor;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.core.executors.ApacheHttpClient4Executor;
import org.jboss.resteasy.util.GenericType;
import org.jugvale.model.Inscricao;

public class InscritosService {
	
	
	// TODO: ignorar campos
	private String usr, psw;
	private ApacheHttpClient4Executor executor;
	
	public InscritosService(String usr, String psw) {
		super();
		this.usr = usr;
		this.psw = psw;
		DefaultHttpClient httpclient = new DefaultHttpClient();     
		httpclient.getCredentialsProvider().setCredentials(
		      new AuthScope("localhost", 8080),
		      new UsernamePasswordCredentials("AUser", "psw"));

		this.executor = new ApacheHttpClient4Executor(httpclient);
	}
	
	public List<Inscricao> todosInscritos() throws Exception {
		int idEvento = 312; // TODO: tirar hardcode da URL abaixo
		ClientRequest cr = new ClientRequest("http://call4papers-jugvale.rhcloud.com/rest/evento/admin/312/inscritos");
		GenericType<List<Inscricao>> type = new GenericType<List<Inscricao>>() {};
		ClientResponse<Object> clientResponse = cr.get(type);
		System.out.println(clientResponse.getResponseStatus());
		return clientResponse.getEntity(type);
	}
	
	public void marcarPresenca(int id){
		String url = "http://call4papers-jugvale.rhcloud.com/rest/inscricao/admin/" + id + "/presenca";
		
	}

}
