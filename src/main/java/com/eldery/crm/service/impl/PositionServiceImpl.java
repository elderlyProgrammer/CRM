package com.eldery.crm.service.impl;

import com.eldery.crm.exception.PositionNotFoundException;
import com.eldery.crm.model.Position;
import com.eldery.crm.repository.PositionRepository;
import com.eldery.crm.service.PositionService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter
@Getter
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    public Position findPositionById(Long id) {
        return positionRepository.findById(id).orElse(null);
    }

    public void removePositionById(Long id) throws PositionNotFoundException {
        try {
            positionRepository.deleteById(id);

        } catch (Exception exception) {
            throw new PositionNotFoundException();
        }


    }

    public void save(Position position) {
        positionRepository.save(position);
    }


}
