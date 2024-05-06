package com.fastcampus.projectboard.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaginationService {

    //페이징은 고정적으로 5개 가지도록 변수 선언하였습니다.
    private static final int BAR_LENGTH = 5;

    //현재 페이지 번호와 전체 페이지를 가져와줍니다.
    public List<Integer> getPaginationBarNumbers(int currentPageNumber, int totalPages) {
        return null;
    }

    //페이징바 길이 조회 가능하도록 하기 위해 생성하였습니다.
    public int currentBarLength() {
        return BAR_LENGTH;
    }
}
