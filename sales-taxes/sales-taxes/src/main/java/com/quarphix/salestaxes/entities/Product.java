package com.quarphix.salestaxes.entities;

import com.quarphix.salestaxes.enums.Status;
import com.quarphix.salestaxes.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private String name;
    private boolean isImport ;
    private Type productType;// We can have a department instead.
    private double price;
    private Status status;
}
