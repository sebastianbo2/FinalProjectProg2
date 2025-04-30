package org.example;

import publications.Magazine;
import publications.Novel;
import publications.Publication;
import publications.ReferenceBook;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LibrarySystem {
    private static final String novelsPath = "src/main/resources/novels.csv";
    private static final String referenceBooksPath = "src/main/resources/referenceBooks.csv";
    private static final String magazinesPath = "src/main/resources/magazines.csv";

    public static List<Novel> novels = initNovels(novelsPath);
    public static List<ReferenceBook> referenceBooks = initReferenceBooks(referenceBooksPath);
    public static List<Magazine> magazines = initMagazines(magazinesPath);

    public static void export() {
        File novelsFile = new File(novelsPath);
        File referenceBooksFile = new File(referenceBooksPath);
        File magazinesFile = new File(magazinesPath);

        exportNovels(novelsFile);
        exportReferenceBooks(referenceBooksFile);
        exportMagazines(magazinesFile);
    }

    private static void exportNovels(File novelsFile) {
        try (FileWriter writer = new FileWriter(novelsFile, false)) {
            for (Novel novel : novels) {
                writer.write(novel.getYear() + ",");
                writer.write(novel.getTitle() + ",");
                writer.write(novel.getAuthor() + ",");
                writer.write(novel.getAvailableCopies() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file, " + e.getMessage());
        }
    }

    private static void exportReferenceBooks(File referenceBooksFile) {
        try (FileWriter writer = new FileWriter(referenceBooksFile, false)) {
            for (ReferenceBook referenceBook : referenceBooks) {
                writer.write(referenceBook.getYear() + ",");
                writer.write(referenceBook.getTitle() + ",");
                writer.write(referenceBook.getAuthor() + ",");
                writer.write(referenceBook.getAvailableCopies() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file, " + e.getMessage());
        }
    }

    private static void exportMagazines(File magazinesFile) {
        try (FileWriter writer = new FileWriter(magazinesFile, false)) {
            for (Magazine magazine : magazines) {
                writer.write(magazine.getYear() + ",");
                writer.write(magazine.getTitle() + ",");
                writer.write(magazine.getAuthor() + ",");
                writer.write(magazine.getAvailableCopies() + ",");
                writer.write(magazine.getContentSummary() + "\n");

            }
        } catch (IOException e) {
            System.out.println("Error writing to file, " + e.getMessage());
        }
    }

    public static List<Novel> initNovels(String path) {
        File file = new File(path);
        List<Novel> finalList = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String[] currLine = scanner.nextLine().split(",");

                finalList.add(new Novel(
                        Integer.parseInt(currLine[0]),
                        currLine[1],
                        currLine[2],
                        Integer.parseInt(currLine[3])
                ));
            }
        } catch (IOException e) {
            System.out.println("Error reading from " + path + ", " + e.getMessage());
        }

        return finalList;
    }

    public static List<ReferenceBook> initReferenceBooks(String path) {
        File file = new File(path);
        List<ReferenceBook> finalList = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String[] currLine = scanner.nextLine().split(",");

                finalList.add(new ReferenceBook(
                        Integer.parseInt(currLine[0]),
                        currLine[1],
                        currLine[2],
                        Integer.parseInt(currLine[3])
                ));
            }
        } catch (IOException e) {
            System.out.println("Error reading from " + path + ", " + e.getMessage());
        }

        return finalList;
    }

    public static List<Magazine> initMagazines(String path) {
        File file = new File(path);
        List<Magazine> finalList = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String[] currLine = scanner.nextLine().split(",");

                System.out.println(Arrays.toString(currLine));

                finalList.add(new Magazine(
                        Integer.parseInt(currLine[0]),
                        currLine[1],
                        currLine[2],
                        Integer.parseInt(currLine[3]),
                        currLine[4]
                ));
            }
        } catch (IOException e) {
            System.out.println("Error reading from " + path + ", " + e.getMessage());
        }

        return finalList;
    }
}
