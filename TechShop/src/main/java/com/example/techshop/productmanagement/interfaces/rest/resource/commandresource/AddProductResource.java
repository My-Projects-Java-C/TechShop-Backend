package com.example.techshop.productmanagement.interfaces.rest.resource.commandresource;

import java.util.List;

public record AddProductResource(Long profileId, String computerComponent,
                                 List<String> categories, Long stock, Float unitPrice) {
}
