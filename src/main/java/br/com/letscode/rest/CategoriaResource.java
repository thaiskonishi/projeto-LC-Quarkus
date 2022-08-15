package br.com.letscode.rest;

import java.net.URI;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import br.com.letscode.dto.CategoriaDto;
import br.com.letscode.form.CategoriaForm;
import br.com.letscode.model.Categoria;
import br.com.letscode.service.CategoriaService;

@Path("/categoria")
@Produces(MediaType.APPLICATION_JSON)
@Transactional
@ApplicationScoped
public class CategoriaResource {
    
    @Inject
    CategoriaService categoriaService;

    @GET
    @Path( "/lista" )
    public List<CategoriaDto> lista() {
        List<Categoria> categorias = categoriaService.listaCategorias();
        return CategoriaDto.converter(categorias);

    }

    @POST
    public Response cadastraCategoria(@Valid CategoriaForm categoriaForm) {
        Categoria novaCategoria = categoriaForm.converter();
        categoriaService.cadastraCategoria(novaCategoria);
        URI uri = UriBuilder.fromPath("/categoria/{idcategoria}").build(novaCategoria.getIdcategoria());
        return Response.created(uri).build();
    }

    @PUT
    @Path("/{idcategoria}")
    public Response alteraDados(@PathParam("idcategoria") Long idcategoria, @RequestBody CategoriaForm categoriaForm) {  
    Categoria categoria = categoriaService.alteraDados(categoriaForm, idcategoria);
    if (categoria != null) {
        return Response.status(Response.Status.OK).entity(new CategoriaDto(categoria)).build();
    }
    return Response.status(Response.Status.NOT_FOUND).build();
    
    }
    // o clientForm é pra pegar no corpo da requisição e não da url
  
    @DELETE
    @Path("/{idcategoria}")
    public Response deletar(@PathParam("idcategoria") Long idcategoria) {
        Categoria categoria = categoriaService.deletaCategoria(idcategoria);
        if (categoria != null) {
            return Response.status(Response.Status.OK).entity(new CategoriaDto(categoria)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
}
