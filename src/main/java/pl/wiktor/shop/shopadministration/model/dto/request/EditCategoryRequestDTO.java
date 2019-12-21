package pl.wiktor.shop.shopadministration.model.dto.request;

public class EditCategoryRequestDTO {
    private String oldNameCategory;
    private String newNameCategory;

    public EditCategoryRequestDTO(String oldNameCategory, String newNameCategory) {
        this.oldNameCategory = oldNameCategory;
        this.newNameCategory = newNameCategory;
    }

    public String getOldNameCategory() {
        return oldNameCategory;
    }

    public String getNewNameCategory() {
        return newNameCategory;
    }
}
