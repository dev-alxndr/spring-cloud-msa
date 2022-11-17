package me.alxndr.catalogservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.alxndr.catalogservice.service.CatalogService;
import me.alxndr.catalogservice.vo.ResponseCatalog;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : Alexander Choi
 * @date : 2022/11/17
 */
@Slf4j
@RestController
@RequestMapping("/catalog-service")
@RequiredArgsConstructor
public class CatalogController {

    private final Environment environment;
    private final CatalogService catalogService;

    @GetMapping("/catalogs")
    public ResponseEntity<Iterable<ResponseCatalog>> getCatalogs() {
        final Iterable<ResponseCatalog> catalogs = catalogService.getAllCatalogs();

        return ResponseEntity.status(HttpStatus.OK).body(catalogs);
    }


    @GetMapping("/health-check")
    public String status() {
        return String.format("Catalog Service is UP! on PORT %s", environment.getProperty("local.server.port"));
    }



}
