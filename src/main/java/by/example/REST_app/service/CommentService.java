package by.example.REST_app.service;

import by.example.REST_app.domain.Comment;
import by.example.REST_app.domain.User;
import by.example.REST_app.domain.Views;
import by.example.REST_app.dto.EventType;
import by.example.REST_app.dto.ObjectType;
import by.example.REST_app.repo.CommentRepo;
import by.example.REST_app.util.WsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.BiConsumer;

@Service
public class CommentService {
    private final CommentRepo commentRepo;
    private final BiConsumer<EventType, Comment> wsSender;

    @Autowired
    public CommentService(CommentRepo commentRepo, WsSender wsSender) {
        this.commentRepo = commentRepo;
        this.wsSender = wsSender.getSender(ObjectType.COMMENT, Views.FullComment.class);
    }

    public Comment create(Comment comment, User user) {
        comment.setAuthor(user);
        Comment commentFromDb = commentRepo.save(comment);

        wsSender.accept(EventType.CREATE, commentFromDb);

        return commentFromDb;
    }
}