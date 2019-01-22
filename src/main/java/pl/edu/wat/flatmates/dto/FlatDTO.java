package pl.edu.wat.flatmates.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonDeserialize(builder = FlatDTO.FlatDTOBuilder.class)
public class FlatDTO {

    private String flatName;
    private String pass;

    @JsonPOJOBuilder(withPrefix = "")
    public static class FlatDTOBuilder {
    }

    @Builder
    public FlatDTO(String flatName, String pass){
        this.flatName = flatName;
        this.pass = pass;
    }

}
