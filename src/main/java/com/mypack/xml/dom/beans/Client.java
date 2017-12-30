package com.mypack.xml.dom.beans;

import java.util.List;

public class Client {
 
	String webmart, webmartCode;
	
	List<FileToProcess> listFileToProcess;
	
	public Client() {
		
	}
	
	public String getWebmart() {
		return webmart;
	}
	public void setWebmart(String webmart) {
		this.webmart = webmart;
	}
	public String getWebmartCode() {
		return webmartCode;
	}
	public void setWebmartCode(String webmartCode) {
		this.webmartCode = webmartCode;
	}
	
	public List<FileToProcess> getListFileToProcess() {
		return listFileToProcess;
	}

	public void setListFileToProcess(List<FileToProcess> listFileToProcess) {
		this.listFileToProcess = listFileToProcess;
	}

	
}
