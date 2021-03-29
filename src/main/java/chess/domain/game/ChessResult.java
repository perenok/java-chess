package chess.domain.game;

import chess.domain.Score;

public class ChessResult {
    private final Score whiteTeamScore;
    private final Score blackTeamScore;

    public ChessResult(Score whiteTeamScore, Score blackTeamScore) {
        this.whiteTeamScore = whiteTeamScore;
        this.blackTeamScore = blackTeamScore;
    }

    public Score whiteTeamScore() {
        return whiteTeamScore;
    }

    public Score blackTeamScore() {
        return blackTeamScore;
    }
}
