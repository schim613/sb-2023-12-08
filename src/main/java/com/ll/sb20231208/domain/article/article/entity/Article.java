package com.ll.sb20231208.domain.article.article.entity;

import com.ll.sb20231208.domain.member.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY) // 항상 LAZY 로딩으로 바꿀 것
    private Member author;
    private String title;
    private String body;
}
