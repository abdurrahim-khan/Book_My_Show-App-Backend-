package com.example.bookmyshow.dto.entrydto;

import com.example.bookmyshow.enums.TheatreType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TheatreEntryDto {
    @NonNull
    private String name;
    @NonNull
    private String city;
    @NonNull
    private String address;
    @NonNull
    private TheatreType theatreType;
}
