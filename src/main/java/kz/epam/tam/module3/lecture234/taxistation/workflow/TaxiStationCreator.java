package kz.epam.tam.module3.lecture234.taxistation.workflow;

import kz.epam.tam.module3.lecture234.taxistation.data.writers.TxtFileWriter;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.DataReaderNotFoundException;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidDataException;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidListSizeException;
import kz.epam.tam.module3.lecture234.taxistation.model.CargoTaxi;
import kz.epam.tam.module3.lecture234.taxistation.model.PassengerTaxi;
import kz.epam.tam.module3.lecture234.taxistation.model.Taxi;
import kz.epam.tam.module3.lecture234.taxistation.modules.*;

import java.util.ArrayList;
import java.util.List;

public class TaxiStationCreator {

    public void createTaxiStation(){

        System.out.println("Start");
        ///add
        List<PassengerTaxi> pTaxiList = new ArrayList<>();
        List<CargoTaxi> cTaxiList = new ArrayList<>();
        List<Taxi> taxiList = new ArrayList<>();
        String errors = null;
       
        try {
            pTaxiList = Adder.addPassengerTaxi();
            cTaxiList = Adder.addCargoTaxi();
            taxiList.addAll(pTaxiList);

        }catch (DataReaderNotFoundException e){
            errors = e.getMessage();
            System.out.println(e.getMessage());
        }catch (InvalidListSizeException e) {
            errors = e.getMessage()+ " Actual number of fields is " + e.getExceptionCause() +
                    ". Please check an input data and try again!";
            System.out.println(e.getMessage() + " Actual number of fields is " + e.getExceptionCause() +
                    ". Please check an input data and try again!");
        }catch (InvalidDataException ide) {
            errors = ide.getMessage() + "Found: price is " + ide.getExceptionPrice() +
                    ", consumption is " + ide.getExceptionConsumption();
            System.out.println(ide.getMessage() + "Found: price is " + ide.getExceptionPrice() +
                    ", consumption is " + ide.getExceptionConsumption());
        }
        //// add to list for saving
        List<String> addedCarsList = new ArrayList<>();
        Converter.convertObjectsToString(pTaxiList,addedCarsList);
/// count price
        long countCar = Counter.countCarsPrice(pTaxiList);
///sort
        List<String> sortedList = new ArrayList<>();
        Sorter.sortCars(pTaxiList,sortedList);
///search
        String search = Searcher.searchACar(pTaxiList);
        ////write
        TxtFileWriter writer = new TxtFileWriter();
        writer.writeToFile(countCar, addedCarsList, sortedList, search, errors);
        System.out.println("Exit");
    }
}

