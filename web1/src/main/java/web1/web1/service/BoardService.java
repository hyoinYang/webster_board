package web1.web1.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import web1.web1.domain.GroupEntity;
import jakarta.transaction.Transactional;
import web1.web1.domain.*;
import web1.web1.repository.BoardRepository;
import web1.web1.dto.BoardDto;


import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @PostConstruct
    public void PostConstruct(){
        if (boardRepository == null){
            throw new IllegalStateException("ERROR");
        }
    }

    private DevLocation location = DevLocation.함께식당;


    private DevNumberOfPeople numberOfPeople = DevNumberOfPeople.TWO;


    private GenderType gender = GenderType.BOYS;


    private DevSelectTime selectTime = DevSelectTime.ELEVENOCLOCK;

    private GroupEntity groupEntity;

    private BoardDto convertEntityToDto(GroupEntity groupEntity) {
        return BoardDto.builder()
                .id(groupEntity.getId())
                .location(groupEntity.getLocation())
                .numberOfPeople(groupEntity.getNumberOfPeople())
                .gender(groupEntity.getGender())
                .localDateTime(groupEntity.getLocalDateTime())
                .build();
    }

    @Transactional
    public List<BoardDto> getBoardlist() {
        List<GroupEntity> groupEntities = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for (GroupEntity groupEntity : groupEntities){
            boardDtoList.add(this.convertEntityToDto(groupEntity));
        }

        return boardDtoList;
    }


    @Transactional
    public void deletePost(Long id) {
        boardRepository.deleteById(id);
    }


}
