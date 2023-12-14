package com.ll.sb20231208.domain.article.article.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArticle is a Querydsl query type for Article
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QArticle extends EntityPathBase<Article> {

    private static final long serialVersionUID = -280071441L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QArticle article = new QArticle("article");

    public final com.ll.sb20231208.global.jpa.baseEntity.QBaseEntity _super = new com.ll.sb20231208.global.jpa.baseEntity.QBaseEntity(this);

    public final com.ll.sb20231208.domain.member.member.entity.QMember author;

    public final StringPath body = createString("body");

    public final ListPath<com.ll.sb20231208.domain.article.articleComment.entity.ArticleComment, com.ll.sb20231208.domain.article.articleComment.entity.QArticleComment> comments = this.<com.ll.sb20231208.domain.article.articleComment.entity.ArticleComment, com.ll.sb20231208.domain.article.articleComment.entity.QArticleComment>createList("comments", com.ll.sb20231208.domain.article.articleComment.entity.ArticleComment.class, com.ll.sb20231208.domain.article.articleComment.entity.QArticleComment.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifyDate = _super.modifyDate;

    public final ListPath<com.ll.sb20231208.domain.article.articleTag.entity.ArticleTag, com.ll.sb20231208.domain.article.articleTag.entity.QArticleTag> tags = this.<com.ll.sb20231208.domain.article.articleTag.entity.ArticleTag, com.ll.sb20231208.domain.article.articleTag.entity.QArticleTag>createList("tags", com.ll.sb20231208.domain.article.articleTag.entity.ArticleTag.class, com.ll.sb20231208.domain.article.articleTag.entity.QArticleTag.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    public QArticle(String variable) {
        this(Article.class, forVariable(variable), INITS);
    }

    public QArticle(Path<? extends Article> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QArticle(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QArticle(PathMetadata metadata, PathInits inits) {
        this(Article.class, metadata, inits);
    }

    public QArticle(Class<? extends Article> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.author = inits.isInitialized("author") ? new com.ll.sb20231208.domain.member.member.entity.QMember(forProperty("author")) : null;
    }

}

