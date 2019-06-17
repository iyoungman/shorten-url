package com.youngman.shortenurl.service;

import com.youngman.shortenurl.service.shorten.ShortenUrlCreateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by YoungMan on 2019-05-27.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
//@Transactional
public class ShortenUrlCreateServiceTest {

	@Autowired
	private ShortenUrlCreateService shortenUrlCreateService;

	@Value("${app.path.local}")
	private String local;

	@Value("${app.path.dev}")
	private String dev;


	@Test
	public void createShortenUrl() throws Exception {
		String longUrl = "https://eney.co.kr";
		String shortenUrl = shortenUrlCreateService.createShortenUrl(longUrl);
		System.out.println(shortenUrl);
	}

	@Test
	public void testValue() throws Exception {
		System.out.println(local);
		System.out.println(dev);
	}
}
