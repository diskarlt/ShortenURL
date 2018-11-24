package com.example.shorten_url.domain.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ShortenUrlData {
	@Id
	@Column(unique=true, nullable=false)
	private String base62Id;
	@Column(unique=true, nullable=false)
	private String targetUrl;
	@Column(unique=true, nullable=false)
	private String shortenUrl;
}