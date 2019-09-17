package com.projeto.imagewebcrawler.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.imagewebcrawler.model.UrlModel;
import com.projeto.imagewebcrawler.services.CrawlerService;

@RestController
@RequestMapping(value="/crawler")
public class WebCrawlerResoucer {

	@Autowired
	private CrawlerService crawlerService;
	
	@RequestMapping(method = RequestMethod.GET)
	public void imageCrawler(@RequestBody UrlModel listUrl) {
		crawlerService.imageCrawler(listUrl);
	}
}
