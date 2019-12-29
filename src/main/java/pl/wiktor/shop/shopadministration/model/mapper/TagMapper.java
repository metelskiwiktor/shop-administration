package pl.wiktor.shop.shopadministration.model.mapper;

import pl.wiktor.shop.shopadministration.model.dto.request.TagDTO;
import pl.wiktor.shop.shopadministration.model.entity.Tag;

public abstract class TagMapper {
    public static Tag map(TagDTO tagDTO){
        Tag tag = new Tag();
        tag.setId(tagDTO.getId());
        tag.setName(tagDTO.getName());

        return tag;
    }
}
