package org.example;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DataModel {
    @CsvBindByName(column = "State Code")
    private String stateCode;
    @CsvBindByName(column = "County Code")
    private String countyCode;
    @CsvBindByName(column = "Site Num")
    private String siteNum;
    @CsvBindByName(column = "Parameter Code")
    private String parameterCode;
    @CsvBindByName(column = "POC")
    private String poc;
    @CsvBindByName(column = "Datum")
    private String datum;
    @CsvBindByName(column = "Parameter Name")
    private String parameterName;
    @CsvBindByName(column = "Sample Duration")
    private String sampleDuration;
    @CsvBindByName(column = "Pollutant Standard")
    private String pollutantStandard;
    @CsvBindByName(column = "Metric Used")
    private String metricUsed;
    @CsvBindByName(column = "Method Name")
    private String methodName;
    @CsvBindByName(column = "Year")
    private String year;
    @CsvBindByName(column = "Units of Measure")
    private String unitsOfMeasure;
    @CsvBindByName(column = "Event Type")
    private String eventType;
    @CsvBindByName(column = "Observation Count")
    private String observationCount;
    @CsvBindByName(column = "Observation Percent")
    private String observationPercent;
    @CsvBindByName(column = "Valid Day Count")
    private String validDayCount;
    @CsvBindByName(column = "Required Day Count")
    private String requiredDayCount;
    @CsvBindByName(column = "Exceptional Data Count")
    private String exceptionalDataCount;
    @CsvBindByName(column = "Null Data Count")
    private String nullDataCount;
    @CsvBindByName(column = "Primary Exceedance Count")
    private String primaryExceedanceCount;
    @CsvBindByName(column = "Secondary Exceedance Count")
    private String secondaryExceedanceCount;
    @CsvBindByName(column = "Certification Indicator")
    private String certificationIndicator;
    @CsvBindByName(column = "Num Obs Below MDL")
    private String numObsBelowMDL;
    @CsvBindByName(column = "Arithmetic Mean")
    private String arithmeticMean;
    @CsvBindByName(column = "Arithmetic Standard Dev")
    private String arithmeticStandardDev;
    @CsvBindByName(column = "1st Max Value")
    private String firstMaxValue;
    @CsvBindByName(column = "1st Max DateTime")
    private String firstMaxDateTime;
    @CsvBindByName(column = "2nd Max Value")
    private String secondMaxValue;
    @CsvBindByName(column = "2nd Max DateTime")
    private String secondMaxDateTime;
    @CsvBindByName(column = "3rd Max Value")
    private String thirdMaxValue;
    @CsvBindByName(column = "3rd Max DateTime")
    private String thirdMaxDateTime;
    @CsvBindByName(column = "4th Max Value")
    private String fourthMaxValue;
    @CsvBindByName(column = "4th Max DateTime")
    private String fourthMaxDateTime;
    @CsvBindByName(column = "1st Max Non Overlapping Value")
    private String firstMaxNonOverlappingValue;
    @CsvBindByName(column = "1st NO Max DateTime")
    private String firstNOMaxDateTime;
    @CsvBindByName(column = "2nd Max Non Overlapping Value")
    private String secondMaxNonOverlappingValue;
    @CsvBindByName(column = "2nd NO Max DateTime")
    private String secondNOMaxDateTime;
    @CsvBindByName(column = "99th Percentile")
    private String percentile99th;
    @CsvBindByName(column = "98th Percentile")
    private String percentile98th;
    @CsvBindByName(column = "95th Percentile")
    private String percentile95th;
    @CsvBindByName(column = "90th Percentile")
    private String percentile90th;
    @CsvBindByName(column = "75th Percentile")
    private String percentile75th;
    @CsvBindByName(column = "50th Percentile")
    private String percentile50th;
    @CsvBindByName(column = "10th Percentile")
    private String percentile10th;
    @CsvBindByName(column = "Local Site Name")
    private String localSiteName;
    @CsvBindByName(column = "State Name")
    private String stateName;
    @CsvBindByName(column = "County Name")
    private String countyName;
    @CsvBindByName(column = "City Name")
    private String cityName;
    @CsvBindByName(column = "CBSA Name")
    private String cbsaName;
    @CsvBindByName(column = "Date of Last Change")
    private String dateOfLastChange;
    @CsvBindByName(column = "Location 1")
    private String location1;

    @Override
    public String toString() {
        return "State Code='" + stateCode + "', " +
                "County Code='" + countyCode + "', " +
                "Site Num='" + siteNum + "', " +
                "Parameter Code='" + parameterCode + "', " +
                "POC='" + poc + "', " +
                "Datum='" + datum + "', " +
                "Parameter Name='" + parameterName + "', " +
                "Sample Duration='" + sampleDuration + "', " +
                "Pollutant Standard='" + pollutantStandard + "', " +
                "Metric Used='" + metricUsed + "', " +
                "Method Name='" + methodName + "', " +
                "Year='" + year + "', " +
                "Units of Measure='" + unitsOfMeasure + "', " +
                "Event Type='" + eventType + "', " +
                "Observation Count='" + observationCount + "', " +
                "Observation Percent='" + observationPercent + "', " +
                "Valid Day Count='" + validDayCount + "', " +
                "Required Day Count='" + requiredDayCount + "', " +
                "Exceptional Data Count='" + exceptionalDataCount + "', " +
                "Null Data Count='" + nullDataCount + "', " +
                "Primary Exceedance Count='" + primaryExceedanceCount + "', " +
                "Secondary Exceedance Count='" + secondaryExceedanceCount + "', " +
                "Certification Indicator='" + certificationIndicator + "', " +
                "Num Obs Below MDL='" + numObsBelowMDL + "', " +
                "Arithmetic Mean='" + arithmeticMean + "', " +
                "Arithmetic Standard Dev='" + arithmeticStandardDev + "', " +
                "1st Max Value='" + firstMaxValue + "', " +
                "1st Max DateTime='" + firstMaxDateTime + "', " +
                "2nd Max Value='" + secondMaxValue + "', " +
                "2nd Max DateTime='" + secondMaxDateTime + "', " +
                "3rd Max Value='" + thirdMaxValue + "', " +
                "3rd Max DateTime='" + thirdMaxDateTime + "', " +
                "4th Max Value='" + fourthMaxValue + "', " +
                "4th Max DateTime='" + fourthMaxDateTime + "', " +
                "1st Max Non Overlapping Value='" + firstMaxNonOverlappingValue + "', " +
                "1st NO Max DateTime='" + firstNOMaxDateTime + "', " +
                "2nd Max Non Overlapping Value='" + secondMaxNonOverlappingValue + "', " +
                "2nd NO Max DateTime='" + secondNOMaxDateTime + "', " +
                "99th Percentile='" + percentile99th + "', " +
                "98th Percentile='" + percentile98th + "', " +
                "95th Percentile='" + percentile95th + "', " +
                "90th Percentile='" + percentile90th + "', " +
                "75th Percentile='" + percentile75th + "', " +
                "50th Percentile='" + percentile50th + "', " +
                "10th Percentile='" + percentile10th + "', " +
                "Local Site Name='" + localSiteName + "', " +
                "State Name='" + stateName + "', " +
                "County Name='" + countyName + "', " +
                "City Name='" + cityName + "', " +
                "CBSA Name='" + cbsaName + "', " +
                "Date of Last Change='" + dateOfLastChange + "', " +
                "Location 1='" + location1;
    }
}
