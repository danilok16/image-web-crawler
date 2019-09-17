package com.projeto.imagewebcrawler.model;

import java.io.Serializable;
import java.util.List;

public class UrlModel implements Serializable {
	private static final long serialVersionUID = -4850586552061631628L;
	
	private List <String>url;

	public UrlModel() {
		
	}
	
	
	public List<String> getUrl() {
		return url;
	}


	public void setUrl(List<String> url) {
		this.url = url;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UrlModel other = (UrlModel) obj;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	
	
	

}
