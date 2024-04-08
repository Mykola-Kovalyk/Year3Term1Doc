package com.lpnu.iot.cornerstoneondemand.structure.repositories;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.apache.commons.lang3.ArrayUtils;

public abstract class CSVRepository<Resource extends com.lpnu.iot.cornerstoneondemand.resources.Resource> {

    private final Map<Long, Resource> dataTable = new HashMap<>();
    @Getter
    @Setter(AccessLevel.PROTECTED)
    private String resourceRootPath;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private String resourceName;

    @Getter
    private long idSequence = 0;

    public CSVRepository(String resourceName) {
        this("data/data.csv", resourceName);
    }

    public CSVRepository(String filePath, String resourceName) {
        this.resourceRootPath = filePath;
        this.resourceName = resourceName;

        try {
            var rootDir = new File(filePath).getParent();
            if (rootDir != null && rootDir.length() > 0) {
                new File(rootDir).mkdirs();
            }
        } catch (Exception e) {
            System.out.println(this.getClass().toString() + ": Failed to create dirs:");
            e.printStackTrace();
        }

        try {
            readFromFile();
        } catch (IOException exc) {
            try {
                System.out.println(this.getClass().toString() + ": CSV file not found, creating a new one...");
                syncToFile();
            } catch (Exception internalExc) {
                System.out.println(this.getClass().toString() + ": An error occurred while initializing a file: "
                        + internalExc.getMessage());
                internalExc.printStackTrace();
            }
        } catch (Exception exc) {
            System.out.println(
                    this.getClass().toString() + ": An error occurred while reading a file: " + exc.getMessage());
            exc.printStackTrace();
        }
    }

    public Map<Long, Resource> findAll() {
        return Collections.unmodifiableMap(dataTable);
    }

    public Resource findById(Long id) {
        return dataTable.get(id);
    }

    public Map<Long, Resource> findAll(Predicate<Resource> predicate) {

        Map<Long, Resource> returned = new HashMap<>();
        for (var pair : dataTable.entrySet()) {
            if (predicate.test(pair.getValue())) {
                returned.put(pair.getKey(), pair.getValue());
            }
        }
        return returned;
    }

    public Resource findAny(Predicate<Resource> predicate) {

        for (var pair : dataTable.entrySet()) {
            if (predicate.test(pair.getValue())) {
                return pair.getValue();
            }
        }
        return null;
    }

    public Resource add(Resource newResource) {
        idSequence++;
        newResource.setId(idSequence);
        dataTable.put(idSequence, newResource);

        return newResource;
    }

    public Resource replace(Long idToReplace, Resource newResource) {
        return dataTable.replace(idToReplace, newResource);
    }

    public Resource addOrGetIfPresent(Long id, Resource newResource) {
        return dataTable.putIfAbsent(id, newResource);
    }

    public Resource remove(Long idToRemove) {
        return dataTable.remove(idToRemove);
    }

    public void removeAll() {
        dataTable.clear();
    }

    public void removeIf(Predicate<Resource> predicate) {
        dataTable.entrySet().removeIf(entry -> predicate.test(entry.getValue()));
    }

    public void readFromFile() throws IOException, CsvValidationException {
        removeAll();

        idSequence = 0;
        try (FileReader fileReader = new FileReader(resourceRootPath);
                CSVReader reader = new CSVReader(fileReader)) {

            String[] header = newResource().getFieldNames();
            header = ArrayUtils.addAll(header, new String[] { resourceName });

            findHeader(reader, header);

            String[] record;
            while ((record = reader.readNext()) != null) {
                if (record.length == 0 || record[0].equals("id"))
                    break;

                                Resource newResource = newResource();
                newResource.setFieldValues(record);

                if (newResource.getId() > idSequence) {
                    idSequence = newResource.getId();
                }

                dataTable.put(newResource.getId(), newResource);
            }
        }
    }

    private void findHeader(CSVReader reader, String[] header) throws IOException, CsvValidationException {
        String[] record;

        boolean headerFound = false;
        while ((record = reader.readNext()) != null) {
            if (recordEqual(record, header)) {
                headerFound = true;
                break;
            }
        }

        if (!headerFound) {
            throw new IOException("Header not found in the file");
        }
    }

    private static boolean recordEqual(String[] record, String[] header) {

        if (record.length != header.length) {
            return false;
        }

        for (int i = 0; i < record.length; i++) {
            if (!record[i].equals(header[i])) {
                return false;
            }
        }

        return true;
    }

    public void syncToFile() throws IOException, CsvValidationException {
        idSequence = 0;
        File tableFile = Paths.get(
                resourceRootPath).toFile();

        String[] header = newResource().getFieldNames();
        header = ArrayUtils.addAll(header, new String[] { resourceName });

        if (!tableFile.exists()) {
            dataTable.clear();
            tableFile.getAbsoluteFile().getParentFile().mkdirs();
            tableFile.createNewFile();
        }

        List<String[]> records = new ArrayList<>();

        try (FileReader fileReader = new FileReader(resourceRootPath);
                CSVReader reader = new CSVReader(fileReader)) {

            String[] record;

            boolean thisResource = false;
            while ((record = reader.readNext()) != null) {
                if (recordEqual(record, header))
                    thisResource = true;
                else if (record.length > 0 && record[0].equals("id"))
                    thisResource = false;

                if (thisResource)
                    continue;

                records.add(record);
            }
        }

        tableFile.delete();

        try (FileWriter fileWriter = new FileWriter(tableFile);
                CSVWriter writer = new CSVWriter(fileWriter)) {

            for (String[] record : records)
                writer.writeNext(record, false);

            writer.writeNext(header, false);

            for (Map.Entry<Long, Resource> entry : dataTable.entrySet()) {
                writer.writeNext(entry.getValue().getFieldValues(), false);

                if (entry.getKey() > idSequence)
                    idSequence = entry.getKey();
            }
        }
    }

    public abstract Resource newResource();
}
