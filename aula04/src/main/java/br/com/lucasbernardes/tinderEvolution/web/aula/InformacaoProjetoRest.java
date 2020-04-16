package br.com.lucasbernardes.tinderEvolution.web.aula;

import br.com.lucasbernardes.tinderEvolution.domain.InfoProjeto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/info")
public class InformacaoProjetoRest {

    private static int contador =1;
    private static List<InfoProjeto> lista = new ArrayList<>();


    @GetMapping("/list")
    public List<InfoProjeto> listarInfos(){
        return lista;
    }

    @PostMapping

    public InfoProjeto salvar(@RequestBody InfoProjeto teste) {
        System.out.println(teste);
        teste.setId(contador++);
        lista.add(teste);
        return teste;
    }

    @PutMapping("{id}")
    public InfoProjeto editaProjeto(@PathVariable int id, InfoProjeto teste){
        for (InfoProjeto info : lista){
            if(info.getId()==id){
                return info;
            }
        }
        return null;
    }





}
