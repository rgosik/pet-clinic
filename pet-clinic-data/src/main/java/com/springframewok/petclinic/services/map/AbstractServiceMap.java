package com.springframewok.petclinic.services.map;

import com.springframewok.petclinic.model.BaseEntity;
import com.springframewok.petclinic.services.CrudService;

import java.util.*;


public abstract class AbstractServiceMap<T extends BaseEntity> implements CrudService<T> {
    protected final Map<Long, T> map = new HashMap<>();

    @Override
    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public T findById(Long id) {
        return map.get(id);
    }

    @Override
    public void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    @Override
    public void deleteById(Long id) {
        map.remove(id);
    }

    @Override
    public T save(T object) {
        if (object == null) {
            throw new IllegalStateException("Can't save null!");
        } else if (object.getId() == null) {
            object.setId(getNextId());
        }

        map.put(object.getId(), object);
        return object;
    }

    private Long getNextId() {
        return map.keySet().isEmpty() ? 1L : Collections.max(map.keySet()) + 1;
    }
}
