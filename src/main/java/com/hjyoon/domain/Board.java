package com.hjyoon.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by user on 2018-08-13.
 */

@Getter
@Setter
@ToString
@Entity(name="tbl_boards")
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bno;
	private String title;
	private String writer;
	private String content;

	@CreationTimestamp
	private Timestamp regdate;
	@UpdateTimestamp
	private Timestamp updatedate;

}
