package pl.edu.wat.flatmates.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonDeserialize(builder = ShoppingListDto.ShoppingListDtoBuilder.class)
public class ShoppingListDto {

    private String description;

    @JsonPOJOBuilder(withPrefix = "")
    public static class ShoppingListDtoBuilder {
    }

    @Builder
    public ShoppingListDto(String description){
        this.description = description;
    }

}
