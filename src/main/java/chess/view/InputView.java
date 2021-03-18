package chess.view;

import chess.exception.ImpossibleMoveException;
import chess.view.dto.PositionsDto;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCAN = new Scanner(System.in);


    public static PositionsDto positionDto() throws ImpossibleMoveException {
        String message = SCAN.nextLine();
        String[] positions = message.split(" ");
        if(positions.length != 2) {
            throw new ImpossibleMoveException();
        }
        String currentPosition = positions[0];
        String targetPosition = positions[1];
        return new PositionsDto(currentPosition, targetPosition);
    }
}
