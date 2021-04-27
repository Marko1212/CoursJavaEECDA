package com.formation.webbooks.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "book")
public class BookEntity {
	@Id
	private String id;

	@Column(columnDefinition = "TEXT")
	private String description;
	private String language;
	@Column(name = "page_count")
	private Long pageCount;
	@Column(name = "published_date")
	private String publishedDate;
	@Column(name = "self_link")
	private String selfLink;
	@Column(name = "small_thumbnail")
	private String smallThumbnail;
	private String thumbnail;
	@Column(columnDefinition = "TEXT")
	private String title;

	@ElementCollection
	@CollectionTable(name = "book_model_authors",
			joinColumns = @JoinColumn(name = "book_model_id"))
	@Column(name = "authors")
	private List<String> authors = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "volume_info_id")
	private List<IndustryIdentifiersEntity> industryId;
}
