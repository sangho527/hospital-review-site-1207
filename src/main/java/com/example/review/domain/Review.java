package com.example.review.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Review {

    @Id
    private Long id;
    private String title; // 리뷰 제목
    private String content; // 리뷰 내용
    private String userName;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;
}