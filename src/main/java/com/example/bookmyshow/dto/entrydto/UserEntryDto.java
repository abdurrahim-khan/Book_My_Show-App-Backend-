package com.example.bookmyshow.dto.entrydto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntryDto {
    @NonNull
    private String name;
    @NonNull
    private String mobile;
}
