package br.com.letscode.model;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/categoria/lista")
@RegisterRestClient(configKey = "quarkus-api")
public class CategoriaService {
    
    @Inject
    CategoriaRepository categoriaRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categoria> listaCategorias() {
        return categoriaRepository.listAll();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void cadastraCategoria(Categoria categoria) {
        categoriaRepository.persist(categoria);
    }

    @PUT
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Categoria alteraDados(CategoriaForm categoriaForm, Long id){
        Optional<Categoria> categoriaOptional =  categoriaRepository.findByIdOptional(id);
        if(categoriaOptional.isPresent()){
            categoriaOptional.get().setNome(categoriaForm.getNome());
            return categoriaOptional.get();
        }
        return null;
    }

    @DELETE
    @Transactional
    public Categoria deletaCategoria(Long idcategoria){
    Optional<Categoria> categoriaOptional =categoriaRepository.findByIdOptional(idcategoria);
    if(categoriaOptional.isPresent()){
        categoriaRepository.deleteById(idcategoria);
        return categoriaOptional.get();
    }
    return null;
    
    }
}
