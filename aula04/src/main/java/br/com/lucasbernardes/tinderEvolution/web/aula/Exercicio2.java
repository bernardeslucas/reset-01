package br.com.lucasbernardes.tinderEvolution.web.aula;

import br.com.lucasbernardes.tinderEvolution.domain.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ex2")
public class Exercicio2 {

    private int contador = 1;
    private List<Usuario> listUsuario = new ArrayList<>();


    @GetMapping("/usuarios")
    public List<Usuario> listar() {
        return listUsuario;
    }

    @GetMapping("/usuarios/{id}")
    public Usuario listaIndex(@PathVariable("id") int id) {
        return listUsuario.get(id);
    }

    @PostMapping("/usuarios")
    public void cadastrar(@RequestBody Usuario usuario) {
        usuario.setId(contador++);
        listar().add(usuario);
    }

    @PutMapping("/usuarios/{id}")
    public void atualizarUsuario(@PathVariable("id") int id, @RequestBody Usuario usuario) {
        for (Usuario u : listUsuario) {
            if (u.getId() == id) {
                u.setNome(usuario.getNome());
                u.setIdade(usuario.getIdade());
            }
        }
    }

    @DeleteMapping("/usuarios/{id}")
    public void deletarUsuario(@PathVariable("id") int id) {
        for (Usuario user : listUsuario) {
            if (user.getId() == id) {
                listUsuario.remove(user);
            }
        }
    }


}














