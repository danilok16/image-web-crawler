package com.projeto.imagewebcrawler.thread;

import com.projeto.imagewebcrawler.crawler.WebCrawler;

public class ImageDownloadThread implements Runnable {

	public void run() {
		new WebCrawler().downloadImage();
	}

}
