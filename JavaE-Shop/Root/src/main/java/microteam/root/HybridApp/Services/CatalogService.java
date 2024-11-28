package microteam.root.HybridApp.Services;

//package com.eshop.hybridapp.services;

import com.eshop.webappcomponents.catalog.CatalogBrand;
import com.eshop.webappcomponents.catalog.CatalogItem;
import com.eshop.webappcomponents.catalog.CatalogItemType;
import com.eshop.webappcomponents.catalog.CatalogResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatalogService implements ICatalogService {

    private final RestTemplate restTemplate;
    private final String remoteServiceBaseUrl = "api/catalog/";

    @Autowired
    public CatalogService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public CatalogItem getCatalogItem(int id) {
        String uri = String.format("%sitems/%d?api-version=1.0", remoteServiceBaseUrl, id);
        return restTemplate.getForObject(uri, CatalogItem.class);
    }

    @Override
    public CatalogResult getCatalogItems(int pageIndex, int pageSize, Integer brand, Integer type) {
        String uri = getAllCatalogItemsUri(remoteServiceBaseUrl, pageIndex, pageSize, brand, type);
        return restTemplate.getForObject(uri, CatalogResult.class);
    }

    @Override
    public List<CatalogItem> getCatalogItems(List<Integer> ids) {
        String uri = remoteServiceBaseUrl + "items/by?ids=" +
                     ids.stream().map(String::valueOf).collect(Collectors.joining("&ids=")) + "&api-version=1.0";
        CatalogItem[] result = restTemplate.getForObject(uri, CatalogItem[].class);
        return result != null ? Arrays.asList(result) : List.of();
    }

    @Override
    public CatalogResult getCatalogItemsWithSemanticRelevance(int page, int take, String text) {
        String encodedText = URLEncoder.encode(text, StandardCharsets.UTF_8);
        String uri = String.format(
                "%sitems/withsemanticrelevance/%s?pageIndex=%d&pageSize=%d&api-version=1.0",
                remoteServiceBaseUrl, encodedText, page, take);
        return restTemplate.getForObject(uri, CatalogResult.class);
    }

    @Override
    public List<CatalogBrand> getBrands() {
        String uri = remoteServiceBaseUrl + "catalogBrands?api-version=1.0";
        CatalogBrand[] result = restTemplate.getForObject(uri, CatalogBrand[].class);
        return result != null ? Arrays.asList(result) : List.of();
    }

    @Override
    public List<CatalogItemType> getTypes() {
        String uri = remoteServiceBaseUrl + "catalogTypes?api-version=1.0";
        CatalogItemType[] result = restTemplate.getForObject(uri, CatalogItemType[].class);
        return result != null ? Arrays.asList(result) : List.of();
    }

    private String getAllCatalogItemsUri(String baseUri, int pageIndex, int pageSize, Integer brand, Integer type) {
        String filterQs;
        if (type != null) {
            String brandQs = brand != null ? brand.toString() : "";
            filterQs = String.format("/type/%d/brand/%s", type, brandQs);
        } else if (brand != null) {
            filterQs = String.format("/type/all/brand/%s", brand);
        } else {
            filterQs = "";
        }
        return UriComponentsBuilder.fromUriString(baseUri + "items" + filterQs)
                .queryParam("pageIndex", pageIndex)
                .queryParam("pageSize", pageSize)
                .queryParam("api-version", "1.0")
                .toUriString();
    }
}




