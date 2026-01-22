package com.example.API_Fabrica_Software.DTO.AuthDTO;

import lombok.Builder;

@Builder
public record ResponseAuthDTO(String toker, String refreshToker) {
 
}
