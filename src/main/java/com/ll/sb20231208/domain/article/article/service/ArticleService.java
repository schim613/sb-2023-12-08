package com.ll.sb20231208.domain.article.article.service;

import com.ll.sb20231208.domain.article.article.entity.Article;
import com.ll.sb20231208.domain.article.article.repository.ArticleRepository;
import com.ll.sb20231208.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Transactional
    public RsData<Article> write(long authorId, String title, String body) {
        Article article = Article.builder()
                .authorId(authorId)
                .title(title)
                .body(body)
                .build();

        articleRepository.save(article);

        return RsData.of("200", "%s번 게시글이 작성되었습니다".formatted(article.getId()), article);
    }

    public Optional<Article> findById(long id) {
        return articleRepository.findById(id);
    }
}
