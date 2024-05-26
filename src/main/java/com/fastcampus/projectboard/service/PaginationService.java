package com.fastcampus.projectboard.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class PaginationService {

    //페이징은 고정적으로 5개 가지도록 변수 선언하였습니다.
    private static final int BAR_LENGTH = 5;

    //현재 페이지 번호와 전체 페이지를 가져와줍니다.
    public List<Integer> getPaginationBarNumbers(int currentPageNumber, int totalPages) {
        int startNumber = Math.max(currentPageNumber - (BAR_LENGTH / 2), 0);
        int endNumber = Math.min(startNumber + BAR_LENGTH, totalPages);

        return IntStream.range(startNumber, endNumber).boxed().toList();
    }

    //페이징바 길이 조회 가능하도록 하기 위해 생성하였습니다.
    public int currentBarLength() {
        return BAR_LENGTH;
    }
}
