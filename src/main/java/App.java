import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;


/**
 * Created by Guest on 8/7/17.
 */
public class App {

    public static void main(String[] args) {

        staticFileLocation("/public");

        get("/form", (request,response)-> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/changeOut", (request, response) -> {
            String totalCash = request.queryParams("totalCash");
            String inputName = request.queryParams("inputName");
            ChangeMachine newChangeMachine = new ChangeMachine();
            Map <String, Object> model = new HashMap<String,Object>();
            model.put("changeString",newChangeMachine.makeChange(Float.parseFloat(totalCash)));
            model.put("totalCash",totalCash);
            model.put("inputName",inputName);
            return new ModelAndView(model, "changeOut.hbs");

        }, new HandlebarsTemplateEngine());

    }
}


