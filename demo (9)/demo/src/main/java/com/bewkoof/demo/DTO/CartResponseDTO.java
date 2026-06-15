package com.bewkoof.demo.DTO;

public record CartResponseDTO(int ProdId,
        String ProductName, String ProductDesc,
        int quantity, int price) {
}
