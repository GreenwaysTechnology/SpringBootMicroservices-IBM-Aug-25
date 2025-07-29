package com.ibm.spring.core.di.interfaces;

import java.util.List;

public class SQLRepositoryImpl implements Repository{
    @Override
    public List<String> findAll() {
        return List.of("CRETE","UPDATE","Delete","SELECT");
    }
}
