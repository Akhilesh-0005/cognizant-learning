// ── Document Interface ──
interface Document {
    void open();
    void save();
}

// ── Concrete Document Classes ──
class WordDocument implements Document {
    public void open()  { System.out.println("Opening Word Document (.docx)"); }
    public void save()  { System.out.println("Saving Word Document (.docx)"); }
}

class PdfDocument implements Document {
    public void open()  { System.out.println("Opening PDF Document (.pdf)"); }
    public void save()  { System.out.println("Saving PDF Document (.pdf)"); }
}

class ExcelDocument implements Document {
    public void open()  { System.out.println("Opening Excel Document (.xlsx)"); }
    public void save()  { System.out.println("Saving Excel Document (.xlsx)"); }
}

// ── Abstract Factory ──
abstract class DocumentFactory {
    public abstract Document createDocument();

    public void openDocument() {
        Document doc = createDocument();
        doc.open();
    }
}

// ── Concrete Factories ──
class WordDocumentFactory extends DocumentFactory {
    public Document createDocument() { return new WordDocument(); }
}

class PdfDocumentFactory extends DocumentFactory {
    public Document createDocument() { return new PdfDocument(); }
}

class ExcelDocumentFactory extends DocumentFactory {
    public Document createDocument() { return new ExcelDocument(); }
}

// ── Test Class ──
public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        System.out.println("=== Factory Method Pattern — Document Management ===\n");

        DocumentFactory wordFactory  = new WordDocumentFactory();
        DocumentFactory pdfFactory   = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        Document word  = wordFactory.createDocument();
        Document pdf   = pdfFactory.createDocument();
        Document excel = excelFactory.createDocument();

        word.open();  word.save();
        pdf.open();   pdf.save();
        excel.open(); excel.save();

        System.out.println("\nFactory Method Pattern implemented successfully.");
    }
}
