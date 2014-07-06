package com.cognitive.newsreader.test;

import static org.junit.Assert.fail;

import java.net.URL;

import org.apache.log4j.Logger;
import org.junit.Test;

import de.l3s.boilerpipe.extractors.ArticleExtractor;

public class TestBoilerplatePipe {
	
	private static final Logger LOGGER = Logger.getLogger(TestBoilerplatePipe.class);

	@Test
	public void test() {
		
		URL url;
		try {
			url = new URL("http://esportes.terra.com.br/meu-sonho-ainda-nao-acabou-diz-um-emocionado-neymar-em-video-apos-lesao,6fafd4675d707410VgnCLD200000b1bf46d0RCRD.html");
			   // NOTE: Use ArticleExtractor unless DefaultExtractor gives better results for you
			String text = ArticleExtractor.INSTANCE.getText(url);
			LOGGER.info(text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
