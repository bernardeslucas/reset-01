package br.com.lucasbernardes.tinderEvolution.web;

import br.com.lucasbernardes.tinderEvolution.domain.Post;
import br.com.lucasbernardes.tinderEvolution.domain.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostRest {

    private int contadorId = 1;
    private List<Post> listaPosts = new ArrayList<>();

    @GetMapping
    public List<Post> all() {
        return listaPosts;
    }

    @GetMapping("/{id}")
    public Post one(@PathVariable("id") int id) {
        for (Post post : listaPosts) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        for (Post post : listaPosts) {
            if (post.getId() == id) {
                listaPosts.remove(post);
            }
        }
    }

    @PostMapping
    public Post create(@RequestBody Post post) {
        post.setId(contadorId++);
        listaPosts.add(post);
        return post;
    }

    @PutMapping("{id}")
    public Post update(@PathVariable int id, @RequestBody Post post){
        Post postToUpdate = one(id);
        if(postToUpdate!=null) {
            postToUpdate.setUserId(post.getUserId());
            postToUpdate.setTitle(post.getTitle());
            postToUpdate.setBody(post.getBody());
            return postToUpdate;
        }

        return null;
    }



}










