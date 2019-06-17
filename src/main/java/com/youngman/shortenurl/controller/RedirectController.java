package com.youngman.shortenurl.controller;

import com.youngman.shortenurl.service.shorten.ShortenUrlCreateService;
import com.youngman.shortenurl.service.shorten.ShortenUrlFetchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by YoungMan on 2019-05-27.
 */

@Controller
@RequiredArgsConstructor
@RequestMapping("/shorten")
public class RedirectController {

	private final ShortenUrlFetchService shortenUrlFetchService;


	@GetMapping("/{randomString}")
	public String redirectToOriginalUrl(@PathVariable("randomString") String randomString) {
		return "redirect:" + shortenUrlFetchService.fetchOriginalUrl(randomString);
	}

}
