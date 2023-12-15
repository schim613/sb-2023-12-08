package com.ll.sb20231208.domain.article.article.service;

import com.ll.sb20231208.domain.article.article.entity.Article;
import com.ll.sb20231208.domain.article.article.repository.ArticleRepository;
import com.ll.sb20231208.domain.member.member.entity.Member;
import com.ll.sb20231208.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Transactional
    public RsData<Article> write(long authorId, String title, String body) {
        Article article = Article.builder()
                .modifyDate(LocalDateTime.now())
                .author(Member.builder().id(authorId).build()) // 숫자를 객체로 바꿨다
                .title(title)
                .body(body)
                .build();

        articleRepository.save(article);

        return RsData.of("200", "%s번 게시글이 작성되었습니다".formatted(article.getId()), article);
    }

    public Optional<Article> findById(long id) {
        return articleRepository.findById(id);
    }

    @Transactional // select가 아닌 update, insert, delete가 실행되어야 하면 꼭 붙여야 한다.
    public void modify(Article article, String title, String body) {
        article.setTitle(title);
        article.setBody(body); // 객체 내용을 바꾸면 더티 체킹을 이용해서 트랜잭션이 끝날 때 DB에 반영
    }

    public List<Article> findAll() {
        return articleRepository.findByOrderByIdDesc();
    }

    public Page<Article> search(List<String> kwTypes, String kw, Pageable pageable) {
        return articleRepository.search(kwTypes, kw, pageable);
    }
}
