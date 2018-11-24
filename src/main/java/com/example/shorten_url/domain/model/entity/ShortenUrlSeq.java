package com.example.shorten_url.domain.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ShortenUrlSeq {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
}