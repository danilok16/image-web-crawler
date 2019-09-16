package com.projeto.imagewebcrawler.thread;

import com.projeto.imagewebcrawler.crawler.WebCrawler;

public class ImageUrlThread implements Runnable {
	
private String url;
	
	public ImageUrlThread(String url) {
		this.url = url;
	}
	
	public void run() {
		new WebCrawler().getPageLinks(url);
	}

}
