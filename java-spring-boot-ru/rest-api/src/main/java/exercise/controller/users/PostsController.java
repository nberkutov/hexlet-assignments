package exercise.controller.users;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

import static exercise.Data.getPosts;

@RestController
@RequestMapping("/api/users")
public class PostsController {
    private static final List<Post> posts = getPosts();

    @GetMapping("/{id}/posts")
    public ResponseEntity<List<Post>> userPosts(@PathVariable int id) {
        return ResponseEntity.ok(posts.stream().filter(post -> post.getUserId() == id).toList());
    }

    @PostMapping("/{id}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@PathVariable int id, @RequestBody Post post) {
        Post newPost = new Post();
        newPost.setUserId(id);
        newPost.setBody(post.getBody());
        newPost.setSlug(post.getSlug());
        newPost.setTitle(post.getTitle());
        posts.add(newPost);
        return newPost;
    }
}
