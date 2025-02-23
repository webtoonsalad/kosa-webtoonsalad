package com.webtoonsalad.mapper;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webtoonsalad.dto.CommentDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CommentMapperTests {

    @Autowired
    private CommentMapper mapper;

    @Test
    public void testWriteComment() throws SQLException {
    	String content = "잼나다~";
        String userId = "test2";
        String webtoonId = "kakao_3071";

        log.info("Writing comment with content: " + content + ", userId: " + userId + ", webtoonId: " + webtoonId);
        mapper.writeComment(content, userId, webtoonId);
        log.info("한줄평 작성 성공");
    }
    
    @Test
    public void testGetMyComment() throws SQLException {
        String userId = "test2";
        String webtoonId = "kakao_3071";
        log.info("한줄평 나타내기");

        log.info("Retrieving my comment with userId: " + userId + " and webtoonId: " + webtoonId);
        mapper.getMyComment(userId, webtoonId);
        
    }
    
    @Test
    public void testEditComment() throws SQLException {
    	String content = "해피엔딩...";
    	String userId = "test2";
        String webtoonId = "kakao_3071";

        mapper.editComment(content, userId, webtoonId);
        
        log.info("수정 완료");
    }

    @Test
    public void testDeleteComment() throws SQLException {
        String userId = "test2";
        String webtoonId = "kakao_3071";
        mapper.deleteComment(userId, webtoonId);
        log.info("한줄평 삭제 완료");
    }
    

    @Test
    public void testGetCommentList() throws SQLException {
        String userId1 = "guest";
        String webtoonId = "kakao_2995";

        List<CommentDTO> comments = mapper.getCommentList(userId1,webtoonId);
        for (CommentDTO comment : comments) {
            log.info(comment);
        }
    }

}
