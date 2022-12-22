package com.example.bookmyshow.dto.responsedto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserResponseDto {
    private  int id;
    @NonNull
    private String name;
    @NonNull
    private String mobile;
}
