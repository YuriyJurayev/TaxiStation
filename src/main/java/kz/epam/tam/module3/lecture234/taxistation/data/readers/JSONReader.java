package kz.epam.tam.module3.lecture234.taxistation.data.readers;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import kz.epam.tam.module3.lecture234.taxistation.model.Taxi;
import kz.epam.tam.module3.lecture234.taxistation.utils.AddCarsToListJsonHelper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class JSONReader implements IReader {

    public List<Taxi> readData(){
        Gson gson = new Gson();
        AddCarsToListJsonHelper jsonHelper;
        List<Taxi> data = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(ResourceBundle.getBundle("filepath").getString("json")));
            jsonHelper = gson.fromJson(reader,AddCarsToListJsonHelper.class);
            data = jsonHelper.getTaxis();
        } catch (IOException|JsonSyntaxException e) {
            e.printStackTrace();
        }catch (NumberFormatException e) {
            e.getCause();
        }
        return data;
    }
}
