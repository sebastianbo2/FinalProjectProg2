package org.example;

import publications.Magazine;
import publications.Novel;
import publications.Publication;
import publications.ReferenceBook;
import users.BasicMember;
import users.Librarian;
import users.StudentMember;

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

    private static final String studentMembersPath = "src/main/resources/students.csv";
    private static final String basicMembersPath = "src/main/resources/basicMembers.csv";
    private static final String librariansPath = "src/main/resources/librarians.csv";

    public static List<Novel> novels = initNovels(novelsPath);
    public static List<ReferenceBook> referenceBooks = initReferenceBooks(referenceBooksPath);
    public static List<Magazine> magazines = initMagazines(magazinesPath);

    public static List<BasicMember> basicMembers = initBasicMembers(basicMembersPath);
    public static List<StudentMember> studentMembers = initStudentMembers(studentMembersPath);
    public static List<Librarian> librarians = initLibrarians(librariansPath);

    public static void export() {
        File novelsFile = new File(novelsPath);
        File referenceBooksFile = new File(referenceBooksPath);
        File magazinesFile = new File(magazinesPath);
        File basicMembersFile = new File(basicMembersPath);
        File studentMembersFile = new File(studentMembersPath);
        File librariansFile = new File(librariansPath);

        exportNovels(novelsFile);
        exportReferenceBooks(referenceBooksFile);
        exportMagazines(magazinesFile);
        exportBasicMembers(basicMembersFile);
        exportStudentMembers(studentMembersFile);
        exportLibrarians(librariansFile);
    }

    private static void exportLibrarians(File basicMembersFile) {
        try (FileWriter writer = new FileWriter(basicMembersFile, false)) {
            for (Librarian librarian : librarians) {
                writer.write(librarian.getEmail() + ",");
                writer.write(librarian.getName() + ",");
                writer.write(librarian.getHashedPassword() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file, " + e.getMessage());
        }
    }

    private static void exportBasicMembers(File basicMembersFile) {
        try (FileWriter writer = new FileWriter(basicMembersFile, false)) {
            for (BasicMember basicMember : basicMembers) {
                writer.write(basicMember.getEmail() + ",");
                writer.write(basicMember.getName() + ",");
                writer.write(basicMember.getHashedPassword() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file, " + e.getMessage());
        }
    }

    private static void exportStudentMembers(File studentMembersFile) {
        try (FileWriter writer = new FileWriter(studentMembersFile, false)) {
            for (StudentMember studentMember : studentMembers) {
                writer.write(studentMember.getEmail() + ",");
                writer.write(studentMember.getName() + ",");
                writer.write(studentMember.getHashedPassword() + ",");
                writer.write(studentMember.getStudentID() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file, " + e.getMessage());
        }
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

    public static List<Librarian> initLibrarians(String path) {
        File file = new File(path);
        List<Librarian> finalList = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String[] currLine = scanner.nextLine().split(",");

                finalList.add(new Librarian(
                        currLine[0],
                        currLine[1],
                        Integer.parseInt(currLine[2])
                ));
            }
        } catch (IOException e) {
            System.out.println("Error reading from file, " + e.getMessage());
        }

        return finalList;
    }

    public static List<BasicMember> initBasicMembers(String path) {
        File file = new File(path);
        List<BasicMember> finalList = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String[] currLine = scanner.nextLine().split(",");

                finalList.add(new BasicMember(
                        currLine[0],
                        currLine[1],
                        Integer.parseInt(currLine[2])
                ));
            }
        } catch (IOException e) {
            System.out.println("Error reading from file, " + e.getMessage());
        }

        return finalList;
    }

    public static List<StudentMember> initStudentMembers(String path) {
        File file = new File(path);
        List<StudentMember> finalList = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String[] currLine = scanner.nextLine().split(",");

                finalList.add(new StudentMember(
                        currLine[0],
                        currLine[1],
                        Integer.parseInt(currLine[2]),
                        Integer.parseInt(currLine[3])
                ));
            }
        } catch (IOException e) {
            System.out.println("Error reading from file, " + e.getMessage());
        }

        return finalList;
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
