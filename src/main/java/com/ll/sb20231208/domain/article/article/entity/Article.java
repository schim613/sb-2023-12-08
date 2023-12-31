package com.ll.sb20231208.domain.article.article.entity;

import com.ll.sb20231208.domain.article.articleComment.entity.ArticleComment;
import com.ll.sb20231208.domain.article.articleTag.entity.ArticleTag;
import com.ll.sb20231208.domain.member.member.entity.Member;
import com.ll.sb20231208.global.jpa.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static jakarta.persistence.CascadeType.ALL;
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

    @OneToMany(mappedBy = "article", cascade = ALL, orphanRemoval = true)
    @Builder.Default
    @ToString.Exclude
    private List<ArticleComment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "article", cascade = ALL, orphanRemoval = true)
    @Builder.Default
    @ToString.Exclude
    private List<ArticleTag> tags = new ArrayList<>();

    public void addComment(Member commentAuthor, String commentBody) {
        ArticleComment comment = ArticleComment.builder()
                .article(this)
                .author(commentAuthor)
                .body(commentBody)
                .build();

        comments.add(comment);
    }

    public void removeComment(ArticleComment comment) {
        comments.remove(comment);
    }

    public void addComment(ArticleComment comment) {
        comments.add(comment);
    }

    public void addTag(String tagContent) {
        ArticleTag tag = ArticleTag.builder()
                .article(this)
                .author(author)
                .content(tagContent)
                .build();

        tags.add(tag);
    }

    public void addTag(String...tagContents) {
        for (String tagContent : tagContents) {
            addTag(tagContent);
        }
    }

    public String getTagsStr() {
        String tagsStr = tags
                .stream()
                .map(ArticleTag::getContent)
                .collect(Collectors.joining(" #"));

        if (tagsStr.isBlank()) {
            return "";
        }

        return "#" + tagsStr;
    }
}
