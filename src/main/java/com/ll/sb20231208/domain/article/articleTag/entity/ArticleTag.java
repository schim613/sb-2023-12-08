package com.ll.sb20231208.domain.article.articleTag.entity;


import com.ll.sb20231208.domain.article.article.entity.Article;
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
public class ArticleTag extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private Article article;
    private String content;
}
