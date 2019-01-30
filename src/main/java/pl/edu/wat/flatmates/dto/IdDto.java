package pl.edu.wat.flatmates.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonDeserialize(builder = IdDto.IdDtoBuilder.class)
public class IdDto {
    private Integer id;

    @JsonPOJOBuilder(withPrefix = "")
    public static class IdDtoBuilder {
    }

    @Builder
    public IdDto(Integer id){
        this.id = id;
    }
}
