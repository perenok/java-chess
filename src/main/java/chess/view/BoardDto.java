package chess.view;

import java.util.List;

public class BoardDto {

    private final List<PieceDto> pieces;
    private final int boardSize;
    private final String currentTeam;

    public BoardDto(List<PieceDto> pieces, int boardSize, String currentTeam) {
        this.pieces = pieces;
        this.boardSize = boardSize;
        this.currentTeam = currentTeam;
    }

    public Map<Position, String> board() {
        return board;
    }

    public int boardSize() {
        return boardSize;
    }

    public String getCurrentTeam() {
        return currentTeam;
    }
}
