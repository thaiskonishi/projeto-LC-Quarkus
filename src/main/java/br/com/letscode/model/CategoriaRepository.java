package br.com.letscode.model;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CategoriaRepository implements PanacheRepository<Categoria>{
    
}
