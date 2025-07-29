package com.ibm.spring.core.di.interfaces;

import java.util.List;

public class NQSQLRepositoryImpl implements Repository{
    @Override
    public List<String> findAll() {
        return List.of("SET","GET");
    }
}
