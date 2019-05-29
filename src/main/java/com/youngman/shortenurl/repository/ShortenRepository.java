package com.youngman.shortenurl.repository;

import com.youngman.shortenurl.model.Shorten;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by YoungMan on 2019-05-27.
 */

public interface ShortenRepository extends JpaRepository<Shorten, Long> {

	boolean existsByRandomString(String randomString);

	Optional<Shorten> findByRandomString(String randomString);
}
