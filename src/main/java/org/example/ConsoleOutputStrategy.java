package org.example;

import java.util.List;

public class ConsoleOutputStrategy implements Strategy {
    @Override
    public void output(List<DataModel> modelList) {
        for (DataModel model : modelList) {
            System.out.println(model);
        }
    }
}
