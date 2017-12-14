package kz.epam.tam.module3.lecture234.taxistation.workflow;

import kz.epam.tam.module3.lecture234.taxistation.data.writers.TxtFileWriter;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.DataReaderNotFoundException;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.EmptySearchResultException;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidDataException;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidListSizeException;
import kz.epam.tam.module3.lecture234.taxistation.model.Taxi;
import kz.epam.tam.module3.lecture234.taxistation.model.TaxiStation;
import kz.epam.tam.module3.lecture234.taxistation.modules.*;

import java.util.List;

public class TaxiStationManipulator {

    public void manipulateTaxiStationMainFeatures(){
        TxtFileWriter writer = new TxtFileWriter();
        try {
            TaxiStation station = Adder.addCars();
            writer.writeToFile("Taxis: \n" + station.toString(),false);
            writer.writeToFile("Overall taxis price: \n" + Long.toString(Counter.countCarsPrice(station)),true);
            writer.writeToFile("Sorted taxis: \n" + Sorter.sortCars(station).toString(),true);
            writer.writeToFile(Searcher.searchATaxi(station).toString(),true);
        }catch (DataReaderNotFoundException e){
            writer.writeToFile(e.getMessage(),false);
        }catch (InvalidListSizeException e) {
            writer.writeToFile(e.getMessage()+ " Actual number of fields is " + e.getExceptionCause() +
                    ". Please check an input data and try again!",false);
        }catch (InvalidDataException ide) {
            writer.writeToFile(ide.getMessage() + "Found: price is " + ide.getExceptionPrice() +
                    ", consumption is " + ide.getExceptionConsumption(),false);
        }catch (EmptySearchResultException e) {
            writer.writeToFile(e.getMessage(),true);
        }
    }
}

