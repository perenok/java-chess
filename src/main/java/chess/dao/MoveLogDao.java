package chess.dao;

import chess.db.DBConnection;
import chess.domain.Position;
import chess.util.StringPositionConverter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

public class MoveLogDao {

    private final DBConnection dbConnection = DBConnection.getInstance();

    public void addMoveLog(String currentPosition, String targetPosition, int boardId) throws SQLException {
        String sql = "INSERT INTO move_log(board_id, current_position, target_position) VALUES (?,?,?)";
        PreparedStatement pstmt = dbConnection.connection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setInt(1, boardId);
        pstmt.setString(2, currentPosition);
        pstmt.setString(3, targetPosition);

        if (pstmt.executeUpdate() == 0) {
            throw new IllegalArgumentException("DB에 move_log를 추가할 수 없습니다.");
        }
        pstmt.close();
    }

    public Map<Position, Position> selectAll() throws SQLException {
        String sql = "SELECT * FROM move_log";
        PreparedStatement pstmt = dbConnection.connection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        Map<Position, Position> moveLog = new LinkedHashMap<>();
        while (rs.next()) {
            String current = rs.getString(1);
            String target = rs.getString(2);
            Position currentPosition = StringPositionConverter.convertToPosition(current);
            Position targetPosition = StringPositionConverter.convertToPosition(target);
            moveLog.put(currentPosition, targetPosition);
        }
        rs.close();
        pstmt.close();
        return moveLog;
    }

    public void deleteAll() throws SQLException {
        String sql = "DELETE FROM move_log";
        PreparedStatement pstmt = dbConnection.connection().prepareStatement(sql);
        pstmt.executeUpdate();
        pstmt.close();
    }
}
