package chess.domain.piece.direction;

import chess.domain.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class PieceDirections {

    private final boolean movableMoreThanOnePosition;
    private final List<Direction> moveDirections;
    private final List<Direction> killDirections;

    public PieceDirections(boolean movableMoreThanOnePosition, List<Direction> moveDirections, List<Direction> killDirections) {
        this.movableMoreThanOnePosition = movableMoreThanOnePosition;
        this.moveDirections = moveDirections;
        this.killDirections = killDirections;
    }

    public List<Position> movablePositions(Position currentPosition, List<Position> existPiecePositions, List<Position> enemyPositions) {
        List<Position> movablePositions = new ArrayList<>();
        addPositionsNotExistPiece(currentPosition, existPiecePositions, movablePositions);
        addKillPositions(currentPosition, enemyPositions, movablePositions);
        return movablePositions;
    }

    public void addPositionsNotExistPiece(Position currentPosition, List<Position> existPiecePositions, List<Position> movablePositions) {
        for (Direction moveDirection : moveDirections) {
            addPositionNotExistPiece(moveDirection, currentPosition, existPiecePositions, movablePositions);
        }
    }

    public void addKillPositions(Position currentPosition, List<Position> enemyPositions, List<Position> movablePositions) {
        for (Direction killDirection : killDirections) {
            addKillPosition(killDirection, currentPosition, enemyPositions, movablePositions);
        }
    }

    private void addPositionNotExistPiece(Direction moveDirection, Position currentPosition,
                                          List<Position> existPiecePositions, List<Position> movablePositions) {
        do {
            if (currentPosition.invalidGo(moveDirection)) {
                return;
            }
            currentPosition = currentPosition.go(moveDirection);

            if (existPiecePositions.contains(currentPosition)) {
                return;
            }
            movablePositions.add(currentPosition);
        } while (movableMoreThanOnePosition);
    }

    private void addKillPosition(Direction killDirection, Position currentPosition,
                                 List<Position> enemyPositions, List<Position> movablePositions) {
        do {
            if (currentPosition.invalidGo(killDirection)) {
                return;
            }
            currentPosition = currentPosition.go(killDirection);

            if (enemyPositions.contains(currentPosition)) {
                movablePositions.add(currentPosition);
                return;
            }
        } while (movableMoreThanOnePosition);
    }

    protected List<Direction> moveDirections() {
        return moveDirections;
    }
}
