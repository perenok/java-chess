package chess.view;

import chess.domain.Position;

public class PositionDto {

    private final int x;
    private final int y;

    public PositionDto(Position position) {
        this.x = position.row();
        this.y = position.column();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
