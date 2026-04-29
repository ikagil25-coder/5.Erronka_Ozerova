import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

/**
 * XML fitxategiak kudeatzeko eta transformatzeko klasea.
 */
public class XmlKudeatzailea {

    /**
     * XML fitxategi bat HTMLra transformatzen du XSLT bidez, aurretik XSDarekin balidatuz.
     *
     * @param xmlPath  XML fitxategiaren bidea
     * @param xsltPath XSLT fitxategiaren bidea
     * @param xsdPath  XSD fitxategiaren bidea
     * @param outPath  Sortuko den HTML fitxategiaren bidea
     * @return true transformazioa ondo egin bada, false bestela
     */
    public static boolean transformatuXmlHtmln(String xmlPath, String xsltPath, String xsdPath, String outPath) {
        try {
            // 1. XSD Balidazioa
            System.out.println("XMLa balidatzen " + xsdPath + " erabiliz...");
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
            System.out.println("XMLa baliozkoa da.");

            // 2. XSLT Transformazioa
            System.out.println("HTMLa sortzen XSLT transformazioa aplikatuz...");
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Source xslt = new StreamSource(new File(xsltPath));
            Transformer transformer = tFactory.newTransformer(xslt);

            Source xml = new StreamSource(new File(xmlPath));
            transformer.transform(xml, new StreamResult(new File(outPath)));

            System.out.println("Transformazioa amaituta: " + outPath);
            return true;

        } catch (Exception e) {
            System.err.println("ERROREA XML/XSLT prozesuan: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        // Test moduan exekutatzeko (bideak proiektuaren egituraren arabera)
        String xml = "xml/donazioak.xml";
        String xsl = "xml/donazioak.xsl";
        String xsd = "xml/donazioak.xsd";
        String out = "xml/donazioak.html";
        
        transformatuXmlHtmln(xml, xsl, xsd, out);
    }
}
