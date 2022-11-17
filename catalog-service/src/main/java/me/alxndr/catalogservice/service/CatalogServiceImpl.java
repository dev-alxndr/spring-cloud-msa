package me.alxndr.catalogservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.alxndr.catalogservice.entity.Catalog;
import me.alxndr.catalogservice.entity.CatalogRepository;
import me.alxndr.catalogservice.vo.ResponseCatalog;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author : Alexander Choi
 * @date : 2022/11/17
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogRepository;
    private final ModelMapper modelMapper;

    @Override
    public Iterable<ResponseCatalog> getAllCatalogs() {
        final Iterable<Catalog> catalogs = catalogRepository.findAll();

        final List<ResponseCatalog> responseCatalogs = StreamSupport.stream(catalogs.spliterator(), false)
                        .map(c -> modelMapper.map(c, ResponseCatalog.class))
                        .collect(Collectors.toList());

        return responseCatalogs;
    }
}
