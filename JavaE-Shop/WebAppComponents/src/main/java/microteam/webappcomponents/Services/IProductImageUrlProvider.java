package microteam.webappcomponents.Services;

//package com.eshop.webappcomponents.services;

import com.eshop.webappcomponents.catalog.CatalogItem;

public interface IProductImageUrlProvider {

    default String getProductImageUrl(CatalogItem item) {
        return getProductImageUrl(item.getId());
    }

    String getProductImageUrl(int productId);
}

