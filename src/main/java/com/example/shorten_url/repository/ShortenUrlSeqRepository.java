package com.example.shorten_url.repository;

import com.example.shorten_url.domain.model.entity.ShortenUrlSeq;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ShortenUrlSeqRepository extends CrudRepository<ShortenUrlSeq, Long> {
	@Query(value = "SELECT NEXTVAL(url_seq)", nativeQuery = true)
	public Long nextId();
}