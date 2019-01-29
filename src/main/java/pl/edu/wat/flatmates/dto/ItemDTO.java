package pl.edu.wat.flatmates.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonDeserialize(builder = ItemDTO.ItemDTOBuilder.class)
public class ItemDTO {

    private String description;
    private double price;
    private Integer listId;

    @JsonPOJOBuilder(withPrefix = "")
    public static class ItemDTOBuilder {
    }

    @Builder
    public ItemDTO (String description, double price, Integer listId){
        this.description = description;
        this.price = price;
        this.listId = listId;
    }
}
