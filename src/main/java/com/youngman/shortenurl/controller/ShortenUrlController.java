package com.youngman.shortenurl.controller;

import com.youngman.shortenurl.model.dto.ShortenUrlCreateRequestDto;
import com.youngman.shortenurl.service.shorten.ShortenUrlCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YoungMan on 2019-05-27.
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/shorten")
public class ShortenUrlController {

	private final ShortenUrlCreateService shortenUrlCreateService;

	@PostMapping
	public String createShortenUrl(@RequestBody ShortenUrlCreateRequestDto shortenUrlCreateRequestDto) {
		return shortenUrlCreateService.createShortenUrl(shortenUrlCreateRequestDto.getOriginalUrl());
	}

}
