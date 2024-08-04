
interface Document {
    void open();
}

// WordDocument.java - Concrete Document Class
class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening a Word document.");
        // Actual logic to open a Word document
    }
}

// PdfDocument.java - Concrete Document Class
class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening a PDF document.");
        // Actual logic to open a PDF document
    }
}

// ExcelDocument.java - Concrete Document Class
class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening an Excel document.");
        // Actual logic to open an Excel document
    }
}

// DocumentFactory.java - Abstract Factory Class
abstract class DocumentFactory {
    public abstract Document createDocument();
}

// WordDocumentFactory.java - Concrete Factory for Word Documents
class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

// PdfDocumentFactory.java - Concrete Factory for PDF Documents
class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

// ExcelDocumentFactory.java - Concrete Factory for Excel Documents
class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}

// TestFactoryMethodPattern.java - Test Class
public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        // Create a factory for each document type
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        // Create documents using the factories
        Document wordDoc = wordFactory.createDocument();
        Document pdfDoc = pdfFactory.createDocument();
        Document excelDoc = excelFactory.createDocument();

        // Open the documents
        wordDoc.open();
        pdfDoc.open();
        excelDoc.open();
    }
}