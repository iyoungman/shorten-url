package com.youngman.shortenurl.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by YoungMan on 2019-05-27.
 */

@Entity
@Table(name = "statistics_tbl")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Statistics {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "statistics_id")
	private Long id;

	@CreationTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime accessTime;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "shorten_id", nullable = false)
	private Shorten shorten;

	@Builder
	public Statistics(Shorten shorten) {
		this.shorten = shorten;
	}

	public static Statistics of(Shorten shorten) {
		return Statistics.builder()
				.shorten(shorten)
				.build();
	}

}
