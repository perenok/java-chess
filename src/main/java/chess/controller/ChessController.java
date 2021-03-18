package chess.controller;

import chess.domain.Board;
import chess.domain.Position;
import chess.exception.ChessException;
import chess.exception.ImpossibleMoveException;
import chess.exception.PieceNotFoundException;
import chess.util.StringPositionConverter;
import chess.view.InputView;
import chess.view.OutputView;
import chess.view.dto.PositionsDto;

public class ChessController {

    static Board board;


    public static void playChess() {
        start();
        while (true) {
            move();
        }
    }

    public static void start() {
        board = new Board();
        OutputView.printBoard(board.nameGroupingByPosition());
    }

    public static void end() {

    }

    public static void move() {
        try {
            PositionsDto positionsDto = InputView.positionDto();
            Position currentPosition = StringPositionConverter.convert(positionsDto.getCurrentPosition());
            Position targetPosition = StringPositionConverter.convert(positionsDto.getTargetPosition());
            board.move(currentPosition, targetPosition);
            OutputView.printBoard(board.nameGroupingByPosition());
        } catch (ChessException e) {
            System.out.println(e.getMessage());
            move();
        }

    }
}
