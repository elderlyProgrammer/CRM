package com.eldery.crm.service;

import com.eldery.crm.exception.PositionNotFoundException;
import com.eldery.crm.model.Position;
import com.eldery.crm.repository.PositionRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Setter
@Getter
@RequiredArgsConstructor
public class PositionService {

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
}
