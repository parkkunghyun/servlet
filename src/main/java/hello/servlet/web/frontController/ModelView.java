package hello.servlet.web.frontController;

import java.util.HashMap;
import java.util.Map;

public class ModelView {
    // request.setAttribute의 역할을 할 예정!

    private String viewName;

    //여기에 원하는 데이터 넣고 jsp에서 사용하게 만들기!
    private Map<String,Object> model = new HashMap<>();

    public ModelView(String viewName) {
        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }
}
