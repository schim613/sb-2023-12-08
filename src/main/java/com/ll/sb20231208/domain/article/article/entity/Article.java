package com.ll.sb20231208.domain.article.article.entity;

import com.ll.sb20231208.domain.member.member.entity.Member;
import com.ll.sb20231208.global.jpa.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@SuperBuilder
@Getter
@Setter
@ToString(callSuper = true)
public class Article extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) // 항상 LAZY 로딩으로 바꿀 것
    private Member author;
    private String title;
    private String body;
}
