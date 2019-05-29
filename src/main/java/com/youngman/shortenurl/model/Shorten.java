package com.youngman.shortenurl.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YoungMan on 2019-05-27.
 */

@Entity
@Table(name = "shorten_tbl")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Shorten {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shorten_id")
	private Long id;

	@Column(nullable = false)
	private String originalUrl;

	@Column(unique = true, nullable = false)
	private String randomString;

	@OneToMany(mappedBy = "shorten", fetch = FetchType.LAZY)
	private List<Statistics> statistics = new ArrayList<>();


	@Builder
	public Shorten(String originalUrl, String randomString, List<Statistics> statistics) {
		this.originalUrl = originalUrl;
		this.randomString = randomString;
		this.statistics = statistics;
	}

	public static Shorten of(String originalUrl, String randomString) {
		return Shorten.builder()
				.originalUrl(originalUrl)
				.randomString(randomString)
				.build();
	}
}
