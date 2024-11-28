package microteam.root.HybridApp.Services;

//package com.eshop.hybridapp.services;

import microteam.webappcomponents.Services.IProductImageUrlProvider;

public class ProductImageUrlProvider implements IProductImageUrlProvider {

    private static final String MOBILE_BFF_HOST = "http://localhost:11632/";

    @Override
    public String getProductImageUrl(int productId) {
        return MOBILE_BFF_HOST + "api/catalog/items/" + productId + "/pic?api-version=1.0";
    }
}

