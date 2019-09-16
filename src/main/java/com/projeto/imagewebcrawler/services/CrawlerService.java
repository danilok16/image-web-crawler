package com.projeto.imagewebcrawler.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projeto.imagewebcrawler.crawler.UrlBuffer;
import com.projeto.imagewebcrawler.model.UrlModel;
import com.projeto.imagewebcrawler.thread.ImageDownloadThread;
import com.projeto.imagewebcrawler.thread.ImageUrlThread;

@Service
public class CrawlerService {
	
	UrlBuffer urlBuffer = UrlBuffer.getInstance();

	public void imageCrawler(List<UrlModel> listUrl) {
		for(UrlModel obj:listUrl) {
			new Thread(new ImageUrlThread(obj.getUrl())).start();
			urlBuffer.incrementar();
		}
		
		while (UrlBuffer.getCont() > 0 || !UrlBuffer.getUrl().isEmpty()) {
			if (!UrlBuffer.getUrl().isEmpty()) {
				new Thread(new ImageDownloadThread()).start();
			}
		}
	}

}
