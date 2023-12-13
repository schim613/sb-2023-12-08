package com.ll.sb20231208.domain.article.articleComment.entity;

import com.ll.sb20231208.domain.article.article.entity.Article;
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
public class ArticleComment extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private Article article; // article_id
    @ManyToOne(fetch = FetchType.LAZY)
    private Member author; // author_id
    private String body;
}
