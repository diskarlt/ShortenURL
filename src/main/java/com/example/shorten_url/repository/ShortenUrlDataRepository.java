package com.example.shorten_url.repository;

import com.example.shorten_url.domain.model.entity.ShortenUrlData;

import org.springframework.data.repository.CrudRepository;

public interface ShortenUrlDataRepository extends CrudRepository<ShortenUrlData, Long> {
	ShortenUrlData findByBase62Id(String base62Id);
	Boolean existsByTargetUrl(String targetUrl);
	ShortenUrlData findByTargetUrl(String targetUrl);
}