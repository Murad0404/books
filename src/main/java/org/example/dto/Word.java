package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Word {
    private Integer id;
    private String wordUz;
    private String wordEng;
    private String description;
}
