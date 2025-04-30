package org.example;

import publications.Magazine;
import publications.Novel;
import publications.Publication;
import publications.ReferenceBook;

import java.util.List;

public class LibrarySystem {
    private static final String novelsPath = "src/main/resources/novels.csv";
    private static final String referenceBooksPath = "src/main/resources/referenceBooks.csv";
    private static final String magazinesPath = "src/main/resources/magazines.csv";
    private static final String publicationsPath = "src/main/resources/publications.csv";

    public static List<Novel> novels;
    public static List<ReferenceBook> referenceBooks;
    public static List<Magazine> magazines;
    public static List<Publication> publications;
}
