package chess.view.dto;

public class PositionsDto {
    private String currentPosition;
    private String targetPosition;

    public PositionsDto(String currentPosition, String targetPosition) {
        this.currentPosition = currentPosition;
        this.targetPosition = targetPosition;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public String getTargetPosition() {
        return targetPosition;
    }
}
