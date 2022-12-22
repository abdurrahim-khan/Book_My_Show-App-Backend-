package com.example.bookmyshow.dto.responsedto;

import com.example.bookmyshow.enums.TheatreType;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TheatreResponseDto {
    private int id;
    private String name;
    private String city;
    private String address;
    private TheatreType theatreType;
}
