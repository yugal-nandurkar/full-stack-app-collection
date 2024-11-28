package microteam.root.HybridApp.Services;

//package com.eshop.hybridapp.services;

import com.eshop.webappcomponents.catalog.CatalogBrand;
import com.eshop.webappcomponents.catalog.CatalogItem;
import com.eshop.webappcomponents.catalog.CatalogItemType;
import com.eshop.webappcomponents.catalog.CatalogResult;

import java.util.List;

public interface ICatalogService {
    CatalogItem getCatalogItem(int id);

    CatalogResult getCatalogItems(int pageIndex, int pageSize, Integer brand, Integer type);

    List<CatalogItem> getCatalogItems(List<Integer> ids);

    CatalogResult getCatalogItemsWithSemanticRelevance(int page, int take, String text);

    List<CatalogBrand> getBrands();

    List<CatalogItemType> getTypes();
}
