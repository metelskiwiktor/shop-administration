package pl.wiktor.shop.shopadministration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import pl.wiktor.shop.shopadministration.model.dto.request.AuthorDTO;
import pl.wiktor.shop.shopadministration.model.entity.Author;
import pl.wiktor.shop.shopadministration.model.mapper.AuthorMapper;
import pl.wiktor.shop.shopadministration.repository.AuthorRepositoryJpa;
import pl.wiktor.shop.shopadministration.service.AuthorService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepositoryJpa authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepositoryJpa authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void add(AuthorDTO authorDTO) throws IllegalArgumentException, DataIntegrityViolationException {
        Author author = AuthorMapper.map(authorDTO);
        authorRepository.save(author);
    }

    public void edit(int idOldAuthor, AuthorDTO authorDTO) throws NullPointerException{
        Author author = authorRepository.getOne(idOldAuthor);
        author.setName(authorDTO.getName());
        author.setAboutAuthor(authorDTO.getAboutAuthor());
        authorRepository.save(author);
    }

    public void delete(int id) throws EmptyResultDataAccessException {
        authorRepository.deleteById(id);
    }

    public List<Author> getAll(){
        return authorRepository.findAll();
    }
}
