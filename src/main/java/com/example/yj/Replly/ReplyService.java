package com.example.yj.Replly;

import com.example.yj.entity.Post;
import com.example.yj.entity.Reply;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository repository;

    public void createReplService(String loginId, String content, Post post){ //댓글 달기
        Reply reply = Reply.builder()
                .content(content)
                .replyId(loginId)
                .replyDate(LocalDate.now())
                .post(post)
                .build();

        repository.save(reply);
    }

    public void modifyReply(Long rno, String content) { //댓글 수정
        Optional<Reply> result = repository.findById(rno);
        if (result.isPresent()) {
            Reply reply1 = result.get();
            reply1.update(content);
            repository.save(reply1);
        }
    }

}
