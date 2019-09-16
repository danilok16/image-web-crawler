package com.projeto.imagewebcrawler.crawler;

import java.util.ArrayList;
import java.util.List;


public class UrlBuffer {
	private static UrlBuffer instance = null;
	private static List<String> url;
	private static Integer cont;

	synchronized public static UrlBuffer getInstance() {
		if (instance == null) {
			instance = new UrlBuffer();
			url = new ArrayList<String>();
			cont = 0;
		}
		return instance;
	}

	synchronized public void insertUrl(String url) {
		this.url.add(url);
	}

	synchronized public String getUrlToDownload() {
		String urlAux = null;

		if (url != null && url.size() > 0) {
			urlAux = url.remove(0);
		}

		return urlAux;
	}

	public static List<String> getUrl() {
		return url;
	}

	public static void setUrl(List<String> url) {
		UrlBuffer.url = url;
	}

	synchronized public void incrementar() {
		cont = cont + 1;
	}

	synchronized public void decrementar() {
		cont = cont - 1;
	}

	synchronized public static Integer getCont() {
		return cont;
	}

	synchronized public static void setCont(Integer cont) {
		UrlBuffer.cont = cont;
	}

	
}
