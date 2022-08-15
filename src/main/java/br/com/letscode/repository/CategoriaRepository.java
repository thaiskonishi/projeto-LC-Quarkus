package br.com.letscode.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.letscode.model.Categoria;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CategoriaRepository implements PanacheRepository<Categoria>{
    
}
