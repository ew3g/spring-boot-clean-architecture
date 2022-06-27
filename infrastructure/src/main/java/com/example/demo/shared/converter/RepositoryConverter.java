package com.example.demo.shared.converter;

import java.io.Serializable;

public interface RepositoryConverter <T extends Serializable, P extends Serializable> {
    T toTable(final P persistenceObject);
    P toModel(final T tableObject);
}
