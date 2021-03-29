package chess.view;

import chess.domain.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BoardDto {

    private final Map<PositionDto, String> board;
    private final int boardSize;

    public BoardDto(Map<PositionDto, String> board, int boardSize) {
        this.board = board;
        this.boardSize = boardSize;
    }

    public Map<PositionDto, String> getBoard() {
        return board;
    }

    public int getBoardSize() {
        return boardSize;
    }

}
