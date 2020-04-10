package chess.domain.board;

import chess.domain.piece.position.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class ChessBoardFactoryTest {
    @Test
    @DisplayName("체스판 생성 테스트")
    void createChessBoardTest() {
        List<Position> chessBoard = ChessBoardFactory.create();
        assertThat(chessBoard.size()).isEqualTo(64);
    }
}