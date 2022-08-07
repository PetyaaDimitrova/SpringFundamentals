package bg.softuni.mobilelle.mobilelle.model.view;

import java.util.List;

public class BrandViewModel {

    private String name;

    private List<ModelViewModel> model;

    public List<ModelViewModel> getModel() {
        return model;
    }

    public void setModel(List<ModelViewModel> model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BrandViewModel{" +
                "name='" + name + '\'' +
                ", model=" + model +
                '}';
    }
}
