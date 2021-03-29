package chess;

import chess.controller.WebChessAction;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Map;

import static spark.Spark.*;

public class WebUIChessApplication {
    public static void main(String[] args) {
        port(8082);
        staticFiles.location("/static");

        get("/", WebChessAction.getInstance()::index);

        get("/start", WebChessAction.getInstance()::start);
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
