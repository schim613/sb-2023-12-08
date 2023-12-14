package com.ll.sb20231208.domain.article.article.service;

import com.ll.sb20231208.domain.article.article.entity.Article;
import com.ll.sb20231208.domain.article.articleComment.entity.ArticleComment;
import com.ll.sb20231208.domain.member.member.entity.Member;
import com.ll.sb20231208.domain.member.member.service.MemberService;
import com.ll.sb20231208.global.rsData.RsData;
import com.ll.sb20231208.standard.util.Ut;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
// @Rollback(false)
public class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private MemberService memberService;

    @DisplayName("글 쓰기")
    @Test
    void t1() {
        RsData<Article> writeRs = articleService.write(1, "제목", "내용");
        Article article = writeRs.getData();

        assertThat(article.getId()).isGreaterThan(0L);
    }

    @DisplayName("1번 글의 작성사의 username 은 user1 이다.")
    @Test
    void t2() {
        Article article = articleService.findById(1L).get();
        Member author = article.getAuthor();

        assertThat(author.getUsername()).isEqualTo("user1");
    }

    @DisplayName("1번 글을 가져온다.")
    @Test
    void t3() {
        Article article = articleService.findById(1L).get();
        assertThat(article.getTitle()).isEqualTo("제목1");
    }

    @DisplayName("1번 글의 제목을 수정한다.")
    @Test
    void t4() {
        Article article = articleService.findById(1L).get();

        Ut.thread.sleep(1000);

        articleService.modify(article, "수정된 제목", "수정된 내용");

        Article article_ = articleService.findById(1L).get();

        assertThat(article_.getTitle()).isEqualTo("수정된 제목");
    }

    @DisplayName("2번 글에 댓글들을 추가한다.")
    @Test
    void t5() {
        Member member1 = memberService.findById(1L).get();
        Article article2 = articleService.findById(2L).get();

        article2.addComment(member1, "댓글1");
    }

    @DisplayName("1번 글의 댓글들을 수정한다.")
    @Test
    void t6() {
        Article article1 = articleService.findById(1L).get();

        article1.getComments().getLast().setBody("수정된 댓글");
    }

    @DisplayName("1번 글의 댓글 중 마지막 것을 삭제한다.")
    @Test
    @Rollback(false)
    void t7() {
        Article article1 = articleService.findById(1L).get();

        ArticleComment lastComment = article1.getComments().getLast();
        article1.removeComment(lastComment); // 즉시 삭제가 되는게 아니라 로직이 다 끝나고 실행 -> 충돌할 수 있어서 즉시 삭제 명령어 찾아보기

        // 로직
        // 로직
        // 로직
    }

    @DisplayName("게시물 별 댓글 수 출력")
    @Test
    void t8() {
        List<Article> articles = articleService.findAll();

        articles.forEach(article -> {
            System.out.println("게시물 번호: " + article.getId());
            System.out.println("댓글 수: " + article.getComments().size());
        });
    }
}