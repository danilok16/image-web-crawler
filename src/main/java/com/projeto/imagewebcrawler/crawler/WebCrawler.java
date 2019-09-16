package com.projeto.imagewebcrawler.crawler;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebCrawler {
	private String src;

	public void getPageLinks(String URL) {
		UrlBuffer urlBuffer = UrlBuffer.getInstance();
		try {
			Document document = Jsoup.connect(URL).get();
			Elements linksOnPage = document.getElementsByTag("img");
			for (Element page : linksOnPage) {
				src = page.absUrl("src");
				if(isURL(src)) {
					UrlBuffer.getInstance().insertUrl(src);
				}
			}
			urlBuffer.decrementar();
		} catch (IOException e) {
			System.err.println("For '" + URL + "': " + e.getMessage());
		}
	}

	@SuppressWarnings("static-access")
	public void downloadImage() {
		String imageUrl = null;
		UrlBuffer urlBuffer = UrlBuffer.getInstance();
		if (!urlBuffer.getUrl().isEmpty()) {
			imageUrl = urlBuffer.getUrlToDownload();
			try {
				InputStream inputStream = new URL(imageUrl).openStream();
				Files.copy(inputStream, Paths.get("C:\\Users\\dkaus\\Downloads\\down\\" + Math.random() + ".png"));
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean isURL(String url) {
		  try {
		     (new java.net.URL(url)).openStream().close();
		     return true;
		  } catch (Exception ex) { }
		  return false;
		}
}
