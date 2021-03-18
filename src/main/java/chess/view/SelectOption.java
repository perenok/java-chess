package chess.view;

import chess.controller.ChessController;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;

//public enum SelectOption {
//    START("start", () -> ChessController.start()),
//    END("end", ChessController::end),
//    MOVE("move", () -> ChessController.move());
//
//    private String message;
//    private Consumer<ChessController> consumer;
//
//    SelectOption(String message, Supplier consumer) {
//        this.message = message;
//        this.consumer = consumer;
//    }
//
//    public static void select(String message) {
//        SelectOption selectOption = Arrays.stream(values())
//                .filter(value -> value.message.equals(message))
//                .findAny()
//                .orElseThrow(() -> new IllegalArgumentException("잘못 입력 하셨습니다."));
//        selectOption.consumer.accept(new ChessController());
//    }
//}
