package com.ibm.spring.core.di.interfaces;

public class CustomerDAO {
    private  Repository repository;

    public CustomerDAO() {
    }

    public CustomerDAO(Repository repository) {
        this.repository = repository;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }
}
