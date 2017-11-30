package kz.epam.tam.module3.lecture234.taxistation.utils;

import kz.epam.tam.module3.lecture234.taxistation.model.PassengerTaxi;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.EmptySearchResultException;

import java.util.List;

public class FindByParameter {

    public static String findACarByParameter(String value, List<PassengerTaxi> list)throws EmptySearchResultException{
        String carOutPut = "Search result:";
        for( PassengerTaxi passengerTaxi : list){
            if(value.equals(passengerTaxi.getModel())){
                carOutPut += "\n" + passengerTaxi.getInfo();
            }
            else if(Integer.parseInt(value) == passengerTaxi.getFuelConsumption()){
                carOutPut += "\n" + passengerTaxi.getInfo();
            }
            else if(Long.parseLong(value) == passengerTaxi.getVehiclePrice()){
                carOutPut += "\n" + passengerTaxi.getInfo();
            }
            else if(value.equals(passengerTaxi.getBodyType())){
                carOutPut += "\n" + passengerTaxi.getInfo();
            }
        }
        if(carOutPut.equals("Search result:")){
            throw new EmptySearchResultException(carOutPut + " nothing found!");
        }else{
            System.out.println(carOutPut);
        }
        return carOutPut;
    }
}

