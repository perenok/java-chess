package chess.controller;

import chess.domain.game.ChessGame;
import chess.view.BoardDto;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

import static chess.WebUIChessApplication.render;

public class WebChessAction {

    private static WebChessAction instance;
    private ChessGame chessGame;

    private WebChessAction(){
    }

    public static WebChessAction getInstance(){
        if(instance == null){
            instance = new WebChessAction();
        }
        return instance;
    }

    public String index(Request req, Response res) {
        Map<String, Object> model = new HashMap<>();
        return render(model, "index.html");
    }

    public String start(Request req, Response res) {
        chessGame = new ChessGame();
        Map<String, Object> model = new HashMap<>();
        BoardDto dto = new BoardDto(chessGame.nameGroupingByPosition2(), chessGame.boardSize());
        model.put("pieces", dto);
        return render(model, "game.html");
    }

//    public GameStatus end() {
//        return GameStatus.EXIT;
//    }
//
//    public GameStatus move(String message) throws PieceNotFoundException, ImpossibleMoveException {
//        List<Position> positions = MessagePositionConverter.convert(message);
//        Position currentPosition = positions.get(0);
//        Position targetPosition = positions.get(1);
//        chessGame.move(currentPosition, targetPosition);
//
//        OutputView.printBoard(new BoardDto(chessGame.nameGroupingByPosition(), chessGame.boardSize()));
//
//        return chessStatus();
//    }
//
//    private GameStatus chessStatus() {
//        if (chessGame.isKingDead()) {
//            OutputView.printWinner(chessGame.enemyColor());
//            return GameStatus.EXIT;
//        }
//        if (chessGame.checked()) {
//            OutputView.printCheck();
//        }
//        return GameStatus.RUN;
//    }
//
//    public GameStatus status() {
//        ChessResult chessResult = chessGame.result();
//        OutputView.printResult(chessResult);
//        return GameStatus.EXIT;
//    }
}
