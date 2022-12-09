package com.example.review.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Hospital {

    @Id
    private Long id;
    private String hospitalName; // 병원이름
    private String roadNameAddress; // 도로명 주소


    @OneToMany(mappedBy = "hospital" , fetch = FetchType.LAZY) // 양방향 매핑 , LAZT가 권장됨
    private List<Review> reviews;

}
