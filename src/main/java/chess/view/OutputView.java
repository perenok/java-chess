package chess.view;

import chess.domain.game.ChessResult;
import chess.domain.Position;
import chess.domain.TeamColor;

import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class OutputView {

    private static final String SCORE_FORM = "%s팀 : %.1f" + System.lineSeparator();
    private static final String WINNER_FORM = "%s팀 승리!";

    private OutputView() {
    }

    public static void printByFormat(String format, Object... message) {
        System.out.printf(format, message);
    }

    public static void printBoard(BoardDto boardDto) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int y = boardDto.getBoardSize() - 1; y >= 0; y--) {
            appendPieceNames(boardDto, stringBuilder, y);
            stringBuilder.append(System.lineSeparator());
        }
        System.out.println(stringBuilder);
    }

    private static void appendPieceNames(BoardDto boardDto, StringBuilder stringBuilder, int column) {
        stringBuilder.append(IntStream.range(0, boardDto.getBoardSize())
                .mapToObj(x -> Position.of(x, column))
                .map(currentPosition -> boardDto.getBoard().getOrDefault(currentPosition, "."))
                .collect(Collectors.joining()));
    }

    public static void printStartGame() {
        System.out.println("> 체스 게임을 시작합니다.\n" +
                "> 게임 시작 : start\n" +
                "> 게임 종료 : end\n" +
                "> 게임 이동 : move source위치 target위치 - 예. move b2 b3");
    }

    public static void printCheck() {
        System.out.println("체크!");
    }

    public static void printResult(ChessResult chessResult) {
        printByFormat(SCORE_FORM, TeamColor.WHITE, chessResult.whiteTeamScore().value());
        printByFormat(SCORE_FORM, TeamColor.BLACK, chessResult.blackTeamScore().value());
        TeamColor winner = TeamColor.BLACK;
        if (chessResult.whiteTeamScore().isBiggerThan(chessResult.blackTeamScore())) {
            winner = TeamColor.WHITE;
        }
        printWinner(winner);
    }

    public static void printWinner(TeamColor teamColor) {
        printByFormat(WINNER_FORM, teamColor);
    }
}
