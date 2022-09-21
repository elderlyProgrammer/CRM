package com.eldery.crm.service;

import com.eldery.crm.exception.PositionNotFoundException;
import com.eldery.crm.model.Position;

public interface PositionService {

    Position findPositionById(Long id);

    void removePositionById(Long id) throws PositionNotFoundException;

    void save(Position position);
}
