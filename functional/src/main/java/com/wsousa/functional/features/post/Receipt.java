package com.wsousa.functional.features.post;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Receipt {
    String item;
    double price;
    double discount;
    double tax;

}
