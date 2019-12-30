package pl.wiktor.shop.shopadministration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import pl.wiktor.shop.shopadministration.model.dto.request.ItemDTO;
import pl.wiktor.shop.shopadministration.model.entity.Item;
import pl.wiktor.shop.shopadministration.model.mapper.ItemMapper;
import pl.wiktor.shop.shopadministration.repository.ItemRepositoryJpa;
import pl.wiktor.shop.shopadministration.service.ItemService;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ItemServiceImpl implements ItemService {
    private ItemRepositoryJpa itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepositoryJpa itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void add(ItemDTO itemDTO) throws IllegalArgumentException, DataIntegrityViolationException {
        Item item = ItemMapper.map(itemDTO);
        itemRepository.save(item);
    }

    public void edit(int idOldItem, ItemDTO itemDTO) throws NullPointerException{
        Item item = itemRepository.getOne(idOldItem);
        item.setName(itemDTO.getName());
        itemRepository.save(item);
    }

    public void delete(int id) throws EmptyResultDataAccessException {
        itemRepository.deleteById(id);
    }

    public List<Item> getAll(){
        return itemRepository.findAll();
    }
}
